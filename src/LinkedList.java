public class LinkedList {
    public Node headNode;

    //  if headNode == null create a 'new' Node, instantiate x,y
    //  note* headNode is just pointing to the address of the last Node.
    public void addHeadNode( int y, int x){  //because  [y][x] matches arrays
        Node newNode = new Node();
        newNode.yPosition = y;
        newNode.xPosition = x;
        newNode.nextNode = headNode;

        headNode = newNode;
    }

    public Node removeHeadNode(){
        headNode = headNode.nextNode;

        return headNode;
    }

}
