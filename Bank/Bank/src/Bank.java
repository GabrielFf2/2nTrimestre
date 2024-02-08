import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Bank {
    private static  int accountCounter=0;
    private static Account activeAccount;


    public static void main(String[] args) {

        boolean a = true;

        Scanner scanner = new Scanner(System.in);
        while (a){
            System.out.println("MAIN MENU \n 1-Create Client \n 2-Create Account \n 3-Account Maintenance \n 4-Exit ");
            switch (scanner.nextInt()){
                case 1:
                    createClient();
                    break;
                case 2:
                    if (clients.isEmpty()){
                        System.out.println("Primer has de crear un client per poder fer una compte .");
                    }else {
                        System.out.println("Client name to create an account for:");
                        Scanner scannerr = new Scanner(System.in);
                        String nom = scannerr.nextLine();
                        createAccount(nom);
                        System.out.println("Account for "+ nom +" created succesfully.");
                    }
                    break;
                case 3:
                    System.out.println("Select an account by account number:");
                    for (Account aco: accounts) {
                        System.out.println(aco.toString());
                    }
                    int numCompte = scanner.nextInt();
                    activeAccount = accounts.get(numCompte);
                    Borders.printTextWithBorders(activeAccount.toString());
                    boolean b = true;
                    while (b){
                        System.out.println("ACCOUNT MENU \n 1-Deposit \n 2-Withfrawl \n 3-View Account Data \n 4-Back to Main Menu ");
                        switch (scanner.nextInt()){
                            case 1:
                                System.out.println("Amount to deposit:");
                                activeAccount.deposit(scanner.nextDouble());
                                break;
                            case 2:
                                System.out.println("Amount to withdraw:");
                                activeAccount.whithdraw(scanner.nextDouble());
                                break;
                            case 3:
                                Borders.printTextWithBorders("Account Number:" + activeAccount.getAccountNumber() + "\n Owner:" +activeAccount.getClient().fullName()
                                        +"    Address at C/"+activeAccount.getClient().fullAddress()+"\n Current balance: "+activeAccount.getBalance()+"$");
                                Borders.printTextWithBorders(activeAccount.viewAccount());
                                break;
                            case 4:
                                System.out.println("Back to Main Menu");
                                b = false;
                                break;
                        }
                    }

                    break;
                case 4:
                    a = false;
                    break;
            }

        }

    }

    static ArrayList<Account> accounts = new ArrayList<Account>();
    static ArrayList<Client> clients = new ArrayList<Client>();
    public static void createAccount(String nomCompletClient){
        for (Client A : clients){
            String nom1 = A.fullName().toLowerCase();
            String nom2 = nomCompletClient.toLowerCase(Locale.ROOT);
            if (nom1.equals(nom2)){
                accounts.add(new Account(A));
            }
        }
    }
    public static void createClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom del Client");
        String nameClient = scanner.nextLine();
        System.out.println("Llinatge del Client");
        String lastNameClient = scanner.nextLine();
        System.out.println("Adreça del Client");
        String addressClient = scanner.nextLine();
        System.out.println("Ciutat del Client");
        String cityClient = scanner.nextLine();
        System.out.println("Data de neixament del Client");
        String birthDateClient = scanner.nextLine();
        clients.add(new Client(nameClient,lastNameClient,addressClient,cityClient,birthDateClient));
    }

}
