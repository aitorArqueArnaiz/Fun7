import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.infrastructure.UserRepository;
import org.junit.Test;

public class Fun7Test
{
    @Test
    public void AddUser_Test() throws Exception
    {
        // Arrange
        UserRepository userRepository = new UserRepository();

        // Act
        userRepository.Add(new User());

        // Assert
    }
}