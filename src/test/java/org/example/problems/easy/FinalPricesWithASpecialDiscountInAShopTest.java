package org.example.problems.easy;

import io.qameta.allure.TmsLink;
import org.example.problems.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.ARRAY;
import static org.example.extensions.TestTags.EASY;
import static org.example.extensions.TestTags.MATH;
import static org.example.extensions.TestTags.MONOTONIC_STACK;
import static org.example.extensions.TestTags.STACK;
import static org.junit.jupiter.api.Assertions.*;

@Tags({
        @Tag(EASY),
        @Tag(ARRAY),
        @Tag(MONOTONIC_STACK),
        @Tag(STACK),
})
@TmsLink("final-prices-with-a-special-discount-in-a-shop")
class FinalPricesWithASpecialDiscountInAShopTest extends AbstractTest {

    private final static FinalPricesWithASpecialDiscountInAShop base = new FinalPricesWithASpecialDiscountInAShop();

    @ParameterizedTest(name = "Case {index}: prices={0}, output={1}")
    @MethodSource("generateTestData")
    void finalPricesWithASpecialDiscountInAShop_0ms(int[] prices, int[] output) {
        Assertions.assertArrayEquals(output, base.finalPricesWithASpecialDiscountInAShop_0ms(prices));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{8, 4, 6, 2, 3},
                        new int[]{4, 2, 4, 2, 3}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{10, 1, 1, 6},
                        new int[]{9, 0, 1, 6}
                )
        );
    }
}