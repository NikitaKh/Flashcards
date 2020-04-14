package flashcards;

import java.util.Scanner;


abstract class FlashCard{

    protected int numberOfCards;
    protected String[] cards;
    protected String definition;

    protected FlashCard(int numberOfCards){
        this.numberOfCards = numberOfCards;
        this.cards = new String[numberOfCards];
    }

    public abstract void print();
}

class CardGenerator extends FlashCard{


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of cards:");
    }
}
