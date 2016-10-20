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
        return Long.valueOf(this.updateTime).compareTo(o.updateTime); //逆序，从大到小
    }
}
