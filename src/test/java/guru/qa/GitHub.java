package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GitHub {
    @BeforeAll
    static void config(){
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.headless = true;

    }
    @Test
    void testGithub(){

        open("https://github.com/");
        $(".Header-old").$(byText("Pricing")).hover();
        $(".HeaderMenu").$(byText("Compare plans")).click();
        webdriver().shouldHave(url("https://github.com/pricing#compare-features"));
        $(".h2-mktg").shouldHave(Condition.text("Choose the plan that’s right for you."));
        //sleep(2000);
    }

}
