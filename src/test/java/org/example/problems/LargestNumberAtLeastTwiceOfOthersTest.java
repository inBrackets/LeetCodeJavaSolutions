package org.example.problems;

import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.EASY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
        @Tag(EASY)
})
@TmsLink("largest-number-at-least-twice-of-others")
class LargestNumberAtLeastTwiceOfOthersTest extends AbstractTest {

    LargestNumberAtLeastTwiceOfOthers base = new LargestNumberAtLeastTwiceOfOthers();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void dominantIndex_1ms(int[] nums, int output) {
        assertEquals(output, base.dominantIndex_1ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 6, 1, 0},
                        1
                ),
                Arguments.of(
                        new int[]{3, 6, 1, 0},
                        1
                )
        );
    }
}