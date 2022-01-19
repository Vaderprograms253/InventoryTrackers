package inventory;

import java.util.*;
import java.io.*;

/**
 * This class will keep track of counts for the letters a,A,b,B,c,C
 */
public class ABCInventory implements Inventory  {
   // instance fields
   private int aCount;
   private int bCount;
   private int cCount;


   /**
    * default constructor initializes all counts to zero
    * Remember: java will provide this if we do not include in the file
    */
   public ABCInventory() {
      aCount = 0;
      bCount = 0;
      cCount = 0;
   }



   /**
    * increments the count of the character c in the inventory
    *
    * @param c character to track in inventory
    */
   @Override
   public void add(char c) {

      switch (c){
         case 'a':
         case 'A':
            aCount++;
            break;
         case 'b':
         case 'B':
            bCount++;
            break;
         case 'c':
         case 'C':
            cCount++;
            break;
         default:
            System.out.println("cannot add: " + c);
            break;
      }

   }

   /**
    * decrements the count of the character c in the inventory
    *
    * @param c character to track in inventory
    */
   @Override
   public void subtract(char c) {
      switch (c){
         case 'a':
         case 'A':
            if (aCount > 0) {
               aCount--;
            }
            break;
         case 'b':
         case 'B':
            if (bCount > 0) {
               bCount--;
            }
            break;
         case 'c':
         case 'C':
            if (cCount > 0) {
               cCount--;
            }
            break;
         default:
            System.out.println("cannot subtract: " + c);
            break;
      }
   }

   /**
    * returns a count of the letter in the inventory, zero otherwise
    *
    * @param c character in inventory
    * @return a count of the character in the inventory
    */
   @Override
   public int get(char c) {
      c = Character.toLowerCase(c);
      if(c == 'a'){
         return aCount;
      }

      if (c == 'b'){
         return bCount;
      }

      if (c == 'c'){
         return cCount;
      }
      return 0;
   }

   /**
    * updates the count of the character c in the inventory (if count is zero or greater)
    *
    * @param c     character to update in inventory, throws IllegalArgumentException if character not in inventory
    * @param count number to update count with, throws IllegalArgumentException if negative
    */
   @Override
   public void set(char c, int count) {
      char lowerC = Character.toLowerCase(c);
      if (lowerC != 'a' && lowerC != 'b' && lowerC != 'c'){
         throw new IllegalArgumentException(c + " not legal character for inventory");
      }

      //if count is negative throw IllegalArgumentException
      if (count < 0){
         throw new IllegalArgumentException();
      }

      switch (c){
         case 'a':
         case 'A':

               aCount = count;
            break;
         case 'b':
         case 'B':

               bCount = count;
            break;
         case 'c':
         case 'C':

               cCount = count;
            break;
      }

   }

   /**
    * returns true if character is contained in the inventory
    *
    * @param c character
    * @return true if character in inventory, false otherwise
    */
   @Override
   public boolean contains(char c) {
      return  get(c) > 0;
   }

   /**
    * returns the sum of all counts in the inventory
    *
    * @return the total count
    */
   @Override
   public int size() {
      return aCount + bCount + cCount;
   }

   /**
    * Returns true if this inventory is empty (all counts are 0)
    *
    * @return true if all counts are 0, false otherwise
    */
   @Override
   public boolean isEmpty() {
      return this.size() == 0;
   }


   /**
    *
    * @return a string representation of the counts for the letters AaBbCc
    * Example: [A=3, B=4, C=5]
    */
   public String toString() {
      return "[A=" + aCount + ", B=" + bCount + ", C=" + cCount + "]";
   }
}
