import java.util.Scanner;

public class BankSystem {

    public class BankAccount {
        String accountNumber;
        long balance;
        String name;

        public BankAccount(String accountNumber, String name, long balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = balance;
        }

        public void displayAccountInfo() {
            System.out.println("Nomor rekening : " + accountNumber);
            System.out.println("Nama : " + name);
            System.out.println("Saldo : Rp " + balance);
        }
    }

    public class Customer {
        BankAccount account;

        public Customer(BankAccount account) {
            this.account = account;
        }

        public void deposit(long amount) {
            if (amount > 0) {
                account.balance += amount;
                System.out.println("Berhasil melakukan penyetoran sejumlah Rp " + amount);
                System.out.println("Saldo sekarang : Rp " + account.balance);
            } else {
                System.out.println("Jumlah penyetoran tidak valid.");
            }
        }

        public void withdraw(long amount) {
            if (amount > 0 && account.balance >= amount) {
                account.balance -= amount;
                System.out.println("Berhasil melakukan penarikan sejumlah Rp " + amount);
                System.out.println("Saldo sekarang : Rp " + account.balance);
            } else if (amount <= 0) {
                System.out.println("Jumlah penarikan tidak valid.");
            } else {
                System.out.println("Saldo tidak mencukupi.");
            }
        }

        public void displayBalance() {
            account.displayAccountInfo();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankSystem bankSystem = new BankSystem();
        BankAccount account = bankSystem.new BankAccount("5025231169", "Medericus Mundi", 500000);
        Customer customer = bankSystem.new Customer(account);

        while (true) {
            System.out.println("\n1. Penyetoran");
            System.out.println("2. Penarikan");
            System.out.println("3. Tampilkan Informasi Akun");
            System.out.println("4. Keluar");
            System.out.print("Selamat datang di Bank Bank an: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Masukkan jumlah untuk disetorkan: Rp ");
                    long depositAmount = scanner.nextLong();
                    customer.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah untuk penarikan: Rp ");
                    long withdrawAmount = scanner.nextLong();
                    customer.withdraw(withdrawAmount);
                    break;
                case 3:
                    customer.displayBalance();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan invalid.");
            }
        }
    }
}
