package sit.int202;

import java.util.HashMap;
import java.util.Map;

public class ProblemTwo {
    public static void main(String[] args) {
        // Sol 1
        Map<Integer, Integer> map = new HashMap<>();
            // Map<key, value> ต้องกำหนดทั้งสองอย่างว่าเป็นชนิดอะไร
            // HashMap<>() ต้องกำหนด (initialCapacity: 16, loadFactor: 0.75f) ไม่กำหนด = ค่า default
        int data[] = {1, 2, 3, 5, 8, 7, 9, 6, 4};
        int x = 6; // ผลลัพธ์บวกกันต้องได้ = 6
        for (int i = 0; i < data.length; i++) {
            int v = data[i];
            int require = x - v;
            if (map.get(require) == null) {
                map.put(v, i);
            } else {
                System.out.println("(" + i + " , " + map.get(require) + ")");
                map.put(v, i);

            }
        }

        // ตรวจสอบดูว่าสามารถใช้งาน method ได้มั้ย
//        int data[] = {1, 2, 3, 5, 8, 7, 9, 6, 4};
//        int x = 6;
//        for (int v : data) {
//            System.out.print(v+ "\t");
//        }
//        System.out.println();

        // Sol 2
//        Map<Integer, Integer> map = new HashMap<>();
//        // Map<key, value> ต้องกำหนดทั้งสองอย่างว่าเป็นชนิดอะไร
//        // HashMap<>() ต้องกำหนด (initialCapacity: 16, loadFactor: 0.75f) ไม่กำหนด = ค่า default
//        int data[] = {1, 2, 3, 5, 8, 7, 9, 6, 4};
//        int x = 6;
//        for (int i = 0; i < data.length; i++) {
//            int key = x - data[i];
//            if (map.get(key) != null) {
//                System.out.println("(" + i + " , " + map.get(key) + ")");
//            }
//            map.put(data[i], i);
//        }
    }
}
