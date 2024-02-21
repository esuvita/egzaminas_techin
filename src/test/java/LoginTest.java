import org.example.FirstPage;
import org.example.MainPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Test successful login")
    public void testLoginUser() {
        MainPage mainPage = new MainPage(driver);
        FirstPage firstPage = new FirstPage(driver);

        String username = "egzaminas";
        String password = "Labas1*";

        mainPage.login(username, password);

        assertEquals("Logout, " + username, firstPage.getLogoutText(),
                "Successful login message not found");
    }

    @Test
    @DisplayName("Test login with incorrect password")
    public void testLoginUserPasswordError() {
        MainPage mainPage = new MainPage(driver);

        String username = "egzaminas";
        String password = "slaptazodis";

        mainPage.login(username, password);

        assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",
                mainPage.getCredentialsErrorMessageText(),
                "Incorrect password error message not found");
    }
}
