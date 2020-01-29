import service.*;
import service.searchQueensPositions.BacktrackingWithReturn;
import service.stack.MyStackStructure;
import service.tree.BinaryTree;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) throws IOException {
        BacktrackingWithReturn.backtrack(8);
    }

    private static void hashForStepik() {
        HashStepikService.phoneBook("12 " +
                "add 911 police " +
                "add 76213 Mom " +
                "add 17239 Bob " +
                "find 76213 " +
                "find 910 " +
                "find 911 " +
                "del 910 " +
                "del 911 " +
                "find 911 " +
                "find 76213 " +
                "add 76213 daddy " +
                "find 76213");
    }

    private static void encryptDecrypt() {
        /*
        "This is a test!", 1 -> "hsi  etTi sats!"
        "This is a test!", 2 -> "hsi  etTi sats!" -> "s eT ashi tist!"
         */
        String res1 = EncryptDecryptService.encrypt("This is a test!", 1);
        System.out.println(EncryptDecryptService.decrypt(res1, 1));
    }

    private static String reverseString(String hello) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arrMain = hello.split(" ");
        if (arrMain.length == 0) {
            return hello;
        }
        int counter = 0;
        for (String str: arrMain) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String[] arrTemp = str.split("");
            for (int i = arrTemp.length-1; i >= 0; i--) {
                stringBuilder2.append(arrTemp[i]);
            }
            counter++;
            if (arrMain.length == counter) {
                stringBuilder.append(stringBuilder2);
            } else {
                stringBuilder.append(stringBuilder2).append(" ");
            }
        }
        return String.valueOf(stringBuilder);
    }

    //init 1
    private static void initListCollide() {
        List list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List list2 = Arrays.asList(8,12,13,14,15,16,7,8,19);
        System.out.println(ListCollideService.listCollide(list1, list2));
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
       String str10 = "()[]}";
       String str2 = "(){}]]";
       String str3 = "((({{{[[[]]]}}})))";
       String str4 = "()(({}{{[[[]]]}}{}))()";
       String str5 = "()(({}{{][[]]]}}{}))()";
       String str6 = "([)]";
       System.out.println(BalancedStringService.balancedString(str1));
       System.out.println(BalancedStringService.balancedString(str2));
       System.out.println(BalancedStringService.balancedString(str3));
       System.out.println(BalancedStringService.balancedString(str4));
       System.out.println(BalancedStringService.balancedString(str5));
       System.out.println(BalancedStringService.balancedString(str6));
    }

    private static int numSheeps() {
        Boolean[] arrayOfSheeps = {null,  true,  true,  false,
                true,  true,  true,  true ,
                true,  false, true,  false,
                true,  false, false, null ,
                null,  true,  true,  true ,
                false, false, true,  true };
        int counter = 0;
        if(arrayOfSheeps == null) return 0;
        for (int i = 0; i<arrayOfSheeps.length; i++) {
            if (arrayOfSheeps[i]==null) {
                i++;
            } else {
                if ((arrayOfSheeps[i].equals(true))) {
                    counter++;
                }
            }
        }
        return counter;
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
        System.out.println(TakeMinElementInStackService.minElementInStack(stack));
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
        BinaryTree.checkTheRank(tree, 6);
    }
}

//Boolean array calculation - task from CodeWars
//        System.out.println(numSheeps());

//Reverse String - Task from Codewars
//        System.out.println(reverseString("hello how are you"));

//you are given two lists find the first node at which they collide - 1
//        initListCollide();

//implement a service.stack data structure (only takes int and has a max size) - 2
//        initStackDataStructure();

//if you have a string that contains () {} [] .. check if it's balanced - 3
//        initBalancedString();

//implement a service.stack with get_min o(1) you can use additional space - 4
//        initElementInStack();

//given a binary search service.tree and a number a find the rank of a - 5
//        initCheckTheRank();