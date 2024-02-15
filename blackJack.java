import java.util.Scanner;

public class blackJack {

    // Global access
    public static Scanner sc = new Scanner(System.in);
    public static int total = 0; // Total score of player 1
    public static int total2 = 0; // Total score of player 2 (dealer)

    // Method to display the menu
    public static int numberOfAcesAsEleven = 0; // Track Aces counted as 11

    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!");
        System.out.println("When you're ready to play press Enter to start");
        sc.nextLine();

        // Get player details
        System.out.println("Player 2 is the dealer!\n");

        System.out.println("Enter player 1 name: ");
        String p1Name = sc.nextLine();
        System.out.println();
        System.out.println("Enter player 2 name: ");
        String p2Name = sc.nextLine();


        // Player 1's turn
        System.out.println("It is " + p1Name + "s turn...\n");
        int card1 = drawRandomCard();
        int card2 = drawRandomCard();

        System.out.println("Your Cards are: ");
        System.out.println("You get a \n" + cardString(card1) + "\n and a \n" + cardString(card2));
        total = calculateTotal(card1, total);
        total = calculateTotal(card2, total);
        System.out.println("\nYour Current Total is: " + total + "\n");

        while (true) {
           // if (total >= 21) break;
            String option = hitOrStay();
            if (option.equals("s")) {
                break;
            } else if (option.equals("h")) {
                int newCard = drawRandomCard();
                System.out.println("Your new Card is: \n" + cardString(newCard));
                total = calculateTotal(newCard, total);
                System.out.println("Your new Total is: " + total);
                if (total > 21) {
                    System.out.println("Bust!");
                    break;
                }
            }
        }

        // Player 2's turn
        // Adjusted for Player 2's turn with correct total tracking
        System.out.println("\nIt is " + p2Name + "'s turn...\n" + "You are the dealer!\n");

        // Dealer logic: hit until total reaches 17 or more
        int card3 = drawRandomCard(); // Draw initial card for dealer
        int card4 = drawRandomCard(); // Draw second card for dealer
        total2 = calculateTotal(card3, total2); // Update dealer's total with the initial card
        total2 = calculateTotal(card4, total2); // Update dealer's total with the second card
        System.out.println(p2Name + " first card: \n" + cardString(card3));
        System.out.println(p2Name +  " Second card: \n" + cardString(card4));

        System.out.println(p2Name + " Current Total is: " + total2);

        // Assuming dealer follows traditional rules of hitting until reaching a soft 17
        while (total2 < 17) {
            String option = hitOrStay();
            if (option.equals("s")) {
                break;
            } else if (option.equals("h")) {
                int newCard = drawRandomCard();
                System.out.println("Your new Card is: \n" + cardString(newCard));
                total2 = calculateTotal(newCard, total2);
                System.out.println("Your new Total is: " + total2);
                if (total2 > 21) {
                    System.out.println("Bust!");
                    break;
                }
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("Scores: ");
        System.out.println(p1Name + ": " + total);
        System.out.println(p2Name + ": " + total2);

        // Determine winner
        if (total > 21) {
            System.out.println(p1Name + " busts! " + p2Name + " wins.");
        } else if (total2 > 21 || total > total2) {
            System.out.println(p1Name + " wins!");
        } else if (total == total2) {
            System.out.println("It's a tie!");
        } else {
            System.out.println(p2Name + " wins!");
        }

        System.out.println("\nThanks for playing!");
    }

    /**
     * 
     * function to prompt the user to hit or stay
     * 
     * @return (String)
     */
    
    public static String hitOrStay() {
        System.out.println("Press 'h' to hit or 's' to stay");
        String response = sc.nextLine();
        while (!(response.equals("h") || response.equals("s"))) {
            System.out.println("You must Enter 'h' or 's'! ");
            response = sc.nextLine();
        }
        return response.toLowerCase();
    }

    /**
     * 
     * function to calculate the total
     * 
     * @param newCard
     * @param currentTotal
     * @return (int)
     */

     public static int calculateTotal(int newCard, int currentTotal) {
        if (newCard == 1) {
            numberOfAcesAsEleven++;
            currentTotal += 11;
        } else if (newCard >= 2 && newCard <= 9) {
            currentTotal += newCard;
        } else {
            currentTotal += 10;
        }
        while (currentTotal > 21 && numberOfAcesAsEleven > 0) {
            currentTotal -= 10;
            numberOfAcesAsEleven--;
        }
    
        return currentTotal;
    }

    /**
     * 
     * Draw a random card
     * 
     * @return (int)
     */

    public static int drawRandomCard() { // Getting a random number between 1 and 13
        return (int) (Math.random() * 13) + 1;
    }

    /**
     * 
     * function to return the card string representation
     * 
     * @param cardNumber
     * @return (String) - The suit of the given card number
     */

    public static String cardString(int cardNumber){ // All the cards
        switch(cardNumber){
            case 1:
                return
                        "  ______ \n"+
                        " |A      | \n"+
                        " |       | \n"+
                        " |   A   | \n"+
                        " |       | \n"+
                        " |______A| \n";
            case 2:
                return
                        "  ______ \n"+
                        " |2      | \n"+
                        " |       | \n"+
                        " |   2   | \n"+
                        " |       | \n"+
                        " |______2| \n";
            case 3:
                return
                        "  ______ \n"+
                        " |3      | \n"+
                        " |       | \n"+
                        " |   3   | \n"+
                        " |       | \n"+
                        " |______3| \n";
            case 4:
                return
                        "  ______ \n"+
                        " |4      | \n"+
                        " |       | \n"+
                        " |   4   | \n"+
                        " |       | \n"+
                        " |______4| \n";
    
            case 5:
                return
                        "  ______ \n"+
                        " |5      | \n"+
                        " |       | \n"+
                        " |   5   | \n"+
                        " |       | \n"+
                        " |______5| \n";
    
            case 6:
                return
                        "  ______ \n"+
                        " |6      | \n"+
                        " |       | \n"+
                        " |   6   | \n"+
                        " |       | \n"+
                        " |______6| \n";
    
            case 7:
                return
                        "  ______ \n"+
                        " |7      | \n"+
                        " |       | \n"+
                        " |   7   | \n"+
                        " |       | \n"+
                        " |______7| \n";
    
            case 8:
                return
                        "  ______ \n"+
                        " |8      | \n"+
                        " |       | \n"+
                        " |   8   | \n"+
                        " |       | \n"+
                        " |______8| \n";
    
            case 9:
                return
                        "  ______ \n"+
                        " |9      | \n"+
                        " |       | \n"+
                        " |   9   | \n"+
                        " |       | \n"+
                        " |______9| \n";
    
    
            case 10:
                return
                        "  _______ \n"+
                        " |10      | \n"+
                        " |        | \n"+
                        " |   10   | \n"+
                        " |        | \n"+
                        " |______10| \n";
    
            case 11:
                return
                        "  ______ \n"+
                        " |J      | \n"+
                        " |       | \n"+
                        " |   J   | \n"+
                        " |       | \n"+
                        " |______J| \n";
    
            case 12:
                return
                        "  ______ \n"+
                        " |Q      | \n"+
                        " |       | \n"+
                        " |   Q   | \n"+
                        " |       | \n"+
                        " |______Q| \n";
    
            case 13:
                return
                        "  ______ \n"+
                        " |K      | \n"+
                        " |       | \n"+
                        " |   K   | \n"+
                        " |       | \n"+
                        " |______K| \n";
            default:
                return
                        "Not a Valid Card";
            }
    }
}
