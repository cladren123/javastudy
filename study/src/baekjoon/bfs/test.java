package baekjoon.bfs;

import java.util.*;
import java.lang.*;
import java.io.*;


public class test {

    public static void main(String[] args) throws IOException{

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.offer(2);
        q.offer(3);


        Iterator iter = q.iterator();

        while(iter.hasNext())
            System.out.print(iter.next() + " ");



    }

}
