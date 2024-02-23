import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    private static final int life = 8;
    private static final List<String> words = new ArrayList<>(List.of("weather", "fly", "mountain", "street","generate", "computer",
            "kitchen", "music", "helicopter", "leather", "yellow", "object", "error",
            "pencil", "want", "room", "forest", "daughter", "liver", "autumn", "danger", "glass", "words"));
    private String hiddenWord;
    private char[] guessedWord;
    private StringBuilder usedLetters;
    private int lifeLeft;

    public Game(){
        hiddenWord = randomWord();
        guessedWord = new char[hiddenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }
        usedLetters = new StringBuilder();
        lifeLeft = life;
    }

    static String randomWord(){
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    public void play(){
        boolean present = false;
        while (lifeLeft > 0){
            if (lifeLeft == 8){
                System.out.println("\n" +
                        "    \n" +
                        "                               Word:\n" +
                        "                               " + Arrays.toString(guessedWord) + "\n" +
                        "                                     \n" +
                        "                                \n" +
                        "\n" +
                        "\n" +
                        "_________________________\n" +
                        "\n" +
                        "Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 7) {
                System.out.println("\n" +
                        "                         |      Word:\n" +
                        "                         |" + "    " + Arrays.toString(guessedWord) + "\n" +
                        "                         |           \n" +
                        "                         |\n" +
                        "                         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 6) {
                System.out.println("        ____________\n" +
                        "                         |      Word:\n" +
                        "                         |" + "    " + Arrays.toString(guessedWord) + "\n" +
                        "                         |            \n" +
                        "                         |\n" +
                        "                         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 5) {
                System.out.println("\"\"\"\n" +
                        "             ____________\n" +
                        "                |        |      Word:\n" +
                        "                         |" + "      " + Arrays.toString(guessedWord) + "\n" +
                        "                         |           \n" +
                        "                         |\n" +
                        "                         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 4) {
                System.out.println("\"\"\"\n" +
                        "             ____________\n" +
                        "                |        |      Word:\n" +
                        "               ( )       |" + "      " + Arrays.toString(guessedWord) + "\n" +
                        "                         |           \n" +
                        "                         |\n" +
                        "                         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 3) {
                System.out.println("\"\"\"\n" +
                        "             ____________\n" +
                        "                |        |      Word:\n" +
                        "               ( )       |" + "      " + Arrays.toString(guessedWord) + "\n" +
                        "               / \\\\      |      \n" +
                        "                         |\n" +
                        "                         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 2){
                System.out.println("        ____________\n" +
                        "                |        |      Word:\n" +
                        "               ( )       |" + "      " + Arrays.toString(guessedWord) + "\n" +
                        "               /|\\\\      |      \n" +
                        "                |        |\n" +
                        "                         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            } else if (lifeLeft == 1){
                System.out.println("        ____________\n" +
                        "                |        |      Word:\n" +
                        "               ( )       |" + "      " + Arrays.toString(guessedWord) + "\n" +
                        "               /|\\\\      |      \n" +
                        "                |        |\n" +
                        "               /         |\n" +
                        "                         |\n" +
                        "_________________________|\n" +
                        "\n" +
                        "     Used symbols:\n" +
                        usedLetters + "\n");
            }
            System.out.print("Enter a letter: ");
            char current = scanner.next().toLowerCase().charAt(0);
            if (!Character.isLetter(current)) {
                System.out.println("Please enter a letter.");
                continue;
            }
            if (usedLetters.indexOf(String.valueOf(current)) != -1) {
                System.out.println("You've already used that letter.");
                continue;
            }
            usedLetters.append(current);
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == current) {
                    guessedWord[i] = current;
                    present = true;
                }
            }
            if (!present){
                lifeLeft --;
            }
            if (String.valueOf(guessedWord).equals(hiddenWord)){
                System.out.println("You guessed the word: " + hiddenWord);
                return;
            }
        }
        System.out.println("        ____________\n" +
                "                |        |      Word:\n" +
                "               ( )       |" + "      " + Arrays.toString(guessedWord) + "\n" +
                "               /|\\\\      |      \n" +
                "                |        |\n" +
                "               / \\\\      |\n" +
                "                         |\n" +
                "_________________________|\n" +
                "\n" +
                "     Used symbols:\n" +
                usedLetters + "\n");
        System.out.println("You are lose");
        System.out.println("This word is: " + hiddenWord);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
