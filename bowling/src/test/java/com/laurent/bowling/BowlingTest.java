package com.laurent.bowling;

import junit.framework.TestCase;
import org.junit.Test;

import javax.accessibility.AccessibleStateSet;

/**
 * Created by IntelliJ IDEA.
 * User: laurent
 * Date: 6/23/11
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class BowlingTest extends TestCase {
    private Game game;

    @Test
    public void testGutterGameAssertZeroScore() {
        game = new Game();

        rollMany(20, 0);

        assertEquals(game.getScore(), 0);

    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
        public void testLeftOversAssertScoreIsSum() {
        game = new Game();

        rollMany(20, 4);


        assertEquals(80,game.getScore());
    }

    @Test
    public void testSpareAssertScoreIsSumPlusNextRoll() {
        game = new Game();

        rollMany(2, 4);

        rollMany(1, 6);
        rollMany(1, 4);

        rollMany(6, 4);

        assertEquals(46,game.getScore());

    }

    @Test
    public void testOneStrikeAssertScoreIsSumPlusNextFrameScore() {
        game = new Game();

        rollMany(2,4);

        rollMany(1,10);

        rollMany(4,4);

        assertEquals(42,game.getScore());
    }

    @Test
    public void testPerfectGameAssertScoreIs300(){
        game = new Game();

        rollMany(12,10);

        assertEquals(300, game.getScore());
    }

    public void testSpareGameAssertScoreIs(){
        game=new Game();

        rollMany(22,5);

        assertEquals(150, game.getScore());
    }




}
