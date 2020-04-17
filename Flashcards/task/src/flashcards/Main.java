
package flashcards;

import java.util.InputMismatchException;
import java.util.Scanner;


abstract class FlashCard{

    private int numberOfCards;
    private String[] cards;
    private String[] definitions;
    private String definition;
    private String card;
    private String answer;
    private String cardsCounter;
    private String definitionsCounter;

    public FlashCard(int numberOfCards){
        this.numberOfCards = numberOfCards;
        this.cards = new String[numberOfCards];
        this.definitions = new String[numberOfCards];
    }


    public int getNumberOfCards() {
        return numberOfCards;
    }

    /*Getter and Setter for String[] Cards*/

    public String[] getCards(){
        return cards;
    }

    public void setCards(String card, int index){
        this.cards[index] = card;
    }

    /*Setter and getter for String[] definitions*/

    public void setDefinitions(String definition, int ind) {
        this.definitions[ind] = definition;
    }

    public String[] getDefinitions(){
        return definitions;
    }

    /*Getter and Setter for cards counter*/

    public void setCardsCounter(int cardNum){
        this.cardsCounter = "The card #" + cardNum + ":";
    }

    public String getCardsCounter(){
        return cardsCounter;
    }

    /*Getter and setter for deffinitionCounter*/

    public void setDefinitionsCounter(int def){
        this.definitionsCounter = "The definition of the card #" + def + ":";
    }

    public String getDefinitionsCounter(){
        return definitionsCounter;
    }

    public abstract void writeCard();
    public abstract void readCard();
}
class CardGenerator extends FlashCard{

    Scanner sc = new Scanner(System.in);

    public CardGenerator(int numberOfCard){
        super(numberOfCard);
    }

    @Override
    public void writeCard(){
        int counter = 0;
        for (int i = 1; i <= getNumberOfCards(); i++){
            setCardsCounter(i);
            System.out.println(getCardsCounter());
            setCards(sc.nextLine(), counter);
            setDefinitionsCounter(i);
            System.out.println(getDefinitionsCounter());
            setDefinitions(sc.nextLine(), counter);
            //System.out.println(getCards()[counter] + "   " +  getDefinitions()[counter]);
            counter++;
        }
    }

    @Override
    public void readCard(){
        for (int i = 0; i < getNumberOfCards(); i++){
            System.out.println("Print the definition of \"" + getCards()[i] + "\":");
            if (sc.nextLine().equals(getDefinitions()[i])){
                System.out.println("Correct answer");
            } else {
                System.out.println("Wrong answer. The correct one is \""
                        + getDefinitions()[i] + "\".");
            }
        }
    }

}
public class Main {
    public static void main(String[] args) {

        System.out.println("Input the number of cards:");

        try(Scanner sc = new Scanner(System.in)){
            CardGenerator newCard = new CardGenerator(sc.nextInt());
            newCard.writeCard();
            newCard.readCard();
        } catch (InputMismatchException e){
            System.out.println("Incorrect value");
            System.exit(0);
        }
    }
}