package inventory;

/**
 * This interface provides a to-do list of methods that allows a class which implements Inventory to
 * keep count of the number of characters
 *
 * @author Susan Uland
 * @version 1.0
 */
public interface Inventory {
   /**
    * increments the count of the character c in the inventory
    *
    * @param c character to track in inventory
    */
   public void add(char c);

   /**
    * decrements the count of the character c in the inventory
    *
    * @param c character to track in inventory
    */
   public void subtract(char c);


   /**
    * returns a count of the letter in the inventory, zero otherwise
    *
    * @param c character in inventory
    * @return a count of the character in the inventory
    */
   public int get(char c);

   /**
    * updates the count of the character c in the inventory (if count is zero or greater)
    *
    * @param c     character to update in inventory, throws IllegalArgumentException if character not in inventory
    * @param count number to update count with, throws IllegalArgumentException if negative
    */
   public void set(char c, int count);

   /**
    * returns true if character is contained in the inventory
    *
    * @param c character
    * @return true if character in inventory, false otherwise
    */
   public boolean contains(char c);

   /**
    * returns the sum of all counts in the inventory
    *
    * @return the total count
    */
   public int size();

   /**
    * Returns true if this inventory is empty (all counts are 0)
    * @return true if all counts are 0, false otherwise
    */
   public boolean isEmpty();
}
