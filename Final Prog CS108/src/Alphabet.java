import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Alphabet {
    public static ArrayList<String> alphabetList = new ArrayList<String>();
    public static String[] alphabetArray;
    public static ArrayList<String> message = new ArrayList<String>();
    public static ArrayList<String> temporaryList = new ArrayList<String>();

    /**
     * convert the alphabet file to an ArrayList of letters and numbers.
     * @param filePath
     * @throws IOException
     */
    public static void alphaToList(String filePath) throws IOException {
        FileInputStream inStream = new FileInputStream(filePath);
        Scanner inFS = new Scanner(inStream);

        String stringLine = inFS.nextLine();
        alphabetArray = stringLine.split(" ");

        for (int i = 0; i < alphabetArray.length; i++) {
            temporaryList.add(alphabetArray[i]);
        }

        inStream.close();
    }

    /**
     * sorts the alphabet
     */
    public static void alphaSort() {
        int minIndex = 0;
        String fakeString = "";
        boolean success = true;

        //bubble sort the alphabet
        while(success){
            success = false;

            for (int i = 0; i < alphabetArray.length - 1; i++) {
                if (alphabetArray[i].compareToIgnoreCase(alphabetArray[i + 1]) > 0){
                    fakeString = alphabetArray[i];
                    alphabetArray[i] = alphabetArray[i + 1];
                    alphabetArray[i + 1] = fakeString;

                    success = true;
                }
            }
        }

        //reset temporaryList
        for (int i = 0; i < alphabetArray.length; i++) {
            temporaryList.set(i, alphabetArray[i]);
        }

        //add strings from array to alphabet arrayList
        for (String alphaBit : temporaryList) {
            alphabetList.add(alphaBit);
        }
        alphabetList.add(" ");
    }

    /**
     * use binary search to find the letter in the alphabet
     * @param givenList
     * @param target
     * @return index of letter in the arrayList
     */
    public static int searchAlpha(ArrayList<String> givenList, String target) {
        int lowVal = 0;
        int highVal = givenList.size() - 1;
        int mid = 0;

        while (lowVal <= highVal) {
            mid = lowVal + (highVal - 1) / 2;
            int searching = target.compareToIgnoreCase(givenList.get(mid));

            //check if target matches with mid
            if (searching == 0){
                return mid;
            }

            //If target is greater, look at right side
            if (searching > 0){
                lowVal = mid + 1;
            }

            //if target is smaller, look at left side
            else {
                highVal = mid - 1;
            }
        }

        return -1;
    }
}
