package programmers;


import java.math.BigInteger;
import java.lang.*;
import java.util.*;

public class test {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        System.out.println(list);

        Collections.sort(list, (o1, o2) -> o2 - o1);

        System.out.println(list);






    }
}


