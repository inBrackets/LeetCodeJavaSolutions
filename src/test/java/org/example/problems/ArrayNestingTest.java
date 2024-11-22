package org.example.problems;

import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.ARRAY;
import static org.example.extensions.TestTags.DEPTH_FIRST_SEARCH;
import static org.example.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
        @Tag(MEDIUM),
        @Tag(ARRAY),
        @Tag(DEPTH_FIRST_SEARCH)
})
@TmsLink("array-nesting")
class ArrayNestingTest extends AbstractTest {

    private final static ArrayNesting base = new ArrayNesting();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testArrayNesting_77ms(int[] nums, int output) {
        assertEquals(output, base.arrayNesting_77ms(nums));
    }

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testArrayNesting_4ms(int[] nums, int output) {
        assertEquals(output, base.arrayNesting_4ms(nums));
    }

    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 4, 0, 3, 1, 6, 2},
                        4
                ),
                Arguments.of(
                        new int[]{0, 1, 2},
                        1
                )
        );
    }
}