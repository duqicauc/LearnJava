package org.java.learn.compare;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/10/13
 * Time: 17:21
 */
public class ObjectToSort implements Comparable<ObjectToSort> {
    private long updateTime;
    private String name;

    public ObjectToSort(long updateTime, String name) {
        this.updateTime = updateTime;
        this.name = name;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(ObjectToSort o) {
        return Long.valueOf(this.updateTime).compareTo(o.updateTime);
        //long类型使用compareTo方法比较
        //假设A为调用者，B为参数【被比较者】：（1）A和B相等，返回0；（2）A小于B，返回负数；（3）A>B返回正数
    }
}
