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
    private static final int WIDTH = 80;
    private static final int HEIGHT = 100;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);
    //Creates a very simple class represents the position of hexagon.
    public static class Position {
        int x;
        int y;
        Position(int positionX, int positionY) {
            x = positionX;
            y = positionY;
        }
    }
    public static void addHexagon(TETile[][] world, Position p, int index, TETile t) {
        int maxX = p.x + index;
        int maxY = p.y + index * 2;
        for (int x = p.x; x < maxX; x += 1) {
            for (int y = p.y; y < maxY; y += 1) {
                world[x][y] = t;
            }
        }
        addHexagonPrintRight(world, p, index, t);
        addHexagonPrintLeft(world, p, index, t);

    }

    //Prints the characters.
    private static void addHexagonPrintRight(TETile[][] world, Position p, int index, TETile t) {
        int minX = p.x + index;
        int maxX = p.x + (index - 1) * 2;
        int minY = p.y + 1;
        int maxY = p.y + (index - 1) * 2;
        for (int x = minX; x <= maxX; x += 1) {
            for (int y = minY; y <= maxY; y += 1) {
                world[x][y] = t;
            }
            minY += 1;
            maxY -= 1;
        }
    }

    //Prints the characters.
    private static void addHexagonPrintLeft(TETile[][] world, Position p, int index, TETile t) {
        int minX = p.x - (index - 1);
        int maxX = p.x - 1;
        int minY = p.y + 1;
        int maxY = p.y + (index - 1) * 2;
        for (int x = maxX; x >= minX; x -= 1) {
            for (int y = minY; y <= maxY; y += 1) {
                world[x][y] = t;
            }
            minY += 1;
            maxY -= 1;
        }
    }

    //Finds topRightNeighbor
    private static Position topRightNeighbor(Position p, int index) {
        Position topRightNeighbor = new Position(10, 10);
        topRightNeighbor.x = p.x + index * 2 - 1;
        topRightNeighbor.y = p.y + index;
        return topRightNeighbor;
    }

    //Finds bottomRightNeighbor
    private static Position bottomRightNeighbor(Position p, int index) {
        Position bottomRightNeighbor = new Position(10, 10);
        bottomRightNeighbor.x = p.x + index * 2 - 1;
        bottomRightNeighbor.y = p.y - index;
        return bottomRightNeighbor;
    }

    private static void initializeTiles(TETile[][] world) {
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    //Draw the randomVerticalHexes
    private static void drawRandomVerticalHexes(TETile[][] world, Position p,
                                                int index, TETile t, int N) {
        Position next = new Position(p.x, p.y);
        for (int i = 0; i < N; i++) {
            t = randomTile();
            addHexagon(world, next, index, t);
            next.y = next.y - index * 2;
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.FLOOR;
            case 3: return Tileset.GRASS;
            case 4: return Tileset.TREE;
            case 5: return Tileset.MOUNTAIN;
            default: return Tileset.WATER;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        initializeTiles(world);

        //Adds the hexagons.
        TETile t = Tileset.NOTHING;
        Position p = new Position(40, 63);
        //addHexagon(world, p, 3, t);
        // draws the world to the screen
        drawRandomVerticalHexes(world, p, 4, t, 5);
        ter.renderFrame(world);
    }
}
