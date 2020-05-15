import java.io.IOException;
import java.util.ArrayList;

/**
 *  Final Program
 *  create unit tests for each method in the program
 *  CS108-4
 *  5/14/20
 *  @author  Danela Mae Agpaoa
 */

public class UnitTest {
    public static void main(String[] args) throws IOException {
        //test searchAlpha - the binary search
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("this");
        testList.add("is");
        testList.add("a");
        testList.add("test");

        binarySearch(testList, "is");

        //test alphaToList method in Alphabet class
        testListing();

        //test alphaSort - bubble sorting
        sorting();
    }

    /**
     * test searchAlpha method in Alphabet class
     * @param test
     * @param target
     */
    public static void binarySearch(ArrayList<String> test, String target){
        Alphabet binaryTest = new Alphabet();
        int value = binaryTest.searchAlpha(test, target);

        if (value == 1){
            System.out.println("Binary search works!");
        }
        else {
            System.out.println("Binary search failed.");
        }
    }

    /**
     * test alphaToList method in Alphabet class
     */
    public static void testListing() throws IOException {
        Alphabet testingList = new Alphabet();
        testingList.alphaToList("alphabet.txt");

        boolean success = false;
        String expected = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        for (int i = 0; i < Alphabet.alphabetArray.length; i++) {
            if (expected.charAt(i) == Alphabet.alphabetArray[i].charAt(0)) {
                success = true;
            }

        }

        if (success) {
            System.out.println("Listing skills intact!");
        } else {
            System.out.println("You did not list that right.");
        }
    }

    /**
     * test alphaSort method in Alphabet class
     */
    public static void sorting(){
        Alphabet sortTest = new Alphabet();
        sortTest.alphaSort();

        boolean success = false;
        String expected = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        int check = 0;

        for (String stringBit : Alphabet.alphabetList) {
            if (expected.charAt(check) == stringBit.charAt(0)){
                success = true;
            }
            check++;
        }

        if (success){
            System.out.println("Yay, you can bubble sort!");
        }
        else {
            System.out.println("Oh no, you can't bubble sort.");
        }
    }
}
