package ru.liga.praktikum.forFinal;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PraktikumTest {

    private String name;
    private boolean expAnswer;
    private Account account;

    public PraktikumTest(String name, boolean expAnswer) {
        this.name = name;
        this.expAnswer = expAnswer;
    }

    @Parameterized.Parameters
    public static Object[] getName() {
        return new Object[][]{
                {"я_", false},
                {"АРозаУпалаНа ЛапуАзора", false },
                {"Ким Чен", true},
                {"КимЧенИн", false},
                {" КимЧен", false},
                {"КимЧен ", false},
                {" Ким Чен", false},
                {"Ким Чен ", false},
                {"Ким Чен Ин", false}
        };
    }

    @Before
    public void setUp(){
        account = new Account(name);
    }

    @DisplayName("Check string to printing.")
    @Description("Проверяется подаваемая строка на корректность (длина в диапазоне [3;19] символов, содержит только 1 пробел,который не в начале и не в середине строки "  )
    @Test
    public void CheckStringTest()  {
        boolean actAnswer = check(name, expAnswer);
        assertEquals(expAnswer, actAnswer);
    }
    @Step("For \"{name}\" answer is {expAnswer}")
    public boolean check(String name, boolean expAnswer)
    {
        return  account.checkNameToEmboss();
    }


}
