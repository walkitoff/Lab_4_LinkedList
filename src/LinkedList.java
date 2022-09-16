public class LinkedList {
    public Node headNode = null;

    //  note* headNode is just pointing to the address of the last Node.
    public void addHeadNode( int y, int x){  //because  [y][x] matches arrays
        Node newNode = new Node();
        newNode.yPosition = y;
        newNode.xPosition = x;
        newNode.nextNode = this.headNode;

        this.headNode = newNode;
    }

    /**
     * Removes and returns the headNode
     * Purpose: display user's path
     * @return headNode
     */
    public Node removeHeadNode(){
        headNode = headNode.nextNode;

        return headNode;
    }

}
