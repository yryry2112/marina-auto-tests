import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;
@Owner("yryry_21")
@Feature("Репозитории")
public class JUnitTest {
    @BeforeEach
    public void setup() {
        //1.Открыть страницу https://github.com/junit-team/junit4
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @Story("Переключение веток")
    @DisplayName("Переход на ветку fixtures")
    public void OpenFixturesBranch() {
        step("Нажать на дропдаун переключения веток и выбрать ветку fixtures", () -> {
        TestPages.JUnitPage.dropdown1()
                .click();
        TestPages.JUnitPage.fixturesButton()
                .click();
        });
        step("Проверить, что произошел переход на ветку fixtures", () -> {
        TestPages.JUnitPage. branchText()
                .shouldBe(Condition.visible);
        });
    }
    @Story("Поиск по релизам")
    @DisplayName("Позитивные проверки поиска:")
    @MethodSource("SearchValue")
    @ParameterizedTest(name = "{displayName} {0}")
    public void shouldFindTest (String type, String value, String result) {
        step("Кликнуть на кнопку Releases", () ->
                TestPages.JUnitReleasePage.releasesButton().click());
        step("Ввести значение, нажать энтер", () -> {
        TestPages.JUnitReleasePage.releasesSearchInput()
                .setValue(value).pressEnter();
        });
        step("Проверить поиск по релизу", () -> {
        TestPages.JUnitReleasePage.releasesBox()
                .shouldHave(Condition.text(result));
        });

    }
    static Stream<Arguments> SearchValue() {
        return Stream.of(
                arguments(
                        "по номеру",
                        "4.13.2",
                        "4.13.2"

                ),
                arguments(
                        "по буквам",
                        "RC 2",
                        "RC 2"
                ),
                arguments(
                        "по буквам и цифрам",
                        "JUnit 4.13 RC 2",
                        "JUnit 4.13 RC 2"
                )
        );

    }
}


