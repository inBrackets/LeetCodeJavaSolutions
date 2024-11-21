package org.example.problems;

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
class MaxConsecutiveOnesTest extends AbstractTest {

    MaxConsecutiveOnes base = new MaxConsecutiveOnes();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testFindMaxConsecutiveOnes_3ms(int[] nums, int output) {
        assertEquals(output, base.findMaxConsecutiveOnes_3ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[] {1,1,0,1,1,1},
                3
            ),
            Arguments.of(
                new int[] {1,0,1,1,0,1},
                2
            )
        );
    }
}