/*
* 节点类Node
* antuor: starcold
*/

package HashMap;

public class Node{
    private Object key;
    private Object value;
    private Node next;

    //空节点
    public Node() {
    }

    //值为key，value的节点
    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    //region Getter && Setter

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    //endregion
}
