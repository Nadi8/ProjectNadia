package utilities;

import pageClass.HomePage;
import pageClass.ResultsPage;

public class PageInitializer extends Driver {

	public static HomePage hp;
	public static ResultsPage rp;
	
	public static void initialize() {
		hp = new HomePage();
		rp = new ResultsPage();
		
	}
}
