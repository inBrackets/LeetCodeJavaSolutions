package org.example.problems;

import io.qameta.allure.TmsLink;
import org.example.extensions.Tag;
import org.example.extensions.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.extensions.TestTags.MEDIUM;
import static org.example.extensions.TestTags.PREMIUM;
import static org.assertj.core.api.Assertions.assertThat;

@Tags({
    @Tag(PREMIUM),
    @Tag(MEDIUM)
})
@TmsLink("meeting-scheduler")
class MeetingSchedulerTest extends AbstractTest {

    MeetingScheduler base = new MeetingScheduler();

    @ParameterizedTest(name = "Case {index}: slots1={0}, slots2={1}, duration={2}, output={3}")
    @MethodSource("generateTestData")
    void minAvailableDuration(int[][] slots1, int[][] slots2, int duration, List<Integer> output) {
        assertThat(base.minAvailableDuration(slots1, slots2, duration)).usingRecursiveComparison().isEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[][]{{10,50},{60,120},{140,210}},
                new int[][]{{0, 15}, {60, 70}},
                8,
                List.of(60, 68)
            ),
            Arguments.of(
                new int[][]{{10, 50}, {60, 120}, {140, 210}},
                new int[][]{{0, 15}, {60, 70}},
                12,
                new ArrayList<Integer>()
            )
        );
    }
}