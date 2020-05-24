import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
        int numberOfQueries = scan.nextInt();
        while(numberOfQueries > 0){
            int operation = scan.nextInt();
            if(operation == 1){
                int temp = scan.nextInt();
                queue.add(temp);
            }
            else if(operation == 2){
                queue.poll();
            }
            else if(operation == 3){
                System.out.println(queue.peek());
            }
            numberOfQueries--;
        }

    }
}