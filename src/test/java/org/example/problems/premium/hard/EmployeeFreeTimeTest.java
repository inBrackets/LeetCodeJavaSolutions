package org.example.problems.premium.hard;

import io.qameta.allure.TmsLink;
import org.example.problems.AbstractTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.extensions.TestTags.ARRAY;
import static org.example.extensions.TestTags.HARD;
import static org.example.extensions.TestTags.HEAP;
import static org.example.extensions.TestTags.PREMIUM;
import static org.example.extensions.TestTags.SORTING;

@Tags({
        @Tag(PREMIUM),
        @Tag(HARD),
        @Tag(ARRAY),
        @Tag(SORTING),
        @Tag(HEAP)
})
@TmsLink("employee-free-time")
class EmployeeFreeTimeTest extends AbstractTest {

    EmployeeFreeTime base = new EmployeeFreeTime();

    @ParameterizedTest(name = "Case {index}: schedule={0}, output={1}")
    @MethodSource("generateTestData")
    void testEmployeeFreeTime(List<List<EmployeeFreeTime.Interval>> schedule, List<EmployeeFreeTime.Interval> output) {
        assertThat(base.employeeFreeTime(schedule)).usingRecursiveComparison().isEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(
                                        new EmployeeFreeTime.Interval(45, 56),
                                        new EmployeeFreeTime.Interval(89, 96)
                                ),
                                List.of(
                                        new EmployeeFreeTime.Interval(5, 21),
                                        new EmployeeFreeTime.Interval(57, 74)
                                )
                        ),
                        List.of(
                                new EmployeeFreeTime.Interval(21, 45),
                                new EmployeeFreeTime.Interval(56, 57),
                                new EmployeeFreeTime.Interval(74, 89)
                        )
                )
        );
    }
}