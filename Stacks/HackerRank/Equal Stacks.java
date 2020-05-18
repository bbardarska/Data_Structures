import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.Stack;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        Stack<Integer> firstStack =new Stack();
        Stack<Integer> secondStack =new Stack();
        Stack<Integer> thirdStack =new Stack();
        int totalHeight1=0,totalHeight2=0,totalHeight3=0;
        for(int i=h1.length-1;i>=0;i--){
            firstStack.push(h1[i]);
            totalHeight1+=h1[i];
        }
        for(int i=h2.length-1;i>=0;i--){
            secondStack.push(h2[i]);
            totalHeight2+=h2[i];
        }
        for(int i=h3.length-1;i>=0;i--){
            thirdStack.push(h3[i]);
            totalHeight3+=h3[i];
        }
        while(!(totalHeight1==totalHeight2&&totalHeight2==totalHeight3&&totalHeight3==totalHeight1)){
            if(totalHeight1==0||totalHeight2==0||totalHeight3==0){
                totalHeight1=0;
                break;
            }else if(totalHeight1>=totalHeight2&&totalHeight1>=totalHeight3){
                totalHeight1-=firstStack.peek();
                firstStack.pop();
            }else if(totalHeight2>=totalHeight1&&totalHeight2>=totalHeight3){
                totalHeight2-=secondStack.peek();
                secondStack.pop();
            }else if(totalHeight3>=totalHeight1&&totalHeight3>=totalHeight2){
                totalHeight3-=thirdStack.peek();
                thirdStack.pop();
            }
        }
        return totalHeight1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
