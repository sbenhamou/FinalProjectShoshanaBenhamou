package sanity;

import extensions.Functions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class AtidStoreWebDB extends CommonOps {
    @Test(description="Test01 - Verify message sent in Contact Us Page")
    @Description("This test verifies that message sent in Contact Us Page")
    public void test01_verifyMessageSentDB() {
        UIActions.click(fixMenu.menu_contact);
        WebFlows.submitMessageWithDB();
        Verifications.verifyContainsPage("Thanks for contacting us! We will be in touch with you shortly.");
    }
}
