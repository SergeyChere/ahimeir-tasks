package service;

import java.util.List;

public interface ListCollideService {
    static int listCollide(List list1, List list2) {
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
}
