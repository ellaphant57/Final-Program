import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Final Program
 *  shift the user's message by the indicated shiftNum, based on user input.
 *  CS108-4
 *  5/14/20
 *  @author  Danela Mae Agpaoa
 */

public class CaesarShift{
    static Scanner scnr = new Scanner(System.in);
    public static String messagePart = "";
    public static int shiftNum = 0;
    public static Queue<String> queue = new LinkedList<String>();

    /**
     * Ask user for shiftNum and use input to encode their message.
     * @throws IOException
     */
    public CaesarShift() throws IOException {
        System.out.println("How much do you want to shift by?");
        shiftNum = scnr.nextInt();

        Alphabet.alphaToList("alphabet.txt");
        Alphabet.alphaSort();
        //encrypt the message
        encodeCipher();
        //print elements from queue
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }
        System.out.println("");
        System.out.println("Have fun with that! Bye!");
    }

    /**
     * encode the user's message input based on the number of shifts the user wants.
     */
    public static void encodeCipher() {
        String messageBit = "";
        char charBit;
        String charString;
        String newStringBit = "";
        int searchSuccess = 0;

        System.out.println("What message do you want to encode? (Type 'exit' then enter when you are done.)");

        //get message from user
        messagePart = scnr.next();
        while (!messagePart.equalsIgnoreCase("exit")) {


            Alphabet.message.add(messagePart);
            Alphabet.message.add(" ");
            messagePart = scnr.next();
        }

        System.out.println("Okay. Let me encode that for you...");
        System.out.println("Here's your new message:");
        System.out.println("");

        //take each word from the message
        for (int i = 0; i < Alphabet.message.size(); i++) {
            messageBit = Alphabet.message.get(i);

            //get each char from the word
            for (int j = 0; j < messageBit.length(); j++) {
                charBit = messageBit.charAt(j);
                charString = Character.toString(charBit);
                newStringBit = charString;
                searchSuccess = Alphabet.searchAlpha(Alphabet.alphabetList, newStringBit);
//
                if (searchSuccess == -1) {
                    System.out.println("Sorry, that letter doesn't exist.");
                } else {
                    //make sure alphabet restarts if shiftNum goes past Z
                    newStringBit = Alphabet.alphabetList.get((searchSuccess + shiftNum) % Alphabet.alphabetList.size());

                    queue.add(newStringBit);
                }
            }
        }
    }
}
