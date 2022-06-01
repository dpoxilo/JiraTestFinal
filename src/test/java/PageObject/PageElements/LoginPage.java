package PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static SelenideElement loginJira = $x("//*[@id='login-form-username']");
    public static SelenideElement passwordJira = $x("//*[@id='login-form-password']");
    public static SelenideElement buttonLogIn = $x("//*[@id='login']");
    public static SelenideElement inProfile = $x("//a[@id='header-details-user-fullname']");
    public static SelenideElement viewProfile = $x("//a[@id='view_profile']");
    public static SelenideElement getUserName = $x("//dd[@id='up-d-username']");
    public static SelenideElement logOut = $x("//a[@id='log_out']");
}
