import java.util.Scanner;

public class BankingApp {

    public static final String WELCOME_MESSAGE = "WELCOME TO BECKETT BANK";
    private static BankAccount bankAccount;

    public static void  main(String[] args) {
        bankAccount = new BankAccount("", 0.0);
        printWelcomeMenu();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            input = scanner.next();

            if ("L".equalsIgnoreCase(input)) {
                printPromptMenu("Customer Login ID");
            }
            else if (input != null && input.length() > 1) {
                bankAccount.setCustomerName(input);
                printCustomerMenu();
            }
            else if ("B".equalsIgnoreCase(input)) {
                printBalanceMenu("");
            }
            else if ("D".equalsIgnoreCase(input)) {
                printPromptMenu("Deposit Amount");
                printBalanceMenu(bankAccount.makeDeposit(scanner.next()));
            }
            else if ("W".equalsIgnoreCase(input)) {
                printPromptMenu("Withdrawal Amount");
                printBalanceMenu(bankAccount.makeWithdrawal(scanner.next()));
            }
            else {
                bankAccount.setCustomerName("");
                printWelcomeMenu();
            }

        } while (!"0".equals(input));
    }

    private static void printBalanceMenu(String message) {
        System.out.println("*****************************************************************************");
        System.out.println("*                       " + WELCOME_MESSAGE + ", " +
                bankAccount.getCustomerName() + "!" + getFillerSpaces(26-bankAccount.getCustomerName().length())+  "*");
        System.out.println("*                                                                           *");

        if ("".equalsIgnoreCase(message) || message == null) {
            System.out.println("*      Account balance is $" +
                    bankAccount.printFormattedBalance() + getFillerSpaces(49-bankAccount.printFormattedBalance().length())+  "*");
        }
        else {
            System.out.println("*      " + message + getFillerSpaces(69-message.length())+  "*");
        }

        System.out.println("*                                                                           *");
        System.out.println("*      B. Check account balance                                             *");
        System.out.println("*      D. Make a deposit                                                    *");
        System.out.println("*      W. Make a withdrawal                                                 *");
        System.out.println("*                                                                           *");
        System.out.println("*      0. Exit                                                              *");
        System.out.println("*****************************************************************************");
    }

    private static String getFillerSpaces(int length) {
        String spaces = "";
        for (int i = 0; i < length; i++) {
            spaces += " ";
        }
        return spaces;
    }

    private static void printCustomerMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("*                       " + WELCOME_MESSAGE + ", " +
                bankAccount.getCustomerName() + "!" + getFillerSpaces(26-bankAccount.getCustomerName().length())+  "*");
        System.out.println("*      B. Check account balance                                             *");
        System.out.println("*      D. Make a deposit                                                    *");
        System.out.println("*      W. Make a withdrawal                                                 *");
        System.out.println("*                                                                           *");
        System.out.println("*      0. Exit                                                              *");
        System.out.println("*****************************************************************************");
    }

    private static void printPromptMenu(String promptName) {
        String nameAndSpaces = "".equals(bankAccount.getCustomerName()) ?
                getFillerSpaces(29) :
                " " + bankAccount.getCustomerName() + "!" + getFillerSpaces(27-bankAccount.getCustomerName().length());
        System.out.println("*****************************************************************************");
        System.out.println("*                       " + WELCOME_MESSAGE + nameAndSpaces + "*");
        System.out.println("*                      Enter " + promptName + getFillerSpaces(47-promptName.length()) + "*");
        System.out.println("*****************************************************************************");
    }

    private static void printWelcomeMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("*                       " + WELCOME_MESSAGE + "                             *");
        System.out.println("*      L. Login                                                             *");
        System.out.println("*                                                                           *");
        System.out.println("*      0. Exit                                                              *");
        System.out.println("*****************************************************************************");
    }


}
