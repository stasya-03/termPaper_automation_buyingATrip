package ru.netology.web.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQLHelper;
import ru.netology.web.page.DashboardPage;

public class BuyingATripTest {

    DashboardPage dashboardPage;
    DataHelper.CardInfo firstCardInfo;
    DataHelper.CardInfo secondCardInfo;

    @AfterAll
    static void tearDownAll() {
        SQLHelper.cleanDatabase();
    }

    @BeforeEach
    void setup() {
        var loginPage = Selenide.open("http://localhost:8080", DashboardPage.class);
    }

    @Test
    public void shouldBuyATripWithApprovedCard() {
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.buyWithCard();
        var cardInfo = DataHelper.getApprovedCard();
        paymentPage.fillForm(cardInfo);
        paymentPage.successMessage("Успешно. Операция одобрена Банком.");
    }

    @Test
    public void shouldNotBuyATripWithDeclinedCard() {
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.buyWithCard();
        var cardInfo = DataHelper.getDeclinedCard();
        paymentPage.fillForm(cardInfo);
        paymentPage.errorMessage("Ошибка! Банк отказал в проведении операции.");
    }




}
