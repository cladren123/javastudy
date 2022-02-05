package programmers.level3.page2;

import java.util.*;

public class 길찾기게임2트 {


    public static void main(String[] args) {

        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] result = solution(nodeinfo);

        for(int i = 0; i < result.length; i++)
            System.out.println(Arrays.toString(result[i]));

    }

    static int[][] result;
    static int index;

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        // 노드 생성
        Node[] nodelist = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++)
        {
            nodelist[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }

        // 노드 정렬 : y 내림차순, y가 같다면 x를 오름차순
        Arrays.sort(nodelist, new Comparator<Node>() {

            @Override
            public int compare(Node n1, Node n2) {
                if(n1.y == n2.y) return n1.x - n2.x;
                return n2.y - n1.y;
            }
        });


        // for(int i = 0; i < nodeinfo.length; i++)
        //     System.out.println(nodelist[i].x);

        // 트리 완성
        Node root = nodelist[0];
        for(int i = 1; i < nodelist.length; i++)
        {
            nodeinsert(root, nodelist[i]);
        }


        result = new int[2][nodeinfo.length];

        // 전위 순회
        index = 0;
        preorder(root);

        // 후위 순회
        index = 0;
        postorder(root);




        return result;
    }


    // 전위 순회 함수
    // Root - Left - Right
    public static void preorder(Node root) {
        if(root != null)
        {
            result[0][index++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    // 후위 순회 함수
    // Left - Right - Root
    public static void postorder(Node root) {
        if(root != null)
        {
            postorder(root.left);
            postorder(root.right);
            result[1][index++] = root.value;
        }
    }

    // 중위 순회 함수 (번외)
    // Left - Root - Right


    // 트리 완성 함수
    // root부터 비교해서 부모와 자식의 x를 비교해 자신의 위치를 찾아가게 한다.
    public static void nodeinsert(Node parent, Node child)
    {
        if(parent.x > child.x)
        {
            if(parent.left == null) parent.left = child;
            else nodeinsert(parent.left, child);
        }

        if(parent.x < child.x)
        {
            if(parent.right == null) parent.right = child;
            else nodeinsert(parent.right, child);
        }
    }

    public static class Node{
        int x;
        int y;
        int value;
        Node left;
        Node right;

        Node(int x, int y, int value, Node left, Node right)
        {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }



}
