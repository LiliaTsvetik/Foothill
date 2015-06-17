import java.util.Scanner;

public class Foothill
{
   static final int MIN_STR_LEN = 10;
   static final int MAX_STR_LEN = 500;  // sanity check
   static final char KEY_CHAR = '#';
   static final char REQUIRED_KEY_LENGTH = 1;
   static final int MIN_START_LEN = 0;
   static final int MAX_START_LEN = 50;
   static Scanner input;
   
   public static void main(String[] args)
   {
      String userString;
      char keyCharacter;
      int startAt = 0;
      
      input = new Scanner(System.in);
      
      // get the string from the user
      keyCharacter = getKeyCharacter();
      userString = getString();
      startAt = getStartAt();
      
      // now do the various string processes
      System.out.println("\nString with '" + keyCharacter + "' masked: ");
      System.out.println( " " + maskCharacter(userString, keyCharacter, startAt) );

      System.out.println( "\n# "  + keyCharacter + "s: "
         + countKey(userString, keyCharacter) );
      
      System.out.println("\nString with '" + keyCharacter + "' removed: ");
      System.out.println( " " + removeCharacter(userString, keyCharacter, startAt));
      
      input.close();
   }
   
  // method definitions:
   public static char getKeyCharacter()
   {
      String theString;

      // get the string from the user
      do
      {
         System.out.print("Please enter a SINGLE character to act as key: ");
         theString = input.nextLine();
      }
      while (theString.length() !=  REQUIRED_KEY_LENGTH);
         
      return theString.charAt(0);
   }
   
   public static String getString()
   {
      String theString;

      // get the string from the user
      do
      {
         System.out.println("Please enter a phrase or sentence "
               + ">= "+ MIN_STR_LEN
               + " and <= " + MAX_STR_LEN + " characters: " );
         theString = input.nextLine();
      }
      while ( theString.length() < MIN_STR_LEN  
            || theString.length() > MAX_STR_LEN );
         
      return theString;
   }
   
   public static int getStartAt()
   {
      String theString;
      int startAt = 0;
      // get the starting position from the user
      do
      {
         System.out.println("Please enter a position at which to start "
               + ">= "+ MIN_START_LEN
               + " and <= " + MAX_START_LEN  );
         theString = input.nextLine();
         startAt = Integer.parseInt(theString);
      }
      while ( startAt < MIN_START_LEN  
            || startAt > MAX_START_LEN );
         
      return startAt;   
   }
   
   public static String maskCharacter(String theString, char keyCharacter, 
         int startAt)
   {
      String resultString;

      // we build up the result starting from ""
      resultString = "";  
      for (int k = 0; k < theString.length(); k++)
      {
         if (k >= startAt)
         {
            if ( theString.charAt(k) == keyCharacter )
              resultString = resultString + KEY_CHAR;
            else
               resultString  = resultString + theString.charAt(k);        
         } 
         else 
            resultString  = resultString + theString.charAt(k);
      }
      return resultString;
   }
   
   public static String removeCharacter(String theString, char keyCharacter, 
         int startAt)
   {
      String resultString;

      resultString = "";
      for (int k = 0; k < theString.length(); k++)
      {
         if (k >= startAt)
         {
            if ( theString.charAt(k) != keyCharacter)
               resultString  = resultString + theString.charAt(k);     
         } 
         else 
            resultString  = resultString + theString.charAt(k);
      }
      return resultString;
   }
   
   public static int countKey(String theString, char keyCharacter)
   {
      int numKeys, k;

      for (k =  numKeys = 0; k < theString.length(); k++)
      {
         if ( theString.charAt(k) == keyCharacter)
            numKeys++;        
      }
      return numKeys;
   }
}


