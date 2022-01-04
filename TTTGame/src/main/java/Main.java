import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
  public static void main (String[] args) throws IOException {
    GameLogic gameInstance = new GameLogic();
    boolean quit = false;
    System.out.println("Welcome to tic tac toe");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (!quit) {
      String input = reader.readLine();
      if (input.equals("quit")) {
        quit = true;
      } else if (input.equals("board")) {
        gameInstance.printBoard();
      } else if (input.matches("place token \\d")) {
        int position = Integer.parseInt(input.split(" ")[2]);
        if (gameInstance.newMove(position)) {
          System.out.print("Success");
        } else {
          System.out.println("Failed to place token at position " + position);
        }
      } else {
        System.out.println("Did not recognize your command");
      }
    }
  }
}
