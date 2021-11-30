package programmers;


import java.math.BigInteger;
import java.util.*;

public class test {

    public static void main(String[] args) {

        String n = "cab";
        char[] st = n.toCharArray();
        Arrays.sort(st);

        String sorted = new String(st);

        System.out.println(sorted);

        ArrayList<String> anList = new ArrayList<String>();
        anList.add("ab");
        anList.add("cd");

        String[] answer;
        answer = new String[anList.size()];
        anList.toArray(answer);

        System.out.println(Arrays.toString(answer));


    }
}


