import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
  public static Deck d = new Deck();
  public static ArrayList<Card> hand = new ArrayList<Card>(); 
  public static Scanner sc = new Scanner(System.in);
  public static long startTime = System.currentTimeMillis();
  
  
  public static void main(String[] args)
  {
    System.out.println("-----" + " " + "Welcome to Slap Jack! Brought to You By Trinity and Dylan :D" + " " + "-----");
    d.shuffle2(); // shuffle deck 
    d.split(); // split deck into two seperate decks
    boolean game = true;
    while(game){
      System.out.println("LET THE GAME BEGIN!");
      play();
    }
  }
  
  public static void del(){
    startTime = System.currentTimeMillis();
    boolean t = true;
    while(t){
      long curr = System.currentTimeMillis();
      if((curr/1000)-2 >= (startTime/1000)){
        t = false;
      }
    }
  }
  //if slapped = 
  //if

  public static void computer(){
    for(int i = 0; i < d.deck2.size() - 1; i++){
      d.pit.add(d.deck2.get(i));
      d.deck2.remove(i);
      System.out.println("The pit: " + d.pit);
      System.out.println("'slap?' or 'nah'");
      String playerInput = sc.nextLine();
      if(d.pit.get(d.pit.size() - 1).toString().contains("J")){
        del();
        slap2();
        // System.out.println("slap or nah?");
        // String playerInput = sc.nextLine();
      }
    }
  }
  
  public static void check2(){
    if(d.pit.get(d.pit.size() - 1).toString().contains("J")){ //!
      // del();
      slap2();
    }
    if(d.pit.get(d.pit.size() - 1).toString().contains("23456789TQK")){
      d.pit.add(d.deck2.get(d.deck2.size() - 1));
      d.deck2.remove(0);
    }
    else if(d.deck1.size() == 0){ //when our deck runs out, player 2 wins
      System.out.println("Player 2 is the winner.");
    }
    else if(d.deck2.size() == 0){ // vice versa
      System.out.println("Player 1 is winnaer!");
    }
  }
  
  public static void check(){
      //System.out.println(d.pit);
      if(d.pit.get(d.pit.size() - 1).toString().contains("J")){ // if a jack is placed, opportunity to slap
        slap();
      }
      if(d.pit.get(d.pit.size() - 1).toString().contains("23456789TQK")){ // anything else is just 
        d.pit.add(d.deck2.get(d.deck2.size() - 1));
        d.deck2.remove(0);
      }
      else if(d.deck1.size() == 0){ //when our deck runs out, player 2 wins
        System.out.println("Player 2 is the winner.");
      }
      else if(d.deck2.size() == 0){ // vice versa
        System.out.println("Player 1 is winnaer!");
      }
  }
    
    public static void play(){ //main game
      for(int i = 0; i < d.deck1.size() - 1; i++){
      if(i % 2 == 0){
        d.pit.add(d.deck1.get(i));
        d.deck1.remove(i);
        System.out.println("The pit: " + d.pit);
        System.out.println("'slap?' or 'nah'");
        String playerInput = sc.nextLine(); //
        check();
      }
      else{
        computer();
      }
    }
  }
    public static void slap2(){
      d.deck2.addAll(d.pit);
      if(d.pit.get(d.pit.size() - 1).equals(d.deck2.get(d.deck2.size() - 1))){
        d.pit.removeAll(d.pit);
        System.out.println("The computer has collected the cards.");
        System.out.println(d.deck1);
        System.out.println(d.deck2);
        System.out.println("New Round");
        play();
      }
    }

  
    public static void slap(){ //checks if card has a Jack, if does, all cards in pit will be transferred into deck1, if not, deck1 and deck2 keeps on interchanging on putting cards down
      d.deck1.addAll(d.pit);
      if(d.pit.get(d.pit.size() - 1).equals(d.deck1.get(d.deck1.size() - 1))){
        d.pit.removeAll(d.pit);
        System.out.println("You have collected the cards in the pit.");
        System.out.println(d.deck1);
        System.out.println(d.deck2);
        System.out.println("New Round");
        play();
      }
      // if(d.pit.get(d.pit.size() - 1).equals(d.deck2.size() - 1)){
      //   d.deck2.addAll(d.pit);
      //   d.pit.removeAll(d.pit);
      //   System.out.println("The computer has collected the card.");
      //   System.out.println(d.deck1);
      //   System.out.println(d.deck2);
      //   System.out.println("New Round");
      //   play();
      // }
    }
}