package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;  // false for Watch, true for Type
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40, seed);
        game.startGame();
    }

    public MemoryGame(int width, int height, int seed) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        //TODO: Initialize random number generator
        rand = new Random(seed);
    }

    public String generateRandomString(int n) {
        //TODO Generate random string of letters of length n
        int index;
        char[] randomChars = new char[n];
        for (int i = 0; i < n; i++) {
            index = rand.nextInt(26);
            randomChars[i] = CHARACTERS[index];
        }
        return new String(randomChars);
    }

    public void drawFrame(String s) {
        //TODO: Take the string and display it in the center of the screen
        //TODO: If game is not over, display relevant game information at the top of the screen

        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);

        StdDraw.text(width / 2, height / 2, s);

        if (!gameOver) {
            // draw UI:
            StdDraw.textLeft(0, height - 1, "Round: "+ round);
            StdDraw.text(width / 2, height - 1, playerTurn ? "Type" : "Watch");

            int index = new Random(round).nextInt(ENCOURAGEMENT.length);
            StdDraw.textRight(width, height - 1, ENCOURAGEMENT[index]);
            StdDraw.line(0,height - 2, width, height - 2);
        }

        StdDraw.show();

    }

    public void flashSequence(String letters) {
        //TODO: Display each character in letters, making sure to blank the screen between letters
        for (int i = 0; i < letters.length(); i+=1) {
            drawFrame(String.valueOf(letters.charAt(i)));
            StdDraw.pause(1000);
            drawFrame("");
            StdDraw.show();
            StdDraw.pause(500);

        }

    }

    public String solicitNCharsInput(int n) {
        //TODO: Read n letters of player input
        String s ="";
        for (int i = 0; i < n; i++) {
            while (!StdDraw.hasNextKeyTyped()) {
            }

            s += StdDraw.nextKeyTyped();
            drawFrame(s);

        }
        return s;
    }

    public void startGame() {
        //TODO: Set any relevant variables before the game starts
        round = 1;
        while (true) {
            playerTurn = false;
            drawFrame("Round: " + round);
            StdDraw.pause(1000);
            // watch

            String targetString = generateRandomString(round);
            flashSequence(targetString);

            // type
            playerTurn = true;
            drawFrame("");
            String inputString = solicitNCharsInput(round);
            StdDraw.pause(1000);

            if (inputString.equals(targetString)) {
                round += 1;
            } else {
                gameOver = true;
                drawFrame("Game Over! You made it to round: " + round);
                return;
            }

        }

        //TODO: Establish Game loop
    }

}
