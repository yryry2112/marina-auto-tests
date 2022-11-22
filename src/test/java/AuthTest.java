import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthTest {
    @Test
    public void  shouldAuthorizeTest() {
        //1.Открыть страницу https://github.com/
        open("https://github.com/");
        //2.Кликнуть на кнопку sign in
        $("[href='/login']").click();
        //3. Заполнить импуты логина и пароля
        $("[id='login_field']").sendKeys("yryry2112");
        $("[id='password']").sendKeys("my_parol");
        //4.Нажать кнопку sign in
        $(".js-sign-in-button").click();
        //5. Проверить авторизацию
        $(".Header").shouldBe(Condition.visible);
        //6.Нажать на иконку с фото, чтобы раскрыть список
        $("[aria-label='View profile and more']").click();
        //7.Нажать "Your profile"
        $("[href='/yryry2112?tab=repositories']").click();
        //8. Проверить переход
        $(".vcard-names").shouldBe(Condition.visible);



    }
}
