package service;

import java.util.ArrayList;
import java.util.Arrays;

public class BacktrackingWithReturn {
    static ArrayList<ArrayList<Integer>> list = new ArrayList();
    static int counter = 0;
    static boolean flagNoAnswer = false;
    static ArrayList<Integer> skipAnswer = new ArrayList<>();

    public static void backtrack(int queens) {
        if (!flagNoAnswer) {
            if (list.isEmpty()) {
                if (counter<queens) {
                    if (!skipAnswer.isEmpty()) {
                        skipAnswer = new ArrayList<>();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(1);
                    counter++;
                    arrayList.add(counter);
                    list.add(arrayList);
                    backtrack(queens);
                }
            } else {
                if (list.size()==queens) {
                    answerMethod(list);
                    list = new ArrayList<>();
                    if (!skipAnswer.isEmpty()) {
                        skipAnswer=new ArrayList<>();
                    }
                    backtrack(queens);
                } else
                if (list.size()==1 && skipAnswer.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((list.get(0).get(0)) + 1);
                    for (int i = 1; i <= queens; i++) {
                        arrayList.add(i);
                        if (checkingAvailabilityOfTwoArrayLists(list.get(0), arrayList)) {
                            list.add(arrayList);
                            break;
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                    System.out.println(Arrays.deepToString(list.toArray()));
                    if (counter!=queens && list.size()!=1) {
                        backtrack(queens);
                    } else
                        //made for board 2x2
                    if (counter==queens && list.size()==1) {
                        System.out.println("There're no answer");
                    } else
                    if (counter!=queens && list.size()==1) {
                        list = new ArrayList<>();
                        backtrack(queens);
                    }
                } else
                if (skipAnswer.isEmpty()) {
                    int listCounterTemp = list.size();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(list.get(list.size()-1).get(0)+1);
                    for (int i=1; i <=queens; i++) {
                        int counterTemp = 0;
                        arrayList.add(i);
                        for (int j = 0; j<list.size(); j++) {
                            if (checkingAvailabilityOfTwoArrayLists(list.get(j), arrayList)) {
                                counterTemp++;
                                if (counterTemp==list.size()) {
                                    list.add(arrayList);
                                    break;
                                }
                            }
                        }
                        if (listCounterTemp<list.size()) {
                            break;
                        }
                    }
                    if (!skipAnswer.isEmpty()) {
                        skipAnswer=new ArrayList<>();
                    }
                    if (listCounterTemp==list.size()) {
                        if (list.get(list.size()-1).get(1)!=queens) {
                            skipAnswer.add(list.get(list.size()-1).get(0));
                            skipAnswer.add(list.get(list.size()-1).get(1));
                            list.remove(list.size()-1);
                            backtrack(queens);
                        } else {
                            list=new ArrayList<>();
                            backtrack(queens);
                        }
                    } else
                    if (listCounterTemp!=list.size()) {
                        backtrack(queens);
                    }
                } else
                if (!skipAnswer.isEmpty() && !list.isEmpty() && counter<queens && counter>0) {
                    int listCounterTemp = list.size();
                    for (int i = 0; i <queens; i++) {
                        int counterTemp = 0;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(list.get(list.size() - 1).get(0) + 1);
                        arrayList.add(i + 1);
                        for (int j = 0; j < list.size(); j++) {
                            if (arrayList.get(1)!=skipAnswer.get(1)) {
                                if (checkingAvailabilityOfTwoArrayLists(list.get(j), arrayList)) {
                                    counterTemp++;
                                    if (counterTemp==list.size()) {
                                        list.add(arrayList);
                                        break;
                                    }
                                }
                            }
                        }
                        if (listCounterTemp!=list.size()) {
                            break;
                        }
                    }
                    if (listCounterTemp==list.size()) {
                        if (!skipAnswer.isEmpty()) {
                            skipAnswer=new ArrayList<>();
                        }
                        skipAnswer.add(list.get(list.size()-1).get(0));
                        skipAnswer.add(list.get(list.size()-1).get(1));
                        list.remove(list.size()-1);
                        if (!list.isEmpty()) {
                            backtrack(queens);
                        } else {
                            skipAnswer=new ArrayList<>();
                            list=new ArrayList<>();
                        }
                    } else
                    if (listCounterTemp!=list.size()) {
                        if (!skipAnswer.isEmpty()) {
                            skipAnswer = new ArrayList<>();
                        }
                        backtrack(queens);
                    }
                }
            }
        }
    }

    private static void answerMethod(ArrayList<ArrayList<Integer>> list) {
        System.out.println(Arrays.deepToString(list.toArray()));
    }

    static boolean checkingAvailabilityOfTwoArrayLists(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Integer one = arr2.get(0) - arr1.get(0);
        Integer two = arr2.get(1) - arr1.get(1);
        if (two < 0) two = two * -1;
        if (arr1.get(0) == arr2.get(0)) return false;
        if (arr1.get(0).equals(arr2.get(0))) return false;
        if (arr1.get(1).equals(arr2.get(1))) return false;
        if (one == two) return false;
        else return true;
    }
}
