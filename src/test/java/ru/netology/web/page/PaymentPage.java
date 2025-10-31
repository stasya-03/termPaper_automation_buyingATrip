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

    private SelenideElement numberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $$("input.input__control").find(exactText("Владелец"));
    private SelenideElement cvcField = $("[placeholder='999']");
    private SelenideElement continueButton = $$("button.button").find(exactText("Продолжить"));

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
