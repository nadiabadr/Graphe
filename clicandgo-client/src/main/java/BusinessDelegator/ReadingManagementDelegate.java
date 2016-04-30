package BusinessDelegator;

import java.util.List;

import entities.Ebook;
import entities.StationLine;
import entities.Traveler;
import ServiceLocator.ServiceLocator;
import services.interfaces.ReadingManagementRemote;

public class ReadingManagementDelegate {

	public static final String jndiName = "/clicandgo-ejb/ReadingManagement!services.interfaces.ReadingManagementRemote";

	public static ReadingManagementRemote getProxy() {
		return (ReadingManagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Boolean doAddEbook(Ebook ebook){
		return getProxy().addEbook(ebook);
	}
	
	public static List<Ebook> doSuggestEbooks(Integer duration, Traveler traveler ){
		return getProxy().suggestEbooks(duration, traveler);
	}
	
	public static List<Ebook> doLookUpEbook(String search){
		return getProxy().lookUpEbook(search);
	}
	
	public static List<Ebook> doViewLibrary(){
		return getProxy().viewLibrary();
	}
	public static List<Ebook> doViewLibraryByCategory(String category){
		return getProxy().viewLibraryByCategory(category);
	}
}
