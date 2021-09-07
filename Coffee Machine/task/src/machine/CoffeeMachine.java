package machine;
import java.util.Scanner;

public class CoffeeMachine {
// initial state
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int disposableCups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String selection = scanner.next();
            switch (selection) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String bev = scanner.next();
                    buyCoffee(bev);
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add: ");
                    water = water + scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk = milk + scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    coffee = coffee + scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    disposableCups = disposableCups + scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    status(water, milk, coffee, disposableCups, money);
                    break;
                case "exit":
                    loop = false;
                    return;
            }
        }
    }

    private static void status(int water, int milk, int coffee, int disposableCups, int money) {
        System.out.println("The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffee + " g of coffee beans\n" +
                disposableCups + " disposable cups\n" +
                money + " of money\n");
    }

    private static void buyCoffee(String bev) {
        switch (bev) {
            case "1":
                if (water >= 250) {
                    if (coffee >= 16) {
                        water = water - 250;
                        coffee = coffee - 16;
                        money = money + 4;
                        disposableCups = disposableCups - 1;
                        System.out.println("I have enough resources, making you a coffee!");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2":
                if (water >= 350) {
                    if (milk >= 75) {
                        if (coffee >= 20) {
                            water = water - 350;
                            milk = milk - 75;
                            coffee = coffee - 20;
                            money = money + 7;
                            disposableCups = disposableCups - 1;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            System.out.println("Sorry, not enough coffee!");
                        }
                    } else {
                        System.out.println("Sorry, not enough milk!");
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "3":
                if (water >= 200) {
                    if (milk >= 100) {
                        if (coffee >= 12) {
                        water = water - 200;
                        milk = milk - 100;
                        coffee = coffee - 12;
                        money = money + 6;
                        disposableCups = disposableCups - 1;
                        System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            System.out.println("Sorry, not enough coffee!");
                        }
                    } else {
                        System.out.println("Sorry, not enough milk!");
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "back":
                return;
        }
    }
}
