package test;

import HashMap.MyHash;

public class MyHashTest {
    public static void main(String[] args) {
        MyHash myhash = new MyHash();
        myhash.put("abc", 123);
        myhash.put("b", 2);
        myhash.put("c", 3);
        myhash.put("a", 1);
        myhash.put("d", 4);
        myhash.put("e", 5);
        myhash.put("f", 6);
        myhash.put("g", 7);
        myhash.put("h", 8);
        myhash.put("i", 9);
        myhash.put("j", 10);
        myhash.put("k", 11);
        myhash.put("l", 12);
        myhash.put("m", 13);


        System.out.println("myhash.get(\"g\") :"+myhash.get("g"));
        System.out.println("myhash.size() :"+myhash.size());
        System.out.println("myhash.replace(\"m\", 20)  :"+myhash.replace("m", 20));
        System.out.println("myhash.containsValue(5)  :"+myhash.containsValue(5));
        System.out.println("myhash.containsKey(\"g\")  :"+myhash.containsKey("g"));
        System.out.println("myhash.remove(\"j\")  :"+myhash.remove("j"));
        System.out.println("myhash.show()");
        myhash.show();
        myhash.clear();
        System.out.println("myhash.clear()");
        System.out.println("myhash.size() :"+myhash.size());

    }
}