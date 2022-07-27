package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class WikiTests extends TestBase {

    @Test
    @AllureId("11594")
    @DisplayName("Successful authorization to some demowebshop (API + UI)")
    @Tag("demowebshop")
    @Story("Login tests")
    @Owner("allure8")
    void checkOnboardingScreen() {
        step("Check first screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check second screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check third screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check last screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
        });
    }

    @Test
    @AllureId("11593")
    @DisplayName("Check page")
    @Tag("demowebshop")
    @Story("Login tests")
    void openFourPagesAndCheck() {
        step("Check first page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The Free Encyclopedia")));

        step("Open second page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check second page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));

        step("Open third page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check third page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));

        step("Open fourth page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check fourth page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));

    }

    @Test
    @AllureId("11592")
    @DisplayName("name")
    void QASearchTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Quality Assurance");
        });
        step("Verify content found", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }
}