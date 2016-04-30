package testReadingManagement;

import BusinessDelegator.ReadingManagementDelegate;
import entities.StationLine;
import entities.Traveler;

public class testSuggestEbook {

	public static void main(String[] args) {
		Traveler traveler = new Traveler();
		traveler.setName("Houcem");
		Integer duration = 30;
		
		
		System.out.println(ReadingManagementDelegate.doSuggestEbooks(duration, traveler));
	}
}
