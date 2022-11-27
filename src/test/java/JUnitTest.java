import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JUnitTest {
    @BeforeEach
    public void setup() {
        //1.Открыть страницу https://github.com/junit-team/junit4
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @DisplayName("Переход на ветку fixtures")
    public void OpenFixturesBranch() {
        //2.Нажать на дропдаун с ветками
        TestPages.JUnitPage.dropdown1()
                .click();
        //3.Нажать "fixtures"
        TestPages.JUnitPage.fixturesButton()
                .click();
        //4.Проверка перехода
        TestPages.JUnitPage. branchText()
                .shouldBe(Condition.visible);
    }

    @MethodSource("SearchValue")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Позитивные проверки поиска по:")
    public void shouldFindTest (String type, String value, String result) {
        //2.Кликнуть на кнопку Releases
        TestPages.JUnitPage.releasesButton().click();
        //3.Ввести значение, нажать энтер
        TestPages.JUnitPage.releasesSearchInput()
                .setValue(value).pressEnter();
        //4.Проверить поиск по релизу
        TestPages.JUnitPage.releasesBox()
                .shouldHave(Condition.text(result));


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


