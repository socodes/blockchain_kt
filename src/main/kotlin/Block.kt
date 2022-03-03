import java.math.BigInteger
import java.security.MessageDigest

class Block( //constructor
    val previousHash: String, //a hash of previous block.
    val data: String, //list of transactions; for simplifying, a string.
    var nonce: Long //proof that the work spent on each block mining has been completed.
    /*
    The "nonce" in a bitcoin block is a 32-bit (4-byte) field whose value is
    adjusted by miners so that the hash of the block will be less than or
    equal to the current target of the network.
     */
) {
    /*
    A cryptographic hash function (CHF) is a mathematical algorithm
    that maps data of an arbitrary size (often called the "message")
    to a bit array of a fixed size
    */
    val hash: String
        get() {
            //SHA-256 is hash calculating cryptographic algorithm.
            val hash = MessageDigest.getInstance("SHA-256")
            hash.update("$previousHash$data$nonce".toByteArray())
            return String.format("%064x", BigInteger(1, hash.digest()))
        }

    companion object {
        //mine function provides the ability to mine a block.
        //select a valid nonce value for a certain difficulty value.
        fun mine(previousHash: String, data: String, difficulty: Int): Block {
            val targetPrefix = "0".repeat(difficulty)
            val block = Block(previousHash, data, 0)
            while (!block.hash.startsWith(targetPrefix)) block.nonce++
            return block
        }
    }
}