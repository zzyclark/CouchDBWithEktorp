package co.superclark.repository;

import co.superclark.entity.User;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;

import java.util.List;

/**
 * @Author clark
 * @Date 01-Dec-2015
 */
public class UserRepository extends CouchDbRepositorySupport<User> {
    public UserRepository(CouchDbConnector db) {
        super(User.class, db);
        initStandardDesignDocument();
    }

    @GenerateView
    @Override
    public List<User> getAll() {
        ViewQuery q = createQuery("all").includeDocs(true);
        return db.queryView(q, User.class);
    }
}
