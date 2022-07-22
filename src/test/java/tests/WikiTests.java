package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class WikiTests extends TestBase {
    @Test
    void QASearchTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    void openFourPagesAndCheck() {
        step("Check first page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(Condition.text("The Free Encyclopedia")));

        step("Open second page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check second page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(Condition.text("New ways to explore")));

        step("Open third page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check third page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(Condition.text("Reading lists with sync")));

        step("Open fourth page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check fourth page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(Condition.text("Send anonymous data")));
    }
}
