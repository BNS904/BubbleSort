import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int length;
        String fName;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bubble Sort!");
        System.out.println("Please insert your desired number list length or enter -1 to input a file name.");
        length = scanner.nextInt();
        if (length == -1) {
            System.out.println("Please enter the name of the file you wish to sort.");
            fName = scanner.next();
            int[] givenArray = readFileToArray(fName);
            bubbleSort(givenArray);
            System.out.println("Please enter the name of the file you wish to store the sorted array.");
            fName = scanner.next();
            writeArrayToFile(givenArray, fName);

        } else {
            System.out.println("Please enter a name for the file you wish to store the array in.");
            fName = scanner.next();
            writeArrayToFile(createRandomArray(length), fName);
        }
    }

    public static int[] createRandomArray(int arrayLength) {
        int [] newArray = new int[arrayLength];
        Random rng = new Random(arrayLength);
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] =rng.nextInt(0, 100);
        }
        return newArray;
    }

    public static void writeArrayToFile(int[] wArray, String fileName) throws IOException {
        FileWriter fWriter = new FileWriter(fileName);
        for (int j : wArray) {
            fWriter.write(j + "\n");
        }
        fWriter.close();

    }

    public static int[] readFileToArray(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            arrayList.add(Integer.parseInt(scanner.nextLine()));
        }
        scanner.close();
        int [] rArray = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            rArray[i] = arrayList.get(i);
        }
        return rArray;
    }

    public static void bubbleSort (int[] sArray) {
        bubbleSort(sArray, 0, sArray.length);
    }

    public static void bubbleSort(int[] sArray, int start, int end) {
        if (end - start <= 1)
            return;
        for(int i = start; i < end - 1; i++) {
            if(sArray[i] > sArray[i + 1]) {
                int j = i + 1;
                int hold = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = hold;
            }

            bubbleSort(sArray, start, end-1);
        }
    }
}