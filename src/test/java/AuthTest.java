import com.codeborne.selenide.Condition;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("yryry_21")
@Feature("Страница пользователя")
public class AuthTest {
    @BeforeEach
    public  void setup(){
        step("Открыть страницу гитхаба и кликнуть на кнопку sing in", () ->{
            open("https://github.com/");
            TestPages.mainPage.mainSignInButton()
                .click();
        });
    }

    @Test
    @DisplayName("Успешная Авторизация")
    public void  shouldAuthorizeTest() {
        step("Заполнить импуты логина и пароля", () ->{
            TestPages.mainPage.loginInput()
                .sendKeys("yryry2112");
            TestPages.mainPage.passwordInput()
                .sendKeys("my_parol");
        });
        step("Нажать кнопку sign in и проверить авторизацию", () -> {
            TestPages.mainPage.signInButton()
                    .click();
            TestPages.basePage.header()
                .shouldBe(Condition.visible);
        });
        step("Нажать на иконку с фото, чтобы раскрыть список", () -> {
            TestPages.basePage.dropdown()
                    .click();
        });
        step("Нажать 'Your profile и проверить имя", () ->{
            TestPages.basePage.myProfileButton()
                    .click();
            TestPages.basePage.nameLookup()
                .shouldBe(Condition.visible);
        });

    }
}

