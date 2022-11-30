package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JUnitReleasePage {
    public SelenideElement releasesButton() {
        return $(byText("Releases")).as("Кнопка Релизов");
    }
    public SelenideElement releasesSearchInput() {
        return $("[id='release-filter']").as("Поле поиска");
    }
    public SelenideElement releasesBox() {
        return $(".Box-body").as("Карточка релиза");
    }
}
