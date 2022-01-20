package drivers;

import java.util.*;
import java.io.*;
import inventory.*;
/**
 * This class creates and populates Inventory objects with data file contents
 */
public class InventoryEngine {

   public static void main(String [] args) {

      LetterInventory inventory = new LetterInventory();
      inventory.add('b');
      //System.out.println(inventory.size());
     // inventory.set('a', 5);
      System.out.println(inventory.get('a'));
      inventory.get('b');
      //ABCInventory inventory = new ABCInventory();
      //testInventory(inventory);

      // populate(inventory,"InventoryTrackers/data/hello.txt");
     // System.out.println("Expected [A=0, B=0, C=0] size=0 "+inventory+" size="+inventory.size());

      //populate(inventory,"InventoryTrackers/data/alphabet.txt");
      //System.out.println("Expected [A=5, B=5, C=5] size=15 "+inventory+" size="+inventory.size());

      //populate(inventory,"data/ipsum.txt");
      //System.out.println("Expected [A=7, B=1, C=4] size=12 "+inventory+" size="+inventory.size());
   }

   /**
    * This method reads a text file and produces an Inventory object based on the file contents
    * @param inventory object used to keep track of various characters
    * @param fileName name of file holding the characters
    */
   public static void populate(Inventory inventory, String fileName) {
      //try-with clause will automatically close the file object
      try(Scanner fileIn = new Scanner(new File(fileName))){
         // while there are lines in the file
         while (fileIn.hasNextLine()){
            //read line as a string
            String line = fileIn.nextLine();
            //parse string into individual chars
            //add to inventory
            for (char c: line.toCharArray()) {
               inventory.add(c);
            }
         }


      } catch (FileNotFoundException obj){
         System.out.println(fileName + " cannot be opened");
      }

   }

   /**
    * This method tests the various methods in the inventory
    * @param inventory object used to keep track of various characters
    */
   public static void testInventory(Inventory inventory) {
      // test add/size method
      inventory.add('a');
      inventory.add('z');
      inventory.add('a');
      inventory.add('B');
      inventory.add('b');
      inventory.add('C');
      System.out.println(inventory + " size:"+inventory.size());

      // test subtract method
      inventory.subtract('a');
      inventory.subtract('b');
      inventory.subtract('c');
      System.out.println(inventory);

      // test get method
      System.out.println("Expected Count of b's: 1   " + inventory.get('b'));

      // test contains method
      System.out.println("Expected Contains c: false " + inventory.contains('c'));
      System.out.println("Expected Contains a: true " + inventory.contains('a'));

      System.out.println("Expected size: 2 " + inventory.size());

      // test set method with letter in inventory
      inventory.set('c', 4);
      inventory.set('a', 4 );
      inventory.set('b', 4);
      System.out.println("Expected [A=4, B=4, C=4] " + inventory);

      // TODO: test set method with letter not in inventory
      try {
         inventory.set('a', -3);
      } catch (IllegalArgumentException e){
         //log error
         System.out.println(e);
         System.out.println("Illegal character set");
      }


      // test isEmpty method
     // System.out.println("Expected isEmpty(): false " + inventory.isEmpty());


   }

}