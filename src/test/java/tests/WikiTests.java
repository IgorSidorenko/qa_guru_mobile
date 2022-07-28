package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Owner("Sidorenko")
public class WikiTests extends TestBase {

    @Test
    @AllureId("11774")
    @Tag("Search")
    @DisplayName("Check search is finding item")
    void searchTest() {
        step("Skip onboarding screen", () -> back());

        step("Type on search field", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                    .click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Quality Assurance");
        });

        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    @AllureId("11775")
    @Tag("Other")
    @DisplayName("Check opening screen onboarding pages")
    void openinusergScreenTest() {
        step("Check first page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).
                    shouldHave(text("The Free Encyclopedia\n" +
                            "…in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Check second page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).
                    shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Check third page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).
                    shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Check fourth page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).
                        shouldHave(text("Send anonymous data")));
    }
}
