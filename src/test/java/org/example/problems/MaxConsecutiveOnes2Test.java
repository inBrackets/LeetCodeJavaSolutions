package org.example.problems;

import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.MEDIUM;
import static org.example.extensions.TestTags.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(PREMIUM),
    @Tag(MEDIUM)
})
@TmsLink("max-consecutive-ones-ii")
class MaxConsecutiveOnes2Test extends AbstractTest {

    MaxConsecutiveOnes2 base = new MaxConsecutiveOnes2();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testFindMaxConsecutiveOnes(int[] nums, int output) {
        assertEquals(output, base.findMaxConsecutiveOnes(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 0, 1, 1, 0},
                4
            )
        );
    }
}