import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.infrastructure.UserRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Fun7Test
{
    @Test
    public void AddUser_Test() throws Exception
    {
        // Arrange
        UserRepository userRepository = new UserRepository();

        // Act
        boolean result = userRepository.Add(new User());

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void ListAllUsers_Test() throws Exception
    {
        // Arrange
        UserRepository userRepository = new UserRepository();

        // Act
        List<User> result = userRepository.List();

        // Assert
        Assert.assertNotNull(result);
    }
}