package programmers.level2.threepage;

import java.util.*;
import java.lang.*;

public class 파일명정리 {

    public static void main(String[] args) {

        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(files1)));
        System.out.println(Arrays.toString(solution(files2))) ;

    }

    public static String[] solution(String[] files) {
        String[] answer = {};

        // 정렬
        Arrays.sort(files, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2)
            {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);

                int headValue = file1[0].compareTo(file2[0]);

                if(headValue == 0)
                {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;

                }
                else
                {
                    return headValue;
                }

            }

            public String[] detach(String str)
            {
                String head = "";
                String number = "";
                String tail = "";

                int i = 0;
                for( ; i < str.length(); i++)
                {
                    char ch = str.charAt(i);
                    if(ch >= '0' && ch <= '9') break;
                    head += ch;
                }

                for( ; i < str.length(); i++)
                {
                    char ch = str.charAt(i);
                    if(!(ch >= '0' && ch <= '9')) break;
                    number += ch;
                }

                for( ; i < str.length(); i++)
                {
                    char ch = str.charAt(i);
                    tail += ch;
                }

                String[] file = {head.toLowerCase(), number, tail};

                return file;

            }



        });



        return files;
    }

}
