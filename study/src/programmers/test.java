package programmers;


import java.math.BigInteger;
import java.lang.*;
import java.util.*;

public class test {

    public static void main(String[] args) {
        int[][] arr1 = new int[3][3];

        int count = 1;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                arr1[i][j] = count++;

        for(int i = 0; i < 3; i++)
            System.out.println(Arrays.toString(arr1[i]));

        System.out.println();

        int[][] rotate = new int[3][3];

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                rotate[i][j] = arr1[3-1-j][i];

        for(int i = 0; i < 3; i++)
            System.out.println(Arrays.toString(rotate[i]));






    }
}


