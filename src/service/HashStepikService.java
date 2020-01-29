package service;

public interface HashStepikService {
    static String phoneBook(String action) {
        String[] arr = action.split(" ");
        int counter = 0;
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i].equals("add")) {
                counter++;
            }
        }
        String res = "";
        String[][] hashmap = new String[counter][2];
        for (int i = 1, j=0; i<arr.length-1; i++) {
                if (arr[i].equals("add")) {
                    hashmap[j][0] = arr[i+1];
                    hashmap[j][1] = arr[i+2];
                    j++;
                    i=i+2;
                    break;
                } else
                if (arr[i].equals("find")) {
                    res = hashmap[i+1][1];
                    i++;
                    break;
                } else
                if (arr[i].equals("del")) {
                    res = hashmap[i+1][0];
                    hashmap[i+1][0] = "";
                    hashmap[i+1][1] = "";
                    i++;
                    break;
                }
            }
        return res;
    }
}
