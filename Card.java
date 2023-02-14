public class Card {
  public static String values = "23456789TJQKA";
  public static String suits = "CDHS";
  private char suit;
  private char val;
  
    
  public Card(){
    int index = randomInt(0,13);
    val = values.charAt(index);
    index = randomInt(0,4);
    suit = suits.charAt(index);
    }

   public Card(int s, int v){
      val = values.charAt(v);
      suit = suits.charAt(s);
   }
  
  public String toString(){
      String br = "" + val + suit;
      return br;
  }
    
  public int randomInt(int lower, int higher){
      return(int)(Math.random()*(higher-lower))+lower;
  }
}