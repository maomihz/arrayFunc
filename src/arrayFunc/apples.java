package arrayFunc;

public class apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,2,3,3,3,3};
		
		String x = arrayFunc.randomString(32, 127, 21);
		System.out.println(x);
		for(int i=0;i<10;i++) {
			System.out.println(arrayFunc.shuffle(x));
		}
	}

}
