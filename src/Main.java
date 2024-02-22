import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String word = randomWord();
    static List<String> words = new ArrayList<>();
    public static String picture1 = "\n" +
            "    \n" +
            "                               Word:\n" +
            "                               " + countLetter() + "\n" +
            "                                     \n" +
            "                                \n" +
            "\n" +
            "\n" +
            "_________________________\n" +
            "\n" +
            "Used symbols:\n" +
            "\n" +
            words;
    public static String picture2 = "\n" +
            "                         |      Word:\n" +
            "                         |" + "    " + countLetter() + "\n" +
            "                         |           \n" +
            "                         |\n" +
            "                         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture3 = "        ____________\n" +
            "                         |      Word:\n" +
            "                         |" + "    " + countLetter() + "\n" +
            "                         |            \n" +
            "                         |\n" +
            "                         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture4 = "\"\"\"\n" +
            "             ____________\n" +
            "                |        |      Word:\n" +
            "                         |" + "      " + countLetter() + "\n" +
            "                         |           \n" +
            "                         |\n" +
            "                         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture5 = "\"\"\"\n" +
            "             ____________\n" +
            "                |        |      Word:\n" +
            "               ( )       |" + "      " + countLetter() + "\n" +
            "                         |           \n" +
            "                         |\n" +
            "                         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture6 = "\"\"\"\n" +
            "             ____________\n" +
            "                |        |      Word:\n" +
            "               ( )       |" + "      " + countLetter() + "\n" +
            "               / \\\\      |      \n" +
            "                         |\n" +
            "                         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture7 = "        ____________\n" +
            "                |        |      Word:\n" +
            "               ( )       |" + "      " + countLetter() + "\n" +
            "               /|\\\\      |      \n" +
            "                |        |\n" +
            "                         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture8 = "        ____________\n" +
            "                |        |      Word:\n" +
            "               ( )       |" + "      " + countLetter() + "\n" +
            "               /|\\\\      |      \n" +
            "                |        |\n" +
            "               /         |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;
    public static String picture9 = "        ____________\n" +
            "                |        |      Word:\n" +
            "               ( )       |" + "      " + countLetter() + "\n" +
            "               /|\\\\      |      \n" +
            "                |        |\n" +
            "               / \\\\      |\n" +
            "                         |\n" +
            "_________________________|\n" +
            "\n" +
            "     Used symbols:\n" +
            "\n" +
            words;

    static String randomWord(){
        Random random = new Random();
        List<String> words = List.of("weather", "fly", "mountain", "street","generate", "computer",
                "kitchen", "music", "helicopter", "leather", "yellow", "object", "error",
                "pencil", "want", "room", "forest", "daughter", "liver", "autumn", "danger", "glass", "words");
        int index = random.nextInt(words.size());
        return words.get(index);
    }

     public static String readLetter(String text){
        String letter = "";
        while (true){
            System.out.println(text);
            String current = "";
            current = scanner.nextLine();
            if (current.length() > 1 || isNumeric(current)){
                System.out.println("Enter the letter");
                continue;
            } else {
                break;
            }
        }
        return letter;
     }

    private static boolean isNumeric(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    static String countLetter(){
        int count = word.length();
        return  "-".repeat(count);
    }

    public static void main(String[] args) {
        int life = 8;
        System.out.println(picture1);
        while (life != 0){
            String letter = readLetter("Letter");
            if (word.contains(letter) && !words.contains(letter)){
                words.add(letter);
                System.out.println(picture1);
            } else {
                if (life == 7){
                    System.out.println(picture2);
                }
                if (life == 6){
                    System.out.println(picture3);
                }
                if (life == 5){
                    System.out.println(picture4);
                }
                if (life == 4){
                    System.out.println(picture5);
                }
                if (life == 3){
                    System.out.println(picture6);
                }
                if (life == 2){
                    System.out.println(picture7);
                }
                if (life == 1){
                    System.out.println(picture8);
                }
                words.add(letter);
                life --;
            }
        }
        System.out.println(picture9);
        System.out.println("You are lose");
        System.out.println("This word is: " + word);
    }
}
