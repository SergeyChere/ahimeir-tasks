package service.searchQueensPositions;

import java.util.ArrayList;
import java.util.Arrays;

public class BacktrackingWithReturn {
    
    static ArrayList<ArrayList<Integer>> list = new ArrayList();
    static int counter = 0;
    static boolean endOfIteration = true;
    static ArrayList<ArrayList<Integer>> skipAnswer = new ArrayList<>();

    public static void backtrack(int queens) {
        if (endOfIteration) {
            if (list.isEmpty()) {
                if (counter<queens) {
                    firstColumnIterator();
                    backtrack(queens);
                }  else {
                    endOfIteration=false;
                }
            } else {
                if (list.size()==queens) {
                    answerMethod(list, queens);
                    backBoardIterator(queens);
                    backtrack(queens);
                } else
                if (list.size()==1 && skipAnswer.isEmpty()) {
                    boardIterator(queens, list.size());
                    if (counter==queens && list.size()==1) { //made for board 2x2
                        System.out.println("There're no answer");
                        endOfIteration=false;
                    } else {
                        backtrack(queens);
                    }
                } else {
                    int listCounterTemp = list.size();
                    boardIterator(queens, listCounterTemp);
                    if (listCounterTemp==list.size()) {
                        backBoardIterator(queens);
                        backtrack(queens);
                    } else {
                        backtrack(queens);
                    }
                }
            }
        }
    }

    private static boolean backBoardIterator(int queens) {
        boolean returnFlag = false;
        if (list.size()==queens) {
            if (list.size()!=1) {
                list.remove(list.size()-1);
                skipAnswer=new ArrayList<>();
                skipAnswer.add(list.get(list.size()-1));
                list.remove(list.size()-1);
                returnFlag=true;
            } else {
                endOfIteration=false;
            }
        } else
        if (list.get(list.size()-1).get(1)==queens) {
            list.remove(list.size()-1);
            skipAnswer=new ArrayList<>();
            skipAnswer.add(list.get(list.size()-1));
            list.remove(list.size()-1);
            returnFlag=true;
        } else
        if (skipAnswer.isEmpty()) {
            skipAnswer.add(list.get(list.size()-1));
            list.remove(list.size()-1);
            returnFlag=true;
        } else {
        if (list.get(list.size()-1).get(0)!=1) {
                skipAnswer=new ArrayList<>();
                skipAnswer.add(list.get(list.size()-1));
                list.remove(list.size()-1);
                returnFlag=true;
            } else {
                list=new ArrayList<>();
                returnFlag=true;
            }
        }
        return returnFlag;
    }

    private static void boardIterator(int queens, int listCounterTemp) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(list.get(list.size()-1).get(0)+1);
        for (int i=1; i<=queens; i++) {
            int counterTemp = 0;
            if (arrayList.size()==2) {
                arrayList.remove(arrayList.size()-1);
            }
            arrayList.add(i);
            for (int j = 0; j<list.size(); j++) {
                if (skipAnswer.isEmpty() || skipedWrongVariant(arrayList)) {
                    if (checkingAvailabilityOfTwoArrayLists(list.get(j), arrayList)) {
                        counterTemp++;
                        if (counterTemp==list.size()) {
                            list.add(arrayList);
                            break;
                        }
                    }
                }
            }
            if (listCounterTemp<list.size()) {
                break;
            }
        }
    }

    private static boolean skipedWrongVariant(ArrayList arrayList) {
        boolean flag = true;
        if (skipAnswer.size()==1) {
            flag = skipAnswer.get(0)==arrayList.get(0) && skipAnswer.get(1)==arrayList.get(1);
        } else {
            for (int i=0; i<skipAnswer.size()-1; i++) {
                if (skipAnswer.get(i).get(0)==arrayList.get(0) && skipAnswer.get(i).get(1)==arrayList.get(1)) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private static void firstColumnIterator() {
        if (!skipAnswer.isEmpty()) {
            skipAnswer = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        counter++;
        arrayList.add(counter);
        list.add(arrayList);
    }

    private static void answerMethod(ArrayList<ArrayList<Integer>> list, int queens) {
        System.out.println("RESULT: "+Arrays.deepToString(list.toArray()));
        if (counter<queens && !skipAnswer.isEmpty()) {
            if (skipAnswer.get(0).get(1)!=queens) {
                list = new ArrayList<>();
            }
        } else {
            endOfIteration =false;
        }
        if (!skipAnswer.isEmpty()) {
            skipAnswer=new ArrayList<>();
        }
    }

    private static boolean checkingAvailabilityOfTwoArrayLists(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
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