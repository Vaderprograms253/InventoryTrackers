package inventory;

import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;

/**
 * This class represents an inventory of the 26 letters in the English alphabet.
 * A LetterInventory object keeps track of how many a’s, how many b’s, etc.
 * are contained in a given string.
 * For example:
 * the letter inventory for the string “Washington State” corresponds to [aaeghinnosstttw].
 * The case of the letter is ignored, so ‘s’ and ‘S’ are exactly the same.
 */
public class LetterInventory implements Inventory {
   // instance field
   private int[] letters; // letters is null here
   //constant for array
   private static final int ALPHABET_SIZE = 26;



   // default constructor - need to provide this constructor
   // so memory is constructed for array (so it is no longer null)
   public LetterInventory() {
      //TODO fix the style issue below
      letters = new int[ALPHABET_SIZE];
   }

   /**
    * increments count of char c in inventory
    *
    * @param c character to track in inventory
    */
   @Override
   public void add(char c) {
      c = Character.toLowerCase(c);
      if (Character.isLetter(c)){
         letters[c -'a']++;
      }
   }

   /**
    * removes a letter from the inventory
    *
    * @param letter to subtract in inventory
    */
   public void subtract(char letter){
      letter = Character.toLowerCase(letter);
      if (Character.isLetter(letter)){
         letters[letter -'a']--;
      }
   }

   @Override
   public int get(char c) {
      c = Character.toLowerCase(c);
      if(Character.isLetter(c)){
      return letters[c - 'a'];
      }
      else {
         return 0;
      }
   }


   public void set(char letter, int count){
      letter = Character.toLowerCase(letter);
      if (Character.isLetter(letter)){
         letters[letter -'a'] = count;
      }
   }

   @Override
   public boolean contains(char c) {
      return get(c) > 0;
   }


   public int size(){
      int totalSize = 0;
      for (int count: letters) {
         totalSize += count;
      }
      return totalSize;
   }

   @Override
   public boolean isEmpty() {
      return this.size() ==0;
   }


   /**
    * Returns a String representation of the inventory with the letters all in lowercase
    * surrounded by square brackets in alphabetical order. The number of occurrences of
    * each letter matches its count in the inventory.
    * For example, an inventory of 4 a’s, 1 b, 1 k and 1 m would be represented as “[aaaabkm]”.
    * @return a bracketed string representation of the letters contained in the inventory
    */
   public String toString() {
      // If you are concatenating many strings together, StringBuilder class
      // is often more efficient(faster)
      StringBuilder toReturn = new StringBuilder("[");

      // for every count in the letters inventory
      for(int i = 0; i < letters.length; i++) {
         // add each character to the string count times
         for(int count = 0; count < letters[i]; count++) {
            // ascii math performed here
            // Example:
            // 'a' + 0 = 'a'
            // 'a' + 1 = 'b'
            // 'a' + 2 = 'c'
            // 'a' + 25 = 'z'
            toReturn.append((char)('a' + i));
         }
      }
      return toReturn.append("]").toString();
   }
}

