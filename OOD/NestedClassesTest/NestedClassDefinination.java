
public class NestedClassDefinination {
	 public int x = 0;
	 class FirstLevel {
		 public int x = 1;
		 void methodInFirstLevel(int x) {
	            System.out.println("x = " + x);
	            System.out.println("this.x = " + this.x);
	            System.out.println("ShadowTest.this.x = " + NestedClassDefinination.this.x);
	        }
	 }
	 
	 public static class innerClass {
		 private int innerX ;
		 public innerClass(int value) {
			 this.innerX = value;
		 }
		 public void print() {
			 System.out.println(innerX);
		 }
	 }
}
