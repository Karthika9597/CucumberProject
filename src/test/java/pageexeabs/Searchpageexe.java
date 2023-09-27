package pageexeabs;

import com.adactin.baseClass.BaseClass;

public class Searchpageexe extends Loginpageexe{
	public static void location()
	{
		BaseClass.send_keys(BaseClass.findElementBy(Searchpageexe.location), "Paris");
	
	}
	public static void hotels() {
		BaseClass.send_keys(BaseClass.findElementBy(Searchpageexe.hotels),"Hotel Cornice");
	}
	public static void room_type() {
		BaseClass.send_keys(BaseClass.findElementBy(Searchpageexe.room_type),"Deluxe");
	}
	public static void room_nos() {
		BaseClass.send_keys(BaseClass.findElementBy(Searchpageexe.room_nos),"2 - Two");
	}
	public static void Submit() {
		BaseClass.clickbutton(BaseClass.findElementBy(Searchpageexe.Submit));
	}
}

