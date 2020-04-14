package flashcards;

import java.util.Scanner;


abstract class FlashCard{

    private int numberOfCards;
    private String[] cards;
    private String definition;
    private String answer;

    public FlashCard(int numberOfCards){
        this.numberOfCards = numberOfCards;
        this.cards = new String[numberOfCards];
    }

    public void setDefinition(String definition){
        this.definition = ";
    }

    public String getDefinition(){
        return definition;
    }

    public abstract void print();
}

class CardGenerator extends FlashCard{

    FlashCard newCard = new Fla

    @Override
    public void print() {

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of cards:");
    }
}
