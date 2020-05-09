package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    //Creates a very simple class represents the position of hexagon.
    public static class Position {
        Position(int positionX, int positionY) {
            int x = positionX;
            int y = positionY;
        }
    }
    public static void addHexagon(TETile[][] world, Position p, int index, TETile t) {
        int charNum = index;
        int maxNum = index + (index - 1) * 2;
        //Prints the upper side.
        for (int i = 0; i < index * 2; i++) {
            addHexagonPrintBlank((maxNum - charNum) / 2);
            addHexagonPrintChar(charNum);
            System.out.println();
            if (i < index) {
                charNum += 2;
            } else {
                charNum -= 2;
            }
            if (charNum > maxNum) {
                charNum = maxNum;
            }
        }
    }
    //Prints the characters.
    private static void addHexagonPrintChar(int index) {
        for (int i =  0; i < index; i++) {
            System.out.print("#");
        }
    }
    //Helps addHexagon to print blanks.
    private static void addHexagonPrintBlank(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(" ");
        }
    }

    private static void initializeTiles(TETile[][] world) {
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        initializeTiles(world);



    }
}
