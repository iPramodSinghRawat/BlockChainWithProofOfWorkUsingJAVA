/*
#
# simple BlockChain working with Proof of Work
# idea and logic taken from below link
# https://www.youtube.com/watch?v=HneatE69814
# to understand more follow the link
#
*/

import java.util.ArrayList;

public class BlockChainTesting{
	public static void main(String[] args) {

		Block firstBlock = new Block("first block data");
		Block secondBlock = new Block("second block data");
		Block thirdBlock = new Block("third block data");

		BlockChain blockChain = new BlockChain(2);
		blockChain.addBlock(firstBlock);

		System.out.println("isChainValid ? " + blockChain.isChainValid());

		blockChain.addBlock(secondBlock);

		System.out.println("isChainValid ? " + blockChain.isChainValid());

		blockChain.addBlock(thirdBlock);

		System.out.println("isChainValid ? " + blockChain.isChainValid());

		//testing proof of work
		//blockChain.chain.get(1).data ="change first block data"; // to do(check) this you have to make Block member data public
		//blockChain.chain.get(1).hash = blockChain.chain.get(1).calculateHash();
		//System.out.println("isChainValid ? " + blockChain.isChainValid());

	}
}
