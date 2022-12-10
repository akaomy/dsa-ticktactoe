
public class Player {

	private static String name;
	private static int age;
	
	
	//constructor
	public Player(String n, int s) {
		name = n;
		age = s;
	}
	
	public static void setName(String n) {
		name = n;
	}
	
	public static void setAge(int a) {
		age = a;
	}
	
	public static String getName() {
		return name;
	}
	
	public static int getAge() {
		return age;
	}

}
