import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.infrastructure.EntityManager;
import org.junit.Test;

public class Fun7Test
{
    @Test
    public void AddUser_Test()
    {
        // Arrange
        EntityManager entityManager = new EntityManager("User");

        // Act
        try
        {
            entityManager = (EntityManager) entityManager.GetEntityFactory().createEntityManager();
            entityManager.GetTransaction().begin();
            User user = new User();
            ((javax.persistence.EntityManager) entityManager).persist(user);
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

        // Assert
    }
}