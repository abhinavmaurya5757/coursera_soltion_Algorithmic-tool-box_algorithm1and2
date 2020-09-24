import java.util.ArrayList;
import java.util.HashMap;

public class MoveToFront
{
	public static final int R = 256;
	
    public static void encode()
    {
    	int[] pos = new int[R];
    	int[] ch = new int[R];
    	for (int i = 0; i < R; i++) {
    		ch[i] = i;
    		pos[i] = i;
    	}
    	
    	while(!BinaryStdIn.isEmpty()) {
	    	char curr = BinaryStdIn.readChar();
	        BinaryStdOut.write((char) pos[curr]); 
    		
    	
    				
    		for (int j = pos[curr]; j > 0; j--) {
    			pos[ch[j - 1]]++;
    			ch[j] = ch[j - 1];
    			
    		}
    		
    		ch[0] = curr;
    		pos[curr] = 0;
    	}
    }
    	
    		 
    	
    	
    			
    	
    	
	    	
	    	
    
    
    public static void decode()
    {

    	
    	ArrayList<Character> ascii = new ArrayList<Character>(R);
    	for (int i = 0; i < R; i++) {
    		ascii.add((char) (255 - i));
    	}
    
    	while(!BinaryStdIn.isEmpty()) {
	    	int curr = BinaryStdIn.readChar();
    		
    		
	    	char c = ascii.remove(255 - curr);
	    	BinaryStdOut.write(c);
	    	
	    	
	    
	    	
	    	ascii.add(c);
	    	
	    	
    	}
    }
    public static void main(String[] args) {
    	encode();
    }
}