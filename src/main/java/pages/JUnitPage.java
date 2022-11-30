package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JUnitPage {

    public SelenideElement dropdown1() {
        return $("[title='Switch branches or tags']").as("Дропдаун с ветками");
    }
    public SelenideElement fixturesButton() {
        return $(byText("fixtures")).as("Кнопка fixtures");

    }
    public SelenideElement branchText() {
        return $(byText("This branch is")).as("Текст 'Эта ветвь");
    }

}
