package com.laurent.bowling;

/**
 * Created by IntelliJ IDEA.
 * User: laurent
 * Date: 6/23/11
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private int[] rolls;
    private int rolledBallsCount;

    public int getScore() {
        int score = 0;

        int frameIndex = 0;
        int rollIndex = 0;

        while (frameIndex < 10) {
            boolean isStrike = rolls[rollIndex] == 10;

            boolean isSpare = !isStrike && (getRegularFrameScore(rollIndex) == 10);

            if (isSpare) {
                score += 10 + getSpareBonus(rollIndex);
                rollIndex += 2;
            } else if (isStrike) {
                score += 10 + getStrikeBonus(rollIndex);
                rollIndex += 1;
            } else {
                score += getRegularFrameScore(rollIndex);
                rollIndex += 2;
            }
            frameIndex++;

        }
        return score;

    }

    private int getRegularFrameScore(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int getSpareBonus(int frameIndex) {
        return rolls[frameIndex + 1];
    }

    private int getStrikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    public Game() {
        rolls = new int[22];
        rolledBallsCount = 0;
    }

    public void roll(int pins) {
        rolls[rolledBallsCount++] = pins;

    }
}
