package programmers.level3.page2;

import java.util.*;

public class 길찾기게임3트 {

    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] result = solution(nodeinfo);

        for(int i = 0; i < result.length; i++)
            System.out.println(Arrays.toString(result[i]));
    }

    static int index;
    static int[][] answer;

    public static int[][] solution(int[][] nodeinfo) {

        node[] nodelist = new node[nodeinfo.length];


        // 노드 생성
        for(int i = 0; i < nodeinfo.length; i++)
        {
            nodelist[i] = new node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }


        // 정렬
        // y 오름차순
        // y 가 동일할 떄 x 내림차순
        Arrays.sort(nodelist, new Comparator<node> () {

            @Override
            public int compare(node n1, node n2)
            {
                if(n1.y == n2.y) return n1.x - n2.x;
                else return n2.y - n1.y;
            }

        });


        // 트리 완성하기
        node root = nodelist[0];

        for(int i = 1; i < nodelist.length; i++)
        {
            nodeinsert(root, nodelist[i]);
        }

        // 순회 탐색
        answer = new int[2][nodeinfo.length];

        // 전위 순회   Root - Left - Right
        index = 0;
        preorder(root);

        // 후위 순회  Left - Right - Root
        index = 0;
        postorder(root);


        return answer;

    }

    // 전위 순회  Root - Left - Right
    public static void preorder(node root)
    {
        if(root != null) {
            answer[0][index++] = root.index;
            preorder(root.left);
            preorder(root.right);
        }
    }


    // 후위 순회  Left - Right - Root
    public static void postorder(node root)
    {
        if(root != null)
        {
            postorder(root.left);
            postorder(root.right);
            answer[1][index++] = root.index;
        }
    }



    // 노드를 제자리에 위치시키는 함수
    public static void nodeinsert(node parent, node child)
    {
        if(parent.x > child.x)
        {
            if(parent.left == null) parent.left = child;
            else nodeinsert(parent.left, child);
        }
        else if(parent.x < child.x)
        {
            if(parent.right == null) parent.right = child;
            else nodeinsert(parent.right, child);
        }
    }


    static class node
    {
        int x;
        int y;
        int index;
        node left;
        node right;

        node(int x, int y, int index, node left, node right)
        {
            this.x = x;
            this.y = y;
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }



}
