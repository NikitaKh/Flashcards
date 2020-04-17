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

    public FlashCard(int numberOfCards){
        this.numberOfCards = numberOfCards;
        this.cards = new String[numberOfCards];
        this.definitions = new String[numberOfCards];
    }

    public void setDefinitions(String definition, int ind) {
        this.definitions[ind] = definition;
    }

    public String[] getDefinitions(){
        return definitions;
        }

    public String getCard(){
        return card;
    }

    public void setCard(String card){
        this.card = card;
    }

    public void setCardsCounter(int cardNum){
        this.cardsCounter = "The card #" + cardNum + ":";
    }

    public String getCardsCounter(){
        return cardsCounter;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    public String[] getCards(){
        return cards;
    }

    public void setCards(String card, int index){
        this.cards[index] = card;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public String getDefinition(){
        return definition;
    }

    public void setDefinition(String definition){
        this.definition = definition;
    }

    //public abstract void writeDefinition();
    public abstract void writeCard();
}
class CardGenerator extends FlashCard{

    Scanner sc = new Scanner(System.in);

    public CardGenerator(int numberOfCard){
        super(numberOfCard);
    }

    @Override
    public void writeCard(){
        for (int i = 1; i < getNumberOfCards(); i++){
            setCardsCounter(i);
            System.out.println(getCardsCounter());
            setCards(sc.nextLine(), i--);
        }
    }

}
public class Main {
    public static void main(String[] args) {

        System.out.println("Input the number of cards:");

        try(Scanner sc = new Scanner(System.in)){
            CardGenerator newCard = new CardGenerator(sc.nextInt());
            newCard.writeCard();
        } catch (InputMismatchException e){
            System.out.println("Incorrect value");
            System.exit(0);
        }
    }
}