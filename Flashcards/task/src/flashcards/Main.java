
package flashcards;

import java.util.InputMismatchException;
import java.util.Scanner;


abstract class FlashCard{

    private int numberOfCards;
    private String[] cards;
    private String[] definitions;
    private String cardsCounter;
    private String definitionsCounter;
    private String card;
    private String definition;
    private String answer;

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

    /*Getter and setter for card*/

    public void setCard(String card){
        this.card = card;
    }

    public java.lang.String getCard() {
        return card;
    }

    /*Setter and getter for definition*/

    public void setDefinition(String definition){
        this.definition = definition;
    }

    public String getDefinition(){
        return definition;
    }

    /*Setter and getter for answer*/

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
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
            cardChecker(sc.nextLine(), counter);
            setDefinitionsCounter(i);
            System.out.println(getDefinitionsCounter());
            definitionsChecker(sc.nextLine(), counter);
            counter++;
        }
    }

    @Override
    public void readCard(){
        for (int i = 0; i < getNumberOfCards(); i++){
            System.out.println("Print the definition of \"" + getCards()[i] + "\":");
            setAnswer(sc.nextLine());
            if (getAnswer().equals(getDefinitions()[i])){
                System.out.println("Correct answer");
            } else if (answerChecker(i) == false){
                System.out.println("Wrong answer. The correct one is \"" +
                        getDefinitions()[i] + "\"");
            }
        }
    }

    public void cardChecker(String input, int counter){
        setCard(input);
        for (int i = 0; i < counter; i++){
            if (getCards()[i].equals(input)){
                System.out.println("The card \""
                        + input + "\" already exists. Try again:");
                cardChecker(sc.nextLine(), counter);
            }
        }
        setCards(getCard(), counter);
    }

    public void definitionsChecker(String input, int counter){
        setDefinition(input);
        for (int i = 0; i < counter; i++){
            if (getDefinitions()[i].equals(input)){
                System.out.println("The definition \"" +
                        input + "\" already exists. Try again:");
                definitionsChecker(sc.nextLine(), counter);
            }
        }
        setDefinitions(getDefinition(), counter);
    }

    public boolean answerChecker(int index){

        for(int i = 0; i < getNumberOfCards(); i++){
            if (getDefinitions()[i].equals(getAnswer())){

                System.out.println("Wrong answer, The correct one is " + "\""
                        + getDefinitions()[index] + "\", you've just written the definition of \"" +
                        getCards()[i] + "\".");
                return true;
            }
        }
        return false;
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