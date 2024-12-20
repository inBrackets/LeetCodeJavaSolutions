package org.example.problems.premium.hard;

import io.qameta.allure.TmsLink;
import org.example.problems.AbstractTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.ARRAY;
import static org.example.extensions.TestTags.HARD;
import static org.example.extensions.TestTags.MATH;
import static org.example.extensions.TestTags.MATRIX;
import static org.example.extensions.TestTags.PREMIUM;
import static org.example.extensions.TestTags.SORTING;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
        @Tag(PREMIUM),
        @Tag(HARD),
        @Tag(ARRAY),
        @Tag(MATH),
        @Tag(SORTING),
        @Tag(MATRIX)
})
@TmsLink("best-meeting-point")
class BestMeetingPointTest extends AbstractTest {

    BestMeetingPoint base = new BestMeetingPoint();

    @ParameterizedTest(name = "Case {index}: grid={0}, output={1}")
    @MethodSource("generateTestData")
    void testMinTotalDistance(int[][] grid, int output) {
        assertEquals(output, base.minTotalDistance(grid));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}},
                        6
                )
        );
    }
}