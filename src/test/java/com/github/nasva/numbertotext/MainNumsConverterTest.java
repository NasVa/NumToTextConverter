package com.github.nasva.numbertotext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainNumsConverterTest {

    MainNumsConverter mainNumsConverter = new MainNumsConverter();

    @ParameterizedTest
    @CsvSource({
            "двести сорок два,242",
            "шестьсот четыре,604",
            "ноль,0",
            "двенадцать,12",
            "три,3",
            "триста пятнадцать,315",
            "триста,300",

    })
    void convert(String expected, String input) {
        Assertions.assertEquals(expected, mainNumsConverter.convert(input, false));
    }

    @ParameterizedTest
    @CsvSource({
            "двести сорок две,242",
            "две,2",
            "двадцать одна,21",
            "двадцать три,023"
    })
    void convertForThousands(String expected, String input) {
        Assertions.assertEquals(expected, mainNumsConverter.convert(input, true));
    }
}