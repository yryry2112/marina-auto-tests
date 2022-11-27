package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
        public SelenideElement header(){
            return $("[href='/login']").as("Хедер");
        }
    public SelenideElement dropdown() {
        return $("[aria-label='View profile and more']").as("Дропдаун");
    }
    public SelenideElement  myProfileButton() {
        return $("[href='/yryry2112?tab=repositories']").as("Кнопка 'Мой профиль'");
    }
    public SelenideElement  nameLookup() {
        return $(".vcard-names").as("Имя на странице");
    }

}

