

public class GameGrid_Test {
    public static void main(String[] args){

//        GameGrid game = new GameGrid();
//        game.run();
        LinkedList testL = new LinkedList();
//        testL.addHeadNode(0,0);
//        testL.addHeadNode(0,1);
//        testL.addHeadNode(0,2);
//        testL.addHeadNode(0,3);

        for(int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                testL.addHeadNode(y, x);
            }
        }

        System.out.println("[" + testL.headNode.yPosition + "][" + testL.headNode.xPosition + "]" );
        testL.removeHeadNode();
        System.out.println("[" + testL.headNode.yPosition + "][" + testL.headNode.xPosition + "]" );
    }
}