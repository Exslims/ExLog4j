package com.home.exlog4j;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LevelTest {

    @Test
    public void testGreater() {
        Level off = Level.OFF;
        for (Level level : Level.values()) {
            if (level != Level.OFF) {
                System.out.print("Testing " + off + " and " + level + " levels...");
                assertTrue(level.compareTo(off) > 0);
                System.out.println("OK");
            }
        }
    }

    @Test
    public void testLower() {
        Level off = Level.ALL;
        for (Level level : Level.values()) {
            if (level != Level.ALL) {
                System.out.print("Testing " + off + " and " + level + " levels...");
                assertTrue(level.compareTo(off) < 0);
                System.out.println("OK");
            }
        }
    }

    @Test
    public void testAllLower() {
        Level[] levels = Level.values();
        Level currentLevel;
        for (int i = 0; i < levels.length; i++) {
            currentLevel =levels[i];
            for (int j = i; j < levels.length; j++) {
                if (i != j) {
                    System.out.print("Testing " + currentLevel + " and " + levels[j] + " levels...");
                    Level level = levels[j];
                    assertTrue(currentLevel.compareTo(level) < 0);
                    System.out.println("OK");
                }
            }
        }
    }

    @Test
    public void testAllGreater() {
        Level[] levels = Level.values();
        Level currentLevel;
        for (int i = levels.length-1; i > 0; i--) {
            currentLevel = levels[i];
            for (int j = i; j > 0; j--) {
                if (i != j) {
                    System.out.print("Testing " + currentLevel + " and " + levels[j] + " levels...");
                    Level level = levels[j];
                    assertTrue(currentLevel.compareTo(level) > 0);
                    System.out.println("OK");
                }
            }
        }
    }


    @Test
    public void testEquals() {
        System.out.print("Testing equals...");
        Level all = Level.ALL;
        assertTrue(all.equals(Level.ALL));
        System.out.println("OK");
    }


    @Test
    public void testNotEquals() {
        System.out.print("Testing not equals...");
        Level all = Level.ALL;
        assertFalse(all.equals(Level.OFF));
        System.out.println("OK");
    }
}