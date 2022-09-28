import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Main {
    private static BufferedReader br;
    private static Character player = null;
    private static BatlleLogic battleLogic = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battleLogic = new BatlleLogic();
        System.out.println("Set name of your Character:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(string, 100, 2, 20, 10, 10);
            System.out.println(String.format("Our new hero is  %s! Let's do it", player.getName()));
            printNavigation();
        }
        switch (string) {
            case "1": {
                System.out.println("Seller is out of Here...");
                command(br.readLine());
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "Yes":
                command("2");
                break;
            case "No": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println("Where do you want to go?");
        System.out.println("1. Seller");
        System.out.println("2. Dark Forest");
        System.out.println("3. Exit");
    }

    private static void commitFight() {
        battleLogic.fight(player, createMonster(), new FightCallback() {
            public void fightWin() {
                System.out.println(String.format("%s win! You have: %d exp and %d gold and %d health", player.getName(), player.getExp(), player.getGold(), player.getHealth()));
                System.out.println("Do you want continue or back in city?");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void fightLost() {

            }
        });
        }
        private static Character createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin("Goblin", 50, 10, 10, 100, 20);
        else return new Skeleton("Skeleton", 25, 20, 20, 150, 10);

        };

    public interface FightCallback {
        void fightWin();
        void fightLost();
    }

}
//
//    interface FightCallback {
//    void fightWin();
//    void fightLost();



