import java.util.*;

/*
1. Використовуй багаторядковий String замість конкатенації
2. Слово Word виглядає як масив, а має відображатися як слово
   hiddenWord = "mountain";
   toString(guessedWord) = "________";
   // відгадано ano
   toString(guessedWord) = "_o_n_a_n";
3. Між usedSymbols постав пробіл.
TODO:
  4. Показувати usedLetters відсортовано за алфавітом
 */

public class Game {
    static Scanner scanner = new Scanner(System.in);
    private static final int life = 8; // загальна кількість життів
    private static final List<String> words = new ArrayList<>(List.of("weather", "fly", "mountain", "street","generate", "computer",
            "kitchen", "music", "helicopter", "leather", "yellow", "object", "error",
            "pencil", "want", "room", "forest", "daughter", "liver", "autumn", "danger", "glass", "words"));
    private String hiddenWord; // загадане слово
    private char[] guessedWord; // вгаданні букви
    private StringBuilder usedLetters; // використанні букви
    private int lifeLeft; // решта життів

    // конструктор
    public Game(){
        hiddenWord = randomWord();
        guessedWord = new char[hiddenWord.length()];
        // заповнення символами '-'
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        usedLetters = new StringBuilder();
        lifeLeft = life;
    }

    // вибір випадкового слова
    static String randomWord(){
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    static String toString(char[] arr){
        StringBuilder text = new StringBuilder();
        for (char c : arr){
            text.append(c);
        }
        return text.toString();
    }


    public void play(){
        boolean present = false;
        while (lifeLeft > 0){
            if (lifeLeft == 8){
                System.out.printf("""
                        .                                Word:
                        .                                %s
                        .                          
                        .                          
                        .                          
                        .                          
                        ._________________________ 
                        
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 7) {
                System.out.printf("""
                        .                         |      Word:
                        .                         |      %s
                        .                         |
                        .                         |
                        .                         |
                        .                         |
                        ._________________________|
                        
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 6) {
                System.out.printf("""
                        .              ____________
                        .                         |      Word:
                        .                         |      %s
                        .                         |
                        .                         |
                        .                         |
                        .                         |
                        ._________________________|
                        
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 5) {
                System.out.printf("""
                        .              ____________
                        .                |        |      Word:
                        .                         |      %s
                        .                         |    
                        .                         |
                        .                         |
                        .                         |
                        ._________________________|
                        
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 4) {
                System.out.printf("""
                        .              ____________
                        .                |        |      Word:
                        .               ( )       |      %s
                        .                         |
                        .                         |
                        .                         |
                        .                         |
                        ._________________________|
                        
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 3) {
                System.out.printf("""
                        .              ____________
                        .                |        |      Word:
                        .               ( )       |      %s
                        .               / \\       |
                        .                         |
                        .                         |
                        .                         |
                        ._________________________|
                       
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 2){
                System.out.printf("""
                        .              ____________
                        .                |        |      Word:
                        .               ( )       |      %s
                        .               /|\\       |
                        .                |        |
                        .                         |
                        .                         |
                        ._________________________|
                         
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            } else if (lifeLeft == 1){
                System.out.printf("""
                        .              ____________
                        .                |        |      Word:
                        .               ( )       |      %s
                        .               /|\\       |
                        .                |        |
                        .               /         |
                        .                         |
                        ._________________________|
                         
                             Used symbols:
                             %s
                        """, toString(guessedWord), sortedUsedLetter(usedLetters));
            }
            System.out.print("Enter a letter: ");
            char current = scanner.nextLine().toLowerCase().charAt(0);
            if (!Character.isLetter(current)) {
                System.out.println("Please enter a letter.");
                continue;
            }
            if (usedLetters.indexOf(String.valueOf(current)) != -1) {
                System.out.println("You've already used that letter.");
                continue;
            }
            usedLetters.append(current);
//            usedLetters.append(current).append(" ");

            // перевірка чи присутня буква у слові
            present = hiddenWord.contains(String.valueOf(current));
            if (!present){
                lifeLeft--;
            } else {
                for (int i = 0; i < guessedWord.length; i++) {
                    if (hiddenWord.charAt(i) == current){
                        guessedWord[i] = current;
                    }
                }
            }

            // перевірка чи слово вгадане
            if (String.valueOf(guessedWord).equals(hiddenWord)){
                System.out.println("You guessed the word: " + hiddenWord);
                return;
            }
        }

        // програш:
        System.out.printf("""
                .              ____________
                .                |        |      Word:
                .               ( )       |      %s
                .               /|\\       |
                .                |        |
                .               / \\       |
                .                         |
                ._________________________|
                 
                     Used symbols:
                     %s
                """, toString(guessedWord), sortedUsedLetter(usedLetters));
        System.out.println("You are lose");
        System.out.println("This word is: " + hiddenWord);
    }

    static String sortedUsedLetter(StringBuilder usedLetters) {
        char[] arr = new char[usedLetters.length()];
        for (int i = 0; i < usedLetters.length(); i++) {
            arr[i] = usedLetters.charAt(i);
        }
        Arrays.sort(arr);
        StringBuilder result = new StringBuilder();
        for (char c : arr) {
            result.append(c + " ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
