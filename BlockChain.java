import java.util.ArrayList;

class BlockChain{
  int difficulty = 0;
  public static ArrayList<Block> chain;

  public BlockChain(int difficulty){
    this.difficulty = difficulty;
    this.chain = new ArrayList<Block>();
    this.chain.add(createGenesisBlock());
    //System.out.println("Genesis Hash: "+ createGenesisBlock().hash);
  }

  public Block createGenesisBlock(){
    System.out.println("Genesis Block Created ");
    return new Block("Genesis Block");
  }

  public Block getLastBlock(){
    return this.chain.get(this.chain.size() - 1);
  }

  public void addBlock(Block newBlock){
      newBlock.previousHash = getLastBlock().hash;
      newBlock.mineBlock(this.difficulty);
      //System.out.println("New Block pre_hash: "+ getLastBlock().hash);
      System.out.println("New Block hash: "+ newBlock.hash);
      this.chain.add(newBlock);
      //System.out.println("BChain size  "+ this.chain.size());
  }

  public Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[this.difficulty]).replace('\0', '0');

		//loop through blockchain to check hashes:
		for(int i=1; i < chain.size(); i++) {
			currentBlock = chain.get(i);
			previousBlock = chain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring(0, this.difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}

}
