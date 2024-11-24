package org.example.problems.medium;

import io.qameta.allure.TmsLink;
import org.example.problems.AbstractTest;
import org.example.problems.BattleShipsInABoard;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.ARRAY;
import static org.example.extensions.TestTags.DEPTH_FIRST_SEARCH;
import static org.example.extensions.TestTags.MATRIX;
import static org.example.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
        @Tag(MEDIUM),
        @Tag(ARRAY),
        @Tag(DEPTH_FIRST_SEARCH),
        @Tag(MATRIX),
})
@TmsLink("battleships-in-a-board")
class BattleShipsInABoardTest extends AbstractTest {

    BattleShipsInABoard base = new BattleShipsInABoard();

    @ParameterizedTest(name = "Case {index}: board={0}, output={1}")
    @MethodSource("generateTestData")
    void testCountBattleships_121ms(char[][] board, int output) {
        assertEquals(output, base.countBattleships_121ms(board));
    }

    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}},
                        2
                ),
                Arguments.of(
                        new char[][]{{'.'}},
                        0
                )
        );
    }
}