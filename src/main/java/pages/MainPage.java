package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement mainSignInButton(){
        return $("[href='/login']").as("Кнопка логина");
    }
    public SelenideElement loginInput() {
        return $("[id='login_field']").as("Поле ввода логина");
    }
    public SelenideElement passwordInput() {
        return $("[id='password']").as("Поле ввода пароля");
    }
    public SelenideElement  signInButton() {
        return $(".js-sign-in-button").as("Кнопка'Войти'");
    }
}
