package co.superclark;

import co.superclark.entity.Dog;
import co.superclark.entity.User;
import co.superclark.repository.UserRepository;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        HttpClient authenticatedHttpClient = new StdHttpClient.Builder()
                .username("admin")
                .password("password")
                .build();

        CouchDbInstance dbInstance = new StdCouchDbInstance(authenticatedHttpClient);
        CouchDbConnector db = dbInstance.createConnector("ektorptest", true);

        UserRepository repository = new UserRepository(db);

        Dog d1 = new Dog();
        d1.setName("jerry");

        Dog d2 = new Dog();
        d2.setName("tom");

        User u = new User();
        u.setName("clark");
        u.setAge(25);

        //Persist user first, then we can have id
        repository.add(u);

        u.addDog(d1);
        u.addDog(d2);

        repository.update(u);

        User getUser = repository.get(u.getId());

        //list all user
        List<User> userList = repository.getAll();
    }
}
