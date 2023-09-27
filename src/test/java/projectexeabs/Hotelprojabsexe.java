package projectexeabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageexeabs.BookHotelexe;

public class Hotelprojabsexe extends BookHotelexe{
	public static void main(String[] args) {
	selectingBrowser("chrome");
	launching(propReader("url"));
	username();
	password(); 
	login();
	location(); 
	hotels();
	room_type();
	room_nos();
	Submit();
	radiobutton_0();
	continues();
	first_name();
	last_name();
	address();
	cc_num();
	cc_type(); 
	cc_exp_month(); 
	cc_exp_year();
	cc_cvv();
	book_now();
	
}

	
}