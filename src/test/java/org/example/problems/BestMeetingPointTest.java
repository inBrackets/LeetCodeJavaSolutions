package org.example.problems;

import io.qameta.allure.TmsLink;
import org.example.extensions.Tag;
import org.example.extensions.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.HARD;
import static org.example.extensions.TestTags.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(PREMIUM),
    @Tag(HARD)
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