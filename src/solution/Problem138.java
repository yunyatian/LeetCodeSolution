package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem138 {
    public static void main(String[] args) {
        Node head = new Node(7);
        Node intermediateNode1 = new Node(13);
        Node intermediateNode2 = new Node(11);
        Node intermediateNode3 = new Node(10);
        Node intermediateNode4 = new Node(1);
        head.next = intermediateNode1;
        head.random = null;
        intermediateNode1.next = intermediateNode2;
        intermediateNode1.random = head;
        intermediateNode2.next = intermediateNode3;
        intermediateNode2.random = intermediateNode4;
        intermediateNode3.next = intermediateNode4;
        intermediateNode3.random = intermediateNode2;
        intermediateNode4 .next = null;
        intermediateNode4.random = head;
        System.out.println(head);
        Node test = copyRandomList(head);
        while (test!=null){
            System.out.print("val:"+test.val+"    ");
            if (test.random != null){
                System.out.print("random:"+test.random.val+"    ");
            }else {
                System.out.print("random:null"+"    ");
            }
            test = test.next;
        }
    }
/**
 * 构造两个map，nodeMap<Integer,Node>用来存储新生Node,headMap<Node,Integer>用来存储旧的Node，其中的Integer都是用来记录该Node的位置
 * 新旧Node拥有相同的位置信息，作为二者之间唯一的联系
 *
 * 两处while，一处for循环，再次嵌套再while内部的流操作大大加大时间复杂度
 * */
    public static Node copyRandomList(Node head) {
        Map<Integer,Node> nodeMap = new HashMap();
        //此处消耗空间复杂度
        Map<Node,Integer> headMap = new HashMap<>();
        int index = 0;
        // 构造substitute是因为后面还需要head的头节点，所以需要一份进行保存
        Node substitute = head;
        /**
         * 无条件将所有的老的Node不考虑next和random属性进行一次重新构建（深度复制）
         * */
        while(substitute != null){
           Node node = new Node(substitute.val);
           //每次新生一个Node节点，就将老的新的存入各自的map中
           nodeMap.put(index,node);
           headMap.put(substitute,index);
           index++;
           substitute = substitute.next;
        }
        /**
         * 为每一个新生的Node构造random属性
         * */
        while (head != null){
            // 获取旧的Node位置信息
            Integer dex = headMap.get(head);
            // 获取旧的当前位置的random的Node信息
            Node finalHead = head.random;
            if (finalHead != null) {
                // 使用流对headMap进行filter操作，获取headMap中的该Node
                Node find = headMap.keySet().stream().filter(node -> node.equals(finalHead)).findFirst().get();
                //通过该Node可以获得位置信息，因为新旧Map的位置信息是一样的，所以就可以知道新的Node的random的位置信息
                nodeMap.get(dex).random = nodeMap.get(headMap.get(find));
            }
            head = head.next;
        }
        /**
         * 对nodeMap里的Node根据位置信息对next进行赋值
         * */
        for (Integer x: nodeMap.keySet()) {
            if (x != nodeMap.size()-1) {
                nodeMap.get(x).next = nodeMap.get(x + 1);
            }
        }

        return nodeMap.get(0);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
