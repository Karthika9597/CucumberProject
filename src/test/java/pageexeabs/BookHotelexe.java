package pageexeabs;



import org.openqa.selenium.By;

import com.adactin.baseClass.BaseClass;

import loginpagelocator.BookHotelloc;
 
public class BookHotelexe extends Selectpageexe {
	public static void first_name()
	{
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.first_name),"karthika");
	}
	public static void last_name() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.last_name),"chandru");
	}
	public static void address() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.address),"123 kovil st");
	}
	public static void cc_num() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.cc_num),"1234567892430113");
	}
	public static void cc_type() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.cc_type),"VISA");
	}
	public static void cc_exp_month() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.cc_exp_month),"NOVEMBER");
	}
	public static void cc_exp_year() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.cc_exp_year),"2030");
	}
	public static void cc_cvv() {
		BaseClass.send_keys(BaseClass.findElementBy(BookHotelexe.cc_cvv),"506");
	}
	public static void book_now() {
		BaseClass.clickbutton(BaseClass.findElementBy(BookHotelexe.book_now));
	}
	
		
	}
	

