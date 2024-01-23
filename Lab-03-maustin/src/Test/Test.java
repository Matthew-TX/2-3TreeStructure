import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void insertTest()  {
        TwoThreeTree t = new TwoThreeTree();
        //Null Test
        t.insert(null);
        Assert.assertEquals("",t.displayInOrder());

        //Positive
        t.insert(5);
        Assert.assertEquals("5,",t.displayInOrder());

        //Negative
        t.insert(-4);
        Assert.assertEquals("-4,5,",t.displayInOrder());
    }

    @org.junit.Test
    public void getMaxTest(){
        TwoThreeTree t = new TwoThreeTree();

        //Null Test
        Integer max = null;
        t.insert(max);
        Assert.assertEquals(max,t.getMax());

        //Negative
        max = -4;
        t.insert(max);
        Assert.assertEquals(max,t.getMax());


        //Positive
        max = 5;
        t.insert(max);
        Assert.assertEquals(max,t.getMax());
    }

    @org.junit.Test
    public void displayInOrder(){
        TwoThreeTree t = new TwoThreeTree();
        //Null, Positive, and Negative
        t.insert(-4);
        t.insert(3);
        t.insert(7);
        t.insert(-3);
        t.insert(10);
        t.insert(12);
        t.insert(-2);
        t.insert(0);
        String actual = t.displayInOrder();
        Assert.assertEquals(actual,"-4,-3,-2,0,3,7,10,12,");
    }

}
