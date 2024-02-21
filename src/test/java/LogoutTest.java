import org.example.FirstPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogoutUser() {
        MainPage mainPage = new MainPage(driver);
        FirstPage firstPage = new FirstPage(driver);

        performLogin(mainPage, firstPage);

        firstPage.clickLogoutLink();

        String expectedLogoutMessage = "Sėkmingai atsijungėte";
        String actualLogoutMessage = mainPage.getLogoutMessageText();
        Assertions.assertEquals(expectedLogoutMessage, actualLogoutMessage,
                "The logout message is not as expected.");
    }

    private void performLogin(MainPage mainPage, FirstPage firstPage) {
        String username = "egzaminas";
        String password = "Labas1*";
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogin();
    }
}
