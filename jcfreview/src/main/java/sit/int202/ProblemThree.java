package sit.int202;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemThree {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data.txt");
        Scanner sc = new Scanner(file); // เอาไว้่อ่านไฟล์
        Map<String, List<Integer>> map = new HashMap<>(125); // คำที่เราอ่านมีอยู่ประมาณสักเท่าไหร่
        // Map<String, List<Integer>> map = new TreeMap<>(); ถ้าอยากเรียงลำดับก็เปลี่ยนจาก HashMap เป็น TreeMap
        while (sc.hasNextLine()) {
            String line = sc.nextLine(); // sc.nextLine() : อ่านทีละหนึ่งบรรทัด

            // แยกคำ
            StringTokenizer stk = new StringTokenizer(line, " .,?()"); //เราจะแยกคำด้วย space . , ? ()
            int wordIndex = 0;
            while (stk.hasMoreElements()) {
                String word = stk.nextToken();
                // check ว่าคำนี้อยู่ใน Map หรือยัง
                if (map.get(word) == null) { // ไม่มีคำนี้อยู่ใน Map แสดงว่าพึ่งเจอครั้งแรก
                    map.put(word, new LinkedList<Integer>()); // เอาคำใส่ลงไปแล้วก็สร้าง LinkedList
                }
                map.get(word).add(++wordIndex); // เอาคำมาและก็แสดงว่าคำนี้อยู่ในตำแหน่งไหน
                //System.out.println(word);
            }
        }
        sc.close();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey()+ "("+ entry.getValue().size()+ "):"+ " ");
            for (Integer position : entry.getValue()) {
                System.out.print("@"+ position+ " ");
            }
            System.out.println();
        }
    }
}
