
public class UserBuilderTest {

	public static void main(String[] args) {
		User user = new User.UserBuilder("abc", "bbb").age(25).build();
		System.out.println(user.toString());
	}

}
