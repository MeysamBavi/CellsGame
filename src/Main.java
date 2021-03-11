import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cells game = new Cells();
        Scanner sc = new Scanner(System.in);
        while (!game.checkWinner()) {
            game.printTable();
            System.out.println("Turn: " + game.getTurn());
            System.out.print("Enter column: ");
            while (!game.play(sc.nextInt()-1)) {
                System.out.println("Invalid input. Try Again.");
                System.out.print("Enter column: ");
            }
        }
        game.printTable();
        System.out.println("Congratulation " + game.getWinner() + "! You Won!!");
    }
}
