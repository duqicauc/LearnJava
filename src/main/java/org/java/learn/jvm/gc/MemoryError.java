package org.java.learn.jvm.gc;

import java.util.HashMap;
import java.util.Vector;

/**
 * 作用: 演示内存溢出的错误，在实际开发中常常犯的一类错误：随意缓存（维护）一些实际不需要的对象的集合，导致内存溢出
 * User: duqi
 * Date: 2017/12/16
 * Time: 14:31
 */
public class MemoryError {

    static Vector employeesList;

    public static void main(String[] args) {
        employeesList = new Vector();
        HashMap employeesMap = new HashMap();
        int i = 0;

        while (true) {
            Emplyee emp1 = new Emplyee("Ram", new Address("MG Road", "Bangalore",
                                                          123, "India"));
            Emplyee emp2 = new Emplyee("Bob", new Address("House No. 4",
                                                          "SCA", 234, "USA"));
            Emplyee emp3 = new Emplyee("John", new Address("Church Street",
                                                          "Bangalore", 569, "India"));
            employeesMap.put(new Integer(i++), emp1);
            employeesList.add(emp1);
            employeesMap.put(new Integer(i++), emp2);
            employeesList.add(emp2);
            employeesMap.put(new Integer(i++), emp3);
            employeesList.add(emp3);

            emp2.addReports(emp1);
            emp3.addReports(emp1);
            emp3.addReports(emp2);
        }

    }

}

class Emplyee {
    public String name;
    public Address address;
    public Vector directReports;

    public Emplyee(String name, Address address) {
        this.name = name;
        this.address = address;
        directReports = new Vector();
    }

    public void addReports(Emplyee emplyee) {
        directReports.add(emplyee);
    }
}

class Address {
    public String addr;
    public String city;
    public int zip;
    public String country;

    public Address(String addr, String city, int zip, String country) {
        this.addr = addr;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }
}
