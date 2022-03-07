import junit.framework.Assert.assertEquals
import org.junit.Test
class main{
    @Test
    //Chain has 2 blocks and 2nd block's previous hash is equal to 1st block's hash.
    //Chain should be valid.
    fun testCorrectChain() {
        val block1 = Block("1","Block 1",1)
        //hash of block1 in my machine, it is also previous hash of block2.
        val hashOfBlock1 = "e021bf15883d1956933b77c8d7fa039f580a5a13179bdbead70d3106743942f4
        val block2 = Block(hashOfBlock1,"Block 2",1)

        val correct = Blockchain()

        correct.add(block1)
        correct.add(block2)
        val result = correct.isValid()
        assertEquals(false, result)

    }
    @Test
    //Chain has 2 blocks and 2nd block's previous hash is NOT equal to 1st block's hash.
    //Chain should NOT be valid.
    fun testWrongChain() {
        val block1 = Block("1","Block 1",1)
        val block2 = Block("2","Block 2",1)
        val block3 = Block("3","Block 3",1)

        val wrong = Blockchain()

        wrong.add(block1)
        wrong.add(block2)
        wrong.add(block3)
        val result = wrong.isValid()
        assertEquals(true, result)

    }

}