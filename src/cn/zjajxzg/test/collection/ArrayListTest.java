package cn.zjajxzg.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList test
 *
 * @author zhigang.xu
 */
public class ArrayListTest {

    static class Apple {

        private int count;

        public int getCount() {
            return count;
        }
    }

    static class Orange {

        private int count;

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // Object[] 在不指定泛型的情况下可以添加任意对象  因为所有对象都是继承于Object
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Apple());
        arrayList.add(new Orange());
        // 取到的对象也是Object类型   需要强转
        Apple a = (Apple) arrayList.get(0);
        // 指定泛型之后 添加了其他对象会有编译错误  泛型依然保持了向上转型的特性 也就是Apple的子类可以添加进list
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        // compile error
//        apples.add(new Orange());

        // 向上转型之后只能使用List的方法  无法使用自己的方法
        List list = new ArrayList();
        // 向下转型
        ArrayList arrayList1 = (ArrayList) list;
        arrayList.trimToSize();
        arrayList1.trimToSize();
    }
}
