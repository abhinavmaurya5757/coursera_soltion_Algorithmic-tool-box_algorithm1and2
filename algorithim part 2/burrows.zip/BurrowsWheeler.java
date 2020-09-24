public class BurrowsWheeler
{
	public static final int R = 256;
    public static void encode()
    {
    	String s = BinaryStdIn.readString();
    	//String s = "aaaaaaaaaaaaaaaaaaaaaaaa";
    	System.out.println(s);
    	System.out.println();
    	CircularSuffixArray originalPos = new CircularSuffixArray(s);
    	String ret = "";
    	int orig = 0;
    	for(int i = 0; i < s.length(); i++) {
    		int pos = originalPos.index(i) - 1;
    		if (pos < 0) {
    			pos = s.length() + pos;
    		}
    			
    		ret += s.charAt(pos);
    		if(originalPos.index(i) == 0) { orig = i; }
    	}
    	/*
    	System.out.println(orig);
    	System.out.println(ret);
    	System.out.println(); 
    	*/
    	BinaryStdOut.write(orig);
    	for (int i = 0; i < ret.length(); i++) {
    		BinaryStdOut.write(ret.charAt(i));
    	}
    }

    public static void decode()
    {
    	/*
    	int orig = 3;
    	for (int i = 0; )
    	String last = "ARD!RCAAAABB";
    	*/
    	
    	int orig = BinaryStdIn.readInt();
    	String last = BinaryStdIn.readString();
    	
    	
    	int[] next = new int[last.length()];
    	int[] count = new int[R + 1];
    	for (int i = 0; i < last.length(); i++) {
    		count[last.charAt(i) + 1]++;
    	}
    	for (int i = 1; i < count.length - 1; i++) {
    		count[i + 1] += count[i];
    	}
    	for(int i = 0; i < last.length(); i++) {
    		next[count[last.charAt(i)]++] = i;
    	}
    	String ret = "";
    	
    	int curr = orig;
    	for(int i = 0; i < next.length - 1; i++) {
    		
    		ret += last.charAt(next[curr]);
    		curr = next[curr];
    	}
    	
    	ret += last.charAt(orig);
    	//System.out.println(ret);
    	
    	for(int i = 0; i < ret.length(); i++) {
    		BinaryStdOut.write(ret.charAt(i));
    	} 
    	
    }
    public static void main(String[] args) {
    	if (args[0] == "-") { encode(); }
    	if (args[0] == "+") { decode(); }
    }
   
}