package cn.zjajxzg.test.collection;

import java.util.*;

/**
 * 在看ArrayList源码时看到了RandomAccess这个接口
 * 通过接口的注解大概了解了这个接口的作用，简单来说就是对List的一种标记
 * 如果实现了RandomAccess则表明这个List支持快速随机访问，即通过for循环来遍历list会比通过迭代器来遍历来的更快
 * 以下是相关测试
 *
 * @author zhigang.xu
 */
public class RandomAccessTest {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add("" + i);
            linkedList.add("" + i);
        }

        RandomAccessTest randomAccessTest = new RandomAccessTest();
        System.out.println("ArrayList:");
        randomAccessTest.traverseListByLoop(arrayList);
        randomAccessTest.traverseListByIterator(arrayList);
        System.out.println("LinkedList:");
        randomAccessTest.traverseListByLoop(linkedList);
        randomAccessTest.traverseListByIterator(linkedList);

    }

    private void traverseList(List list) {
        Iterator iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        // 如果支持快速随机访问  使用for循环遍历
        if (list instanceof RandomAccess) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("RandomAccess: " + (endTime - startTime) + "ms");
        } else {
            while (iterator.hasNext()) {
                iterator.next();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("迭代器: " +(endTime - startTime) + "ms");
        }
    }

    private void traverseListByLoop(List list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for: " + (endTime - startTime) + "ms");
    }

    private void traverseListByIterator(List list) {
        Iterator iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("迭代器: " +(endTime - startTime) + "ms");
    }
}
