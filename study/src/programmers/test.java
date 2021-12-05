package programmers;


import java.math.BigInteger;
import java.lang.*;
import java.util.*;

public class test {

    public static void main(String[] args) {

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);

        map.put("one", arr);

        System.out.println(map.get("one"));

        ArrayList<Integer> arr2 = new ArrayList<>(map.get("one"));
        arr2.add(2);


        map.put("one", arr2);

        System.out.println(map.get("one"));




    }
}


