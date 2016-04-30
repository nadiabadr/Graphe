package utilities;

import testsStationLineManagement.TestAssignStationToLine;
import BusinessDelegator.LineServicesDelegate;
import BusinessDelegator.MeansOfTransportDelegate;
import BusinessDelegator.ReadingManagementDelegate;
import BusinessDelegator.StationDelegate;
import BusinessDelegator.UserServicesDelegate;
import entities.Category;
import entities.ContentManager;
import entities.Ebook;
import entities.Line;
import entities.MeanOfTransport;
import entities.Station;
import entities.Traveler;
import entities.Type;

public class populateDB {
	public static void main(String[] args) {
		// ///////////Populating library
		Ebook ebook = new Ebook("Twilight", "Stephanie Meyer",
				"Bella est amoureuse et certaine.", Category.Fiction,
				Type.Livre, " Edward i7ab Bella , Bella ta3mel fiHom ");
		System.out.println(ReadingManagementDelegate.doAddEbook(ebook));

		Ebook ebook2 = new Ebook("Lorem Ipsum", "Sabrine Maalej",
				"Lorem Ipsum", Category.Business, Type.Article,
				" Hal PiDev chayabli rassi, jouny marre. Adieu. bisous. ok. L'animal ; ");
		System.out.println(ReadingManagementDelegate.doAddEbook(ebook2));

		// ////////Populating MOT

		

		MeanOfTransport meanOfTransport1 = new MeanOfTransport();
		meanOfTransport1.setRegistrationNumber("TCV1");
		meanOfTransport1.setCapacity(30);
		meanOfTransport1.setNbOfWagons(1);
		System.out.println(MeansOfTransportDelegate
				.doAddMeanOfTransport(meanOfTransport1));

		MeanOfTransport meanOfTransport2 = new MeanOfTransport();
		meanOfTransport2.setRegistrationNumber("TCV2");
		meanOfTransport2.setCapacity(30);
		meanOfTransport2.setNbOfWagons(1);

		System.out.println(MeansOfTransportDelegate
				.doAddMeanOfTransport(meanOfTransport2));
		
		System.out.println(MeansOfTransportDelegate
				.doLookUpMeanOfTransport("TC"));
		
		

		// //////Populate Users
		Traveler traveler = new Traveler();
		traveler.setName("houcem");
		traveler.setSurname("hidri");
		traveler.setPassword("houcem");
		traveler.setEmail("houcem.hidri@esprit.tn");
		System.out.println(UserServicesDelegate.getProxy().addUser(traveler));

		Traveler traveler2 = new Traveler();
		traveler2.setName("sabrine");
		traveler2.setSurname("Maalej");
		traveler2.setPassword("sabrine");
		traveler2.setEmail("sabrine.maalej@esprit.tn");
		

		traveler2.setNbOfWordsPerMinute(300);
		System.out.println(UserServicesDelegate.getProxy().addUser(traveler2));

		ContentManager contentManager = new ContentManager();
		contentManager.setName("yosr");
		contentManager.setPassword("yosr");
		contentManager.setSurname("gouider");
		contentManager.setEmail("yosr.gouider@esprit.tn");
		 
		System.out.println(UserServicesDelegate.getProxy().addUser(
				contentManager));

		// ////////Populate Stations
		Station st0 = new Station();
		st0.setName("Ariana");
		st0.setReference(0);
		st0.setX(50);
		st0.setY(120);

		Station st1 = new Station();
		st1.setName("Cite Olympique");
		st1.setReference(1);
		st1.setX(80);
		st1.setY(150);

		Station st2 = new Station();
		st2.setName("Mohamed 5");
		st2.setReference(2);
		st2.setX(120);
		st2.setY(170);

		Station st3 = new Station();
		st3.setName("Passage");
		st3.setReference(3);
		st3.setX(150);
		st3.setY(190);

		Station st4 = new Station();
		st4.setName("Barcelone");
		st4.setReference(4);
		st4.setX(170);
		st4.setY(210);

		Station st5 = new Station();
		st5.setName("Megrine");
		st5.setReference(5);
		st5.setX(220);
		st5.setY(150);

		Station st6 = new Station();
		st6.setName("Rades");
		st6.setReference(6);
		st6.setX(270);
		st6.setY(110);

		Station st7 = new Station();
		st7.setName("Ezzahra");
		st7.setReference(7);
		st7.setX(300);
		st7.setY(80);

		Station st8 = new Station();
		st8.setName("Hammam Lif");
		st8.setReference(8);
		st8.setX(300);
		st8.setY(30);
		
		Station st9 = new Station();
		st9.setName("Manar 2");
		st9.setReference(9);
		st9.setX(90);
		st9.setY(250);
		
		Station st10 = new Station();
		st10.setName("Menzeh 9");
		st10.setReference(10);
		st10.setX(40);
		st10.setY(250);
		
		Station st11 = new Station();
		st11.setName("La marsa");
		st11.setReference(11);
		st11.setX(130);
		st11.setY(20);

	
		StationDelegate.DoaddStation(st0);
		StationDelegate.DoaddStation(st1);
		StationDelegate.DoaddStation(st2);
		StationDelegate.DoaddStation(st3);
		StationDelegate.DoaddStation(st4);
		StationDelegate.DoaddStation(st5);
		StationDelegate.DoaddStation(st6);
		StationDelegate.DoaddStation(st7);
		StationDelegate.DoaddStation(st8);
		StationDelegate.DoaddStation(st9);
		StationDelegate.DoaddStation(st10);
		StationDelegate.DoaddStation(st11);
		// //Populating line

		Line line1 = new Line();
		line1.setName("Ariana-Passage");

		Line line2 = new Line();
		line2.setName("Passage-Barcelone");
		
		Line line3 = new Line();
		line3.setName("Barcelone-Hammam Lif");
		
		Line line4=new Line();
		line4.setName("Barcelone-La Marsa");
		
		Line line5=new Line();
		line5.setName("Passage-Menzeh 9");
		

		System.out.println(LineServicesDelegate.DoaddLine(line1));
		System.out.println(LineServicesDelegate.DoaddLine(line2));
		System.out.println(LineServicesDelegate.DoaddLine(line3));
		System.out.println(LineServicesDelegate.DoaddLine(line4));
		System.out.println(LineServicesDelegate.DoaddLine(line5));
		System.out.println(LineServicesDelegate.doFindAllLines());

		TestAssignStationToLine.main(null);
		
		//Assign MOT TO LINE
		
				//System.out.println("assign test "+MeansOfTransportDelegate.doAssignMeanOfTransportToLine(meanOfTransport1, 1));

	}
}
