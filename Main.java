import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {

        // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
        // 例如输入一个长度为 9 的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
        // 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
        // 如果不存在则输出 0。

        int[] array = {1, 2, 2, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
    public static int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() > (len / 2)) {
                return (Integer) entry.getKey();
            }
        }
        return  0;
    }

    public static void main(String[] args) {
        
        //开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。

        //处理：
        // 1、 记录最多 8 条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录）
        // 对相同的错误记录（净文件名（保留最后 16 位）称和行号完全匹配）只记录一条，错误计数增加；
        // 2、 超过 16 个字符的文件名称，只记录文件的最后有效 16 个字符；
        // 3、 输入的文件可能带路径，记录文件名称不能带路径。

        // 输入描述:
        // 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
        // 输出描述:
        // 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开

        // 示例:
        // 输入
        // E:\V1R2\product\fpgadrive.c   1325
        // 输出
        // fpgadrive.c 1325 1

        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (in.hasNext()) {
            String strs = in.next();
            int line = in.nextInt();
            String[] str = strs.split("\\\\");
            String s = str[str.length - 1];
            // 使错误记录分辨更准确
            if (s.length() > 16) {
                s = s.substring(s.length() - 16);
            }
            String key = s + " " + line;
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        int count = 0;
        for (Map.Entry entry : map.entrySet()) {
            count++;
            if (count > (map.entrySet().size() - 8)) {
                // 输出错误记录的最后八个
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
