package cn.zjajxzg.test.hashmap;

import java.util.HashMap;

/**
 * @author zhigang.xu
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("k1", 0.1);
        System.out.println(map.get("k1"));
        System.out.println("hello java");
    }
}
