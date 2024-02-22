import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static Account activeAccount = null;
    private static int accountCounter = 1;

    public static void main(String[] args) {
        int option = 0;
        while (option != 4) {
            try {
                mainMenu();
                option = Integer.parseInt(in.nextLine());
                switch (option) {
                    case 1:
                        createClient();
                        break;
                    case 2:
                        createAccount();
                        break;
                    case 3:
                        accountMaintenance();
                        break;
                    case 4:
                        System.out.println("Exit.");
                        break;

                    default:
                        System.out.println("Option not valid, select an option between 1 and 4");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Number format not valid");
            }
        }
        in.close();
    }

    private static void createClient() {
        System.out.println("Client name:");
        String name = validateName();
        System.out.println("Client lastnames:");
        String lastNames = in.nextLine();
        System.out.println("Client address:");
        String address = in.nextLine();
        System.out.println("Client city:");
        String city = in.nextLine();
        System.out.println("Client birthday YYYY-MM-DD:");
        LocalDate birthday = validateBirthday();

        clients.add(new Client(name, lastNames, address, city, birthday));
        System.out.println("Client " + name + " " + lastNames + " created succesfully.");

    }

    private static String validateName() {
        while (true) {
            try {
                String s = in.nextLine();
                for (Client client : clients) {
                    if (client.getName().equals(s)) {
                        throw new ClientExistsException(client);
                    }
                }
                return s;
            } catch (ClientExistsException e) {
                System.out.println(e);
            }
        }
    }

    private static LocalDate validateBirthday() {
        while (true) {
            try {
                return LocalDate.parse(in.nextLine());
            } catch (Exception e) {
                System.out.println("Date format is not correct: YYYY-MM-DD");
            }
        }
    }

    private static void createAccount() {
        if (clients.isEmpty()) {
            System.out.println("There are no clients in the bank, you must create one first");
            return;
        }

        Client client = validateClient();

        Account account = validateAccount(client);

        accounts.add(account);
        System.out.println("Account for " + client.fullName() + " created succesfully.");
    }

    private static Account validateAccount(Client c) {
        int option;
        while (true) {
            try {
                accountTypeMenu();
                option = Integer.parseInt(in.nextLine());
                switch (option) {
                    case 1:
                        return new CurrentAccount(accountCounter++, c);
                    case 2:
                        return new MortgageAccount(accountCounter++, c);
                    case 3:
                        return new InvestmentFund(accountCounter++, c);
                    default:
                        System.out.println("Option not valid, select an option between 1 and 3");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Number format not valid");
            }
        }

    }

    private static Client validateClient() {
        String name;
        while (true) {
            System.out.println("Client name to create an account for:");
            for (Client c : clients) {
                System.out.println(c.getName());
            }
            name = in.nextLine();
            for (Client c : clients) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
    }

    private static void accountMaintenance() {
        if (accounts.isEmpty()) {
            System.out.println("There are no accounts in the bank, you must create one first");
            return;
        }

        int accountNumber = 0;
        do {
            try {
                System.out.println("Select an account by account number:");
                for (Account a : accounts) {
                    System.out.println(a.toString());
                }
                accountNumber = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Number format not valid");
            }
        } while (!validateAccount(accountNumber));

        selectAccountOption();
    }

    private static boolean validateAccount(int accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                activeAccount = a;
                return true;
            }
        }
        return false;
    }

    private static void selectAccountOption() {
        int option = 0;
        while (option != 4) {
            try {
                accountMenu();
                option = Integer.parseInt(in.nextLine());
                switch (option) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        activeAccount.viewAccount();
                        break;
                    case 4:
                        System.out.println("Back to Main Menu.");
                        break;

                    default:
                        System.out.println("Option not valid, select an option between 1 and 4");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Number format not valid");
            }
        }
    }

    private static void deposit() {
        try {
            System.out.println("Amount to deposit:");
            int amount = Integer.parseInt(in.nextLine());
            activeAccount.deposit(amount);

        } catch (InvalidDepositException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("Number format not valid");
        }
    }

    private static void withdraw() {
        try {
            System.out.println("Amount to withdraw:");
            int amount = Integer.parseInt(in.nextLine());
            activeAccount.withdraw(amount);
        } catch (InvalidWithdrawException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("Number format not valid");
        }

    }

    private static void mainMenu() {
        String s = """

                MAIN MENU
                1 - Create Client
                2 - Create Account
                3 - Account Maintenance
                4 - Exit
                """;
        System.out.println(s);
    }

    private static void accountMenu() {
        String s = """

                ACCOUNT MENU
                1 - Deposit
                2 - Withdrawal
                3 - View Account Data
                4 - Back to Main Menu
                """;
        System.out.println(s);
    }

    private static void accountTypeMenu() {
        String s = """

                ACCOUNT MENU
                1 - Current Account
                2 - Mortgage Account
                3 - Investment Fund
                4 - Back to Main Menu
                """;
        System.out.println(s);
    }

}
