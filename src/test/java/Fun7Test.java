import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.infrastructure.EntityManager;
import org.junit.Test;

public class Fun7Test
{
    @Test
    public void AddUser_Test()
    {
        EntityManager entityManager = new EntityManager();

        try
        {
            entityManager = (EntityManager) entityManager.GetEntityFactory().createEntityManager();
            entityManager.GetTransaction().begin();
            User student = new User();
            ((javax.persistence.EntityManager) entityManager).persist(student);
            entityManager.GetTransaction().commit();
        }
        catch (Exception e)
        {
            entityManager.GetTransaction().rollback();
        }
        finally
        {
            entityManager.close();
            entityManager.GetEntityFactory().close();
        }
    }
}