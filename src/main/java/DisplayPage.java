import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DisplayPage {
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        gameTitle();
        menu();
//        intro();
//        ContOrQuit();
    }

    private void gameTitle() {
        try {
            String banner = Files.readString(Path.of("resource", "asciiGame.txt"));
            Files.lines(Path.of("resource", "asciiGame.txt"))
                    .forEach(line -> System.out.println("\u001B[31m" + "\033[1;31m" + line));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void menu() {
        System.out.println("\033[0;34m" + ".--------------.\n" + "| MENU OPTIONS |\n" + "'--------------'" + "\u001B[0m");
        System.out.println("[1]INTRO ------- [2]START GAME ------- [3]QUIT");

        boolean validInput = true;
        int number = 0;
        while (validInput) {
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1}")) {
                number = Integer.parseInt(input);
                if (!(number >= 1 && number <= 3)) {
                } else {
                    switch (number) {
                        case 1:
                            intro();
                            break;
                        case 2:
                            startGame();
                            break;
                        case 3:
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("I SEE THAT YOU ARE SCARED.\n COMEBACK WHEN YOU STOP BEING WEAK");
                            validInput = false;
                            break;
                    }

                }
            } else {
                System.out.println("invalid selection. Your options is from [1-3]");

            }
        }
    }
    private void intro(){
        try {
            String banner = Files.readString(Path.of("resource", "GameStoryIntro.txt"));
            Files.lines(Path.of("resource", "GameStoryIntro.txt"))
                    .forEach(line -> System.out.println("\u001B[31m" + line + "\u001B[0m"));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.print("[1]START GAME ------- [2]QUIT");
        boolean validInput = true;
        int option = 0;
        while (validInput) {
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1}")) {
                option = Integer.parseInt(input);
                if (!(option >= 1 && option <= 2)) {
                } else {
                    switch (option) {
                        case 1:
                            startGame();
                            break;
                        case 2:
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("I SEE THAT YOU ARE SCARED.\n COMEBACK WHEN YOU STOP BEING WEAK");
                            System.exit(0);
                            validInput = false;
                            break;
                    }
                }
            }else {
                System.out.println("invalid selection. Your options is from [1-2]");
            }
        }
    }
    private void startGame(){

    }
}


