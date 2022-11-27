import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class AuthTest {
    @BeforeEach
    public  void setup(){
        //1.Открыть страницу https://github.com/
        open("https://github.com/");
        //2.Кликнуть на кнопку sign in
        TestPages.mainPage.mainSignInButton().click();
    }
    @Test
    @DisplayName("Успешная Авторизация")
    public void  shouldAuthorizeTest() {
        //3. Заполнить импуты логина и пароля
        TestPages.mainPage.loginInput()
                .sendKeys("yryry2112");
        TestPages.mainPage.passwordInput()
                .sendKeys("my_parol");
        //4.Нажать кнопку sign in
        TestPages.mainPage.signInButton()
                .click();
        //5. Проверить авторизацию
        TestPages.basePage.header()
                .shouldBe(Condition.visible);
        //6.Нажать на иконку с фото, чтобы раскрыть список
        TestPages.basePage.dropdown()
                .click();
        //7.Нажать "Your profile"
        TestPages.basePage.myProfileButton()
                .click();
        //8. Проверить переход
       TestPages.basePage.nameLookup()
                .shouldBe(Condition.visible);

    }
}

