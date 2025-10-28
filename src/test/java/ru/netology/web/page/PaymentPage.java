package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {

    private SelenideElement numberField = $$("input__control").findBy(text("Номер карты")).$("input");
    private SelenideElement monthField = $$("input__control").findBy(text("Месяц")).$("input");
    private SelenideElement yearField = $$("input__control").findBy(text("Год")).$("input");
    private SelenideElement ownerField = $$("input__control").findBy(text("Владелец")).$("input");
    private SelenideElement cvcField = $$("input__control").findBy(text("CVC/CVV")).$("input");
    private SelenideElement continueButton = $(Selectors.byText("Продолжить"));

    private SelenideElement successMessage = $$("notification__content").findBy(text("Успешно"));
    private SelenideElement errorMessage = $$("notification__content").findBy(text("Ошибка!"));

    public void fillForm(DataHelper.CardInfo info) {
        numberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
    }

    public void successMessage(String expectedText) {
        successMessage.shouldHave(Condition.exactText(expectedText)).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void errorMessage(String expectedText) {
        errorMessage.shouldHave(Condition.exactText(expectedText)).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }


}
