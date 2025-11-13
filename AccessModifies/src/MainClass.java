import SecondaryPackage.ThirdClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondClass in=new SecondClass();
		in.print();
		try {
		
		in.show();
		}
		catch(Exception e) {
			System.out.println("Hello");
		}
		ThirdClass td=new ThirdClass();
		td.showing();
	}

}
