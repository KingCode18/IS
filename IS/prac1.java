class Prac1{
static int XorAscii(String str, int len)
{

	int ans = 0;

	for (int i = 0; i < len; i++) {

		ans = (127 ^ ((str.charAt(i))));
	}
	return ans;
}

public static void main(String[] args)
{

	String str = "H";
	int len = str.length();
	System.out.print(" XOR of given is : " +XorAscii(str, len) +"\n");


}
}

