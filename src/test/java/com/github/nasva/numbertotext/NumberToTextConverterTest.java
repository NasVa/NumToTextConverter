package com.github.nasva.numbertotext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberToTextConverterTest {

    NumberToTextConverter numberToTextConverter = new NumberToTextConverter();

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void convert(String input, String expected) {
        Assertions.assertEquals(expected, numberToTextConverter.convert(input));
    }


    @Test
    void splitParts() {
        Assertions.assertEquals(List.of("123", "143"), numberToTextConverter.splitParts("123143"));
        Assertions.assertEquals(List.of("3", "123", "143"), numberToTextConverter.splitParts("3123143"));
        Assertions.assertEquals(List.of("93", "123", "143"), numberToTextConverter.splitParts("93123143"));
    }
}