package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement heading = $(Selectors.byText("Путешествие дня"));
    private SelenideElement buyButton = $(Selectors.byText("Купить"));
    private SelenideElement buyByCreditButton = $(Selectors.byText("Купить в кредит"));

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public PaymentPage buyWithCard() {
        buyButton.click();
        return new PaymentPage();
    }


}
