import java.util.Scanner;

public class CoffeeMachine {
    private int balance;

    public class CoffeeList {
        public int price;
        public String type;

        public CoffeeList(int price, String type) {
            this.price = price;
            this.type = type;
        }
    }

    CoffeeList[] coffeeMenu = {
        new CoffeeList(15000, "Espresso"),
        new CoffeeList(20000, "Americano"),
        new CoffeeList(25000, "Cappucino")
    };

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        for (int i = 0; i < coffeeMenu.length; i++) {
            System.out.println((i + 1) + ". " + coffeeMenu[i].type + "\tRp " + coffeeMenu[i].price);
        }
    }

    public void addBalance(int amount) {
        balance = amount;
        System.out.println("Balance: Rp " + balance);
    }

    public void buyCoffee(int coffeeIndex) {
        if (coffeeIndex < 1 || coffeeIndex > coffeeMenu.length) {
            System.out.println("Invalid selection, returning money.");
            return;
        }

        CoffeeList selectedCoffee = coffeeMenu[coffeeIndex - 1];
        if (balance >= selectedCoffee.price) {
            int change = balance - selectedCoffee.price; 
            balance = 0; 
            System.out.println("Your " + selectedCoffee.type + " is ready, enjoy!");
            if (change > 0) {
                System.out.println("Your change: Rp " + change);
            } else {
                System.out.println("No change.");
            }
        } else {
            System.out.println("Insufficient balance. Please try again.");
        }
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert money: Rp ");
        int amount = scanner.nextInt();
        machine.addBalance(amount);

        machine.displayMenu();
        System.out.print("Select coffee (1-3): ");
        int coffeeIndex = scanner.nextInt();
        machine.buyCoffee(coffeeIndex);

        scanner.close();
    }
}
