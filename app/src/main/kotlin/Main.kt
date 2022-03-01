

fun main(args: Array<String>) {

    val chain = Blockchain()

    val block1 = Block("1","Block 1",1)
    //hash of block1 in my machine, it is also previous hash of block2.
    val hashOfBlock1 = "e021bf15883d1956933b77c8d7fa039f580a5a13179bdbead70d3106743942f4"
    val block2 = Block(hashOfBlock1,"Block 2",1)

    chain.add(block1)
    println(chain.isValid()) //has just 1 element, returns true

    chain.add(block2)
    println(chain.isValid()) //hash of block1 and previous hash of block2 are equal, returns true

    val block3 = Block("randomString","Block 3",1)
    chain.add(block3)

    println(chain.isValid()) //hash of block2 and previous hash of block3 are not equal, returns false.

    printBlockChain(chain)


}

fun printBlockChain(_chain: Blockchain) {
    var i = 1
    val _blocks = _chain.blocks
    for(_block in _blocks) {
        println(i.toString()+" - Previous Hash: "+_block.previousHash+" Hash: "+_block.hash)
        println("Data: "+_block.data+" Nonce: "+_block.nonce)
        i++
    }
}
