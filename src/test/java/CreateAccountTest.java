import org.example.CreateAccountPage;
import org.example.FirstPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccountTest extends BaseTest {

    @Test
    public void testCreateNewAccount() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        FirstPage firstPage = new FirstPage(driver);

        String username = generateUniqueUsername("egzaminas");

        mainPage.goToCreateAnAccount();
        createAccountPage.typeUserName(username);
        createAccountPage.typePassword("Labas1*");
        createAccountPage.confirmPassword("Labas1*");
        createAccountPage.clickSubmit();

        String expectedLogoutText = "Logout, " + username;
        Assertions.assertEquals(expectedLogoutText, firstPage.getLogoutText(),
                "The logout text after account creation is not as expected.");
    }

    @Test
    public void testCreateAccountPasswordError() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MainPage mainPage = new MainPage(driver);

        String username = generateUniqueUsername("egzaminas");

        mainPage.goToCreateAnAccount();
        createAccountPage.typeUserName(username);
        createAccountPage.typePassword("Labas1*");
        createAccountPage.confirmPassword("slaptazodis");
        createAccountPage.clickSubmit();

        String expectedErrorMessage = "Įvesti slaptažodžiai nesutampa";
        Assertions.assertEquals(expectedErrorMessage, createAccountPage.getPasswordErrorText(),
                "The password error message is not as expected.");
    }

    private String generateUniqueUsername(String baseUsername) {
        return baseUsername + randomInt;
    }
}
