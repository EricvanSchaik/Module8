package pp.s1721380.q1_4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Eric on 25-5-2017.
 */
public class MyTreeListenerTest {
    private MyTreeListener treelistener;

    @Before
    public void setTreeListener() {this.treelistener = new MyTreeListener();}

    @Test
    public void test(){
        Assert.assertEquals(false, treelistener.isOrdered("((1 < 5) < 3 > 2)"));
        Assert.assertEquals(false, treelistener.isOrdered("((1 < 5) < 3 > 6)"));
        Assert.assertEquals(false, treelistener.isOrdered("(1 < 3 > (2 > 6))"));
        Assert.assertEquals(false, treelistener.isOrdered("((2 < 1) < 3 > 6)"));
        Assert.assertEquals(true, treelistener.isOrdered("((1 < 3) < 5 > ((6 < 8) < 10 > 15))"));
        Assert.assertEquals(true, treelistener.isOrdered("3"));
        Assert.assertEquals(true, treelistener.isOrdered("(1 < 3 > 5)"));

    }
}