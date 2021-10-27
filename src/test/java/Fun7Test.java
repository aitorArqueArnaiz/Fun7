import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.domain.services.AdminResourceGetUsers;
import com.example.fun7_test.domain.shared.utils;
import com.example.fun7_test.infrastructure.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class Fun7Test
{
    // ---------------------- UNIT TESTS ---------------------------------------------------------------
    // The tests attacks against real local Data Base (no mock)
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

    @Test
    public void GetUserByIdUsers_Test() throws Exception
    {
        // Arrange
        User user = new User();
        UserRepository userRepository = new UserRepository();

        // Act
        User result = userRepository.Get(String.valueOf(user.id));

        // Assert
        Assert.assertNotNull(result);
    }

    @Test
    public void DeleteUserById_Test() throws Exception
    {
        // Arrange
        User user = new User();
        user.id = 1;
        UserRepository userRepository = new UserRepository();

        // Act
        boolean result = userRepository.Delete(String.valueOf(user.id));

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void CheckUserMultiplayer_Feature_Deactivated_Test() throws Exception
    {
        // Arrange
        User user = new User();
        user.id = 6;
        user.cc = "ES";
        utils check = new utils();

        // Act
        boolean multiplayerActivated = check.CheckMultiplyer(String.valueOf(user.id), user.cc);

        // Assert
        Assert.assertFalse(multiplayerActivated);
    }

    @Test
    public void CheckUserMultiplayer_Feature_Activated_Test() throws Exception
    {
        // Arrange
        User user = new User();
        user.id = 6;
        user.cc = "US";
        utils check = new utils();

        // Act
        boolean multiplayerActivated = check.CheckMultiplyer(String.valueOf(user.id), user.cc);

        // Assert
        Assert.assertTrue(multiplayerActivated);
    }

    // ---------------------- INTEGRATION TESTS ---------------------------------------------------------------
    @Test
    public void ListAllUsers_IntegrationTest() throws Exception
    {
        // Arrange
        AdminResourceGetUsers allUsers = new AdminResourceGetUsers();

        // Act
        String users = allUsers.admin();

        // Assert
        Assert.assertNotNull(users);
        Assert.assertTrue(users.length() > 0);
    }
}