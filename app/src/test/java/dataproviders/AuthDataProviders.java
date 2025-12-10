package dataproviders;

import org.testng.annotations.DataProvider;
import utils.Config;

public class AuthDataProviders {
    @DataProvider(name = "negativeLoginData")
    public static Object[][] negativeLoginData() {
        return new Object[][] {
                // email, password, expectedErrorMsg
                { "zaidlovesmath@gmail.com", "wrongPass123!", "Wrong password. Please try again" },
                { "zaidkhan@gmail.com", "Louiscathat123!", "No account was found with this email. Please try again" },
                { "", "", null },
                { "zaidlovesmath@gmail.com", "", null },
                { "zaidlovesmath@", "Louiscathat123!", null }
        };
    }

    /*
     * @DataProvider(name = "invalidLoginData")
     * public static Object[][] invalidLoginData() {
     * return new Object[][] {
     * // email, password, expected error
     * { Config.validEmail(), "wrong-password-123",
     * "Wrong password. Please try again" },
     * 
     * { Config.invalidEmail(), Config.validPassword(),
     * "No account was found with this email. Please try again" },
     * 
     * { "", "",
     * null }, // we'll assert "stays on page + button visible" instead of message
     * 
     * { Config.validEmail(), "",
     * null },
     * 
     * { "zaid@gmail", "anyPassword",
     * null },
     * 
     * { "zaidlovesmath@", Config.validPassword(),
     * null }
     * };
     * }
     * 
     * @DataProvider(name = "validLoginData")
     * public static Object[][] validLoginData() {
     * return new Object[][] {
     * { Config.validEmail(), Config.validPassword() },
     * { "  " + Config.validEmail() + "  ", Config.validPassword() }
     * };
     * }
     */
}
