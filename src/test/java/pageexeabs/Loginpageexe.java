package pageexeabs;


import com.adactin.baseClass.BaseClass;

import loginpagelocator.BookHotelloc;
import loginpagelocator.Loginpageloc;

public class Loginpageexe extends BookHotelloc {
	public static void username() 
	{
		BaseClass.send_keys(BaseClass.findElementBy(Loginpageloc.username), "karthikack");
	}
	public static void password() {
		BaseClass.send_keys(BaseClass.findElementBy(Loginpageloc.password), "Java@123");
	}
	public static void login() {
		BaseClass.clickbutton(BaseClass.findElementbyId(Loginpageloc.login));
	}
}
