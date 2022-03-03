class Blockchain {
    //a blockchain is a list of blocks.
    val blocks: List<Block>
        get() = _blocks

    private val _blocks = mutableListOf<Block>()

    fun add(block: Block) = _blocks.add(block)

    //check whether the list(blockchain) is valid.
    fun isValid(): Boolean {

        //if the list is empty or has just one element, it is valid.
        if (_blocks.isEmpty() || _blocks.size == 1) return true

        //It is not valid if previous hash value in the block and
        //the hash value of the previous block are not equal to each other.
        for (i in _blocks.size - 1 downTo 1) {
            if (_blocks[i].previousHash != _blocks[i - 1].hash) return false
        }

        return true
    }
}