package co.superclark.entity;

import com.sun.istack.internal.NotNull;
import org.ektorp.docref.CascadeType;
import org.ektorp.docref.DocumentReferences;
import org.ektorp.docref.FetchType;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author clark
 * @Date 01-Dec-2015
 */
public class User extends CouchDbDocument {
    private String name;
    @TypeDiscriminator
    private Integer age;

    @DocumentReferences(backReference = "userId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Dog> dogs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void addDog(Dog dog) {
        if (null == this.dogs) {
            this.dogs = new TreeSet<Dog>();
        }
        dog.setUserId(getId());
        this.dogs.add(dog);
    }
}
