package co.superclark.entity;

import org.ektorp.support.CouchDbDocument;

/**
 * @Author clark
 * @Date 01-Dec-2015
 */
public class Dog extends CouchDbDocument implements Comparable<Dog> {
    private String name;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Dog dog) {
        return this.name.compareTo(dog.getName());
    }
}
