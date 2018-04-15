package ru.job4j.calculator;

/**
 * Корвертор валюты.
 */
public class Converter {

    private static final int DOLLAR_VALUE_IN_RUBLE = 60;
    private static final int EURO_VALUE_IN_RUBLE = 70;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / Converter.EURO_VALUE_IN_RUBLE;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * Converter.EURO_VALUE_IN_RUBLE;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public int rubleToDollar(int value) {
        return value / Converter.DOLLAR_VALUE_IN_RUBLE;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return value * Converter.DOLLAR_VALUE_IN_RUBLE;
    }
}