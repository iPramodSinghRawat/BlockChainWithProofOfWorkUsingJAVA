import java.util.Date;

class Block{
  public String previousHash;
  public String hash;
  private String data;
  private int flag = 0;
  private long timeStamp; //as number of milliseconds since 1/1/1970.

  //Block Constructor.
	public Block(String data) {
		this.data = data;
		//this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
    this.hash = calculateHash();
	}

  public String calculateHash() {
  	String calculatedhash = StringUtil.applySha256(
  			previousHash +
  			Long.toString(timeStamp) +
				Integer.toString(flag) +
  			data
  			);
  	return calculatedhash;
  }

  public void mineBlock(int difficulty){
    String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
		while(!hash.substring( 0, difficulty).equals(target)) {
			flag ++;
			hash = calculateHash();
		}
		//System.out.println("Block Mined!!! : " + hash);
  }

}

/*
import hashlib
from time import time

class Block:

    def __init__(self, data):
        self.previous_hash = ''
        self.timestamp = time()
        self.data = data
        self.flag = 0
        self.hash = self.calculate_hash()

    def calculate_hash(self):
        hash_string = self.previous_hash+str(self.timestamp)+self.data+str(self.flag)
        hash_string = hashlib.sha256(hash_string.encode()).hexdigest()
        return hash_string
        #return SHA256(this.index + this.previousHash + this.timestamp + JSON.stringify(this.data) + this.nonce).toString()

    def mine_block(self,difficulty):
        #print (self.hash[:difficulty])
        #print ("0"*(difficulty))

        while (self.hash[:difficulty] != ("0"*(difficulty))):
            self.flag += 1
            self.hash = self.calculate_hash()

        print("BLOCK MINED: ",self.hash)


class BlockChain:
    chain=[]
    difficulty = 0

    def __init__(self):
    #def __init__(self,difficulty):
        self.chain = [self.create_genesis_block()]
        self.difficulty = 2 # can be passed as variable the greater it is the more time it will take to create new block
        #self.difficulty = difficulty

    def create_genesis_block(self):
        return Block("Genesis Block")

    def get_last_block(self):
        return self.chain[len(self.chain) - 1]

    def add_block(self, new_block):
        new_block.previous_hash = self.get_last_block().hash
        new_block.mine_block(self.difficulty)
        #print("New Block pre_hash: ", new_block.previous_hash)
        self.chain.append(new_block)

    def is_chain_valid(self):

        for i in range(1,len(self.chain)):
            current_block = self.chain[i]
            previous_block = self.chain[i - 1]

            if (current_block.hash != current_block.calculate_hash()):
                #print("current block != ")
                return False

            if (current_block.previous_hash != previous_block.hash):
                #print("current block != prehash")
                return False

        return True
*/
