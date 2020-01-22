import stack.MyStackStructure;
import tree.BinaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        //you are given two lists find the first node at which they collide - 1
        initListCollide();

        //implement a stack data structure (only takes int and has a max size) - 2
        initStackDataStructure();

        //if you have a string that contains () {} [] .. check if it's balanced - 3
        initBalancedString();

        //implement a stack with get_min o(1) you can use additional space - 4
        initElementInStack();

        //given a binary search tree and a number a find the rank of a - 5
        initCheckTheRank();
    }

    //init 1
    private static void initListCollide() {
        List list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List list2 = Arrays.asList(8,12,13,14,15,16,7,8,19);
        System.out.println(listCollide(list1, list2));
    }

    //1
    private static int listCollide(List list1, List list2) {
        int res = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    res = (int) list1.get(i);
                    return res;
                }
            }
        }
        return res;
    }

    //init 2
    private static void initStackDataStructure() {
        MyStackStructure myStackStructure = new MyStackStructure();
        myStackStructure.push(2);
        myStackStructure.push(7);
        myStackStructure.push(3);
        myStackStructure.push(16);
        myStackStructure.push(66);
        myStackStructure.push(11);
        myStackStructure.push(200);
        myStackStructure.push(20);
        myStackStructure.push(21);
        myStackStructure.push(22);
        System.out.println(myStackStructure.peek());
        System.out.println(myStackStructure.pop());
        System.out.println(myStackStructure.peek());
    }

    //init 3
    private static void initBalancedString() {
       String str1 = "(){}[]";
       String str2 = "(){}]]";
       System.out.println(balancedString(str1));
       System.out.println(balancedString(str2));
    }

    //3
    private static boolean balancedString(String str) {
        String strEx = "(){}[]";
        String[] arrEx = strEx.split("");
        String[] arr = str.split("");
        int counter = 0;
        for (int i = 0; i<strEx.length(); i++) {
            if (arr[i].equals(arrEx[i])) {
                counter++;
            }
        }
        if (counter == arrEx.length) {
            return true;
        }
        return false;
    }

    //init 4
    private static void initElementInStack() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(1);
        stack.push(9);
        stack.push(8);
        stack.push(2);
        stack.push(4);;
        System.out.println(minElementInStack(stack));
    }

    //4
    private static int minElementInStack(Stack stack) {
        Stack stack2 = new Stack();
        int res = (int) stack.pop();
        while (!stack.isEmpty()) {
            if (res < (int) stack.peek()) {
                stack2.push(stack.pop());
            } else {
                stack2.push(res);
                res = (int) stack.pop();
            }
        }
        stack2.push(res);
        return (int) stack2.peek();
    }

    //init 5
    private static void initCheckTheRank() {
        BinaryTree tree = new BinaryTree();
        tree.add(2);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(4);
        tree.add(4);
        checkTheRank(tree, 6);
    }

    //5
    private static void checkTheRank(BinaryTree tree, int i) {
        tree.nodeRankTree(6);
//        tree.print();
    }
}