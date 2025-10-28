package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {

    private SelenideElement numberField = $("[]");
    private SelenideElement monthField = $("[]");
    private SelenideElement yearField = $("[]");
    private SelenideElement ownerField = $$();
    private SelenideElement cvcField = $("[]");
    private SelenideElement continueButton = $$("button.button").find(exactText("Продолжить"));

    private SelenideElement successMessage = $(".notification_status_ok");
    private SelenideElement errorMessage = $(".notification_status_error");

    public void fillForm(DataHelper.CardInfo info) {
        numberField.setValue(info.getNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getHolder());
        cvcField.setValue(info.getCvc());
        continueButton.click();
    }
}
