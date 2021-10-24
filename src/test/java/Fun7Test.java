import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.domain.services.EntityManager;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Fun7Test
{
    @Test
    public void firstTest()
    {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try
        {
            emf = Persistence.createEntityManagerFactory("User");
            entityManager = (EntityManager) emf.createEntityManager();
            transaction = ((javax.persistence.EntityManager) entityManager).getTransaction();
            transaction.begin();
            User student = new User();
            ((javax.persistence.EntityManager) entityManager).persist(student);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
        }
        finally
        {
            entityManager.close();
            emf.close();
        }
    }
}