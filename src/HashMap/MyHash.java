package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
    //初始化长度为8
    private int size = 8;
    //成员个数
    private int number = 0;
    //哈希数组
    private ArrayList<LinkedList> array_head = new ArrayList<LinkedList>(size);

    //构造方法
    public MyHash(){
        for(int i = 0; i < size; i++){
            //哈希数组中初始化存储空链表头
            LinkedList myList = new LinkedList();
            //初始化时就将空节点添加到数组中
            array_head.add(myList);
        }
    }

    /**
     * @name put
     * @param key 键
     * @param value 值
     * @returns null
     * @description 根据键值对生成节点并放入哈希表中
     */
    public void put(Object key, Object value){
        if(number/size == 10){
            rehash();
        }
        number++;
        //根据参数生成新节点
        Node new_node = new Node(key, value);
        //获取哈希码
        int code = hashCode(key.toString());
        //得到哈希码在哈希列表中所对应的位置
        int position = locate(code);

        //找到该位置对应的链表头
        LinkedList list_head = (LinkedList) array_head.get(position);

        //放入哈希表中
        list_head.add(new_node);

    }

    /**
     * @name get
     * @param key 键
     * @returns Object
     * @description 根据键值取对应节点的value值返回
     */
    public Object get(Object key){
        //得到哈希码
        int code = hashCode(key.toString());
        //得到哈希码对应位置
        int position = locate(code);

        //找到对应链表
        LinkedList list_head = (LinkedList) array_head.get(position);
        //遍历链表，找到对应节点的value值进行输出
        for(int i = 0; i < list_head.size(); i++){
            //获取头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node != null){
                //如果key相等
                if(node.getKey().equals(key)){
                    System.out.println("node.getValue(): " + node.getValue());
                    return node.getNext();
                }
                node = node.getNext();
            }
        }
        return null;
    }


    /**
     * @name remove
     * @param key 键
     * @returns Object
     * @description 根据键值移除对应节点并返回被删除节点的Value
     */
    public Object remove(Object key){
        number--;
        //得到哈希码
        int code = hashCode(key.toString());
        //得到哈希码对应位置
        int position = locate(code);

        //找到对应链表
        LinkedList list_head = (LinkedList) array_head.get(position);
        //遍历链表，找到对应节点的value值进行输出
        for(int i = 0; i < list_head.size(); i++){
            //获取头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node != null){
                //如果key相等
                if(node.getKey().equals(key)){
                    Object value = node.getNext();
                    list_head.remove(node);
                    return value;
                }
                node = node.getNext();
            }
        }
        return null;
    }

    /**
     * @name replace
     * @param key 键
     * @param value 新的值
     * @returns Object
     * @description 根据键值移除对应节点并返回被删除节点的Value
     */
    public Object replace(Object key, Object value){
        System.out.println("replace");
        //得到哈希码
        int code = hashCode(key.toString());
        //得到哈希码对应位置
        int position = locate(code);

        //找到对应链表
        LinkedList list_head = (LinkedList) array_head.get(position);
        //遍历链表，找到对应节点的value值进行输出
        for(int i = 0; i < list_head.size(); i++){
            //获取头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node != null){
                //如果key相等
                if(node.getKey().equals(key)){
                    Object oldValue = node.getNext();
                    node.setValue(value);
                    return oldValue;
                }
                node = node.getNext();
            }
        }
        return null;
    }

    /**
     * @name containsKey
     * @param key 键
     * @returns boolean
     * @description 根据键值对应节点是否存在返回True/false
     */
    public boolean containsKey(Object key){
        //得到哈希码
        int code = hashCode(key.toString());
        //得到哈希码对应位置
        int position = locate(code);

        //找到对应链表
        LinkedList list_head = (LinkedList) array_head.get(position);
        //遍历链表，找到对应节点的value值进行输出
        for(int i = 0; i < list_head.size(); i++){
            //获取头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node != null){
                //如果key相等
                if(node.getKey().equals(key)){
                    return true;
                }
                node = node.getNext();
            }
        }
        //否则返回false
        return false;
    }

    /**
     * @name containsValue
     * @param value 值
     * @returns boolean
     * @description 根据值对应节点是否存在返回True/false
     */
    public boolean containsValue(Object value){
        //遍历所有位置
        for(int k = 0; k < size; k++){

            //得到链表头
            LinkedList list_head = (LinkedList) array_head.get(k);

            //遍历链表，找到对应节点的value值进行输出
            for(int i = 0; i < list_head.size(); i++){
                //获取头节点
                Node head = (Node) list_head.get(i);
                Node node = head;
                while(node != null){
                    //如果key相等
                    if(node.getValue().equals(value)){
                        return true;
                    }
                    node = node.getNext();
                }
            }
        }

        //否则返回false
        return false;
    }

    /**
     * @name show
     * @returns null
     * @description 打印哈希表
     */
    public void show(){
        System.out.println("打印哈希表");

        //遍历所有位置
        for(int k = 0; k < size; k++){
            //得到链表头
            LinkedList list_head = (LinkedList) array_head.get(k);

            //遍历链表，找到对应节点的value值进行输出
            for(int i = 0; i < list_head.size(); i++){
                //获取头节点
                Node head = (Node) list_head.get(i);
                Node node = head;
                while(node != null){
                    System.out.println("节点"+(i+1)+" :("+node.getKey()+":"+node.getValue()+")"+"-->");
                    node = node.getNext();
                }
            }
        }
    }

    /**
     * @name size
     * @returns int
     * @description 返回存储节点的个数
     */
    public int size(){
        return number;
    }

    /**
     * @name clear
     * @returns null
     * @description 清除哈希表中所有元素
     */
    public void clear(){
        for(int i = 0; i < size; i++){
            //得到链表头
            LinkedList list_head = array_head.get(i);
            list_head.clear();
        }
        number = 0;
    }

    /**
     * @name rehash
     * @returns null
     * @description 重新生成哈希表
     */
    private void rehash() {


    }

    /**
     * @name resize
     * @returns null
     * @description 哈希表扩容
     */
    private void resize() {


    }

    /**
     * @name put
     * @param str 字符串
     * @returns int hashcode
     * @description 根据字符串获取hash值(ASCII码值相加)
     */
    private int hashCode(String str) {
        int k = 0;
        for(int i = 0; i < str.length(); i++){
            k += str.charAt(i);//charAt(int index) 返回索引处的字符;
        }
        return k;
    }

    /**
     * @name locate
     * @param k int
     * @returns int location
     * @description 计算哈希码在数组中对应的位置;
     */
    private int locate(int k){
        int l = k%size;
        return l;
    }
}
