import java.util.*;
public class Deck{ 
  Card[] cards = new Card[52];
  ArrayList<Card> deck1 = new ArrayList<Card>(); //player 1
  ArrayList<Card> deck2 = new ArrayList<Card>(); //player 2
  ArrayList<Card> pit = new ArrayList<Card>(); //actual playing place where cards are being put down

  public Deck(){
    int count = 0;
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 13; j++){
          cards[count] = new Card(i, j);
          count++;
      }
    }
  }
    

  public void split(){ //spilts the deck into two hands
    for(int i = 0; i < 26; i++){
      deck1.add(cards[i]);
    }
    //System.out.println(deck1);
    for(int i = 26; i < 52; i++){
      deck2.add(cards[i]);
    }
    //System.out.println(deck2);
  }

 

  public void shuffle2(){
    Card holder = new Card();

    for(int i = 0; i < 52; i++){
      Random random = new Random();
      int newIndex = random.nextInt(0,52);
      holder = cards[newIndex];
      cards[newIndex] = cards[i];
      cards[i] = holder;
    }
  }

  // public void printAllDeck(){
  //   for(int i = 0; i < 52; i++){
  //     tem.out.println(cards[i]);
  //   }
  // }
    
  public String toString(){
      return cards[0].toString();
  }
}