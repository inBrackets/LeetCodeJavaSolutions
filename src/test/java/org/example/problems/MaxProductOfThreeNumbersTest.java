package org.example.problems;

import io.qameta.allure.TmsLink;
import org.example.extensions.Tag;
import org.example.extensions.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.EASY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(EASY)
})
@TmsLink("maximum-product-of-three-numbers")
class MaxProductOfThreeNumbersTest extends AbstractTest {

    MaxProductOfThreeNumbers base = new MaxProductOfThreeNumbers();

    @ParameterizedTest(name = "Case {index}: num={0}, output={1}")
    @MethodSource("generateTestData")
    void maximumProduct_3ms(int[] nums, int output) {
        assertEquals(output, base.maximumProduct_3ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 2, 3},
                6
            ),
            Arguments.of(
                new int[]{1, 2, 3, 4},
                24
            ),
            Arguments.of(
                new int[]{-1, -2, -3},
                -6
            )
        );
    }
}