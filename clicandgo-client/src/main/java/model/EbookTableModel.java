package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import BusinessDelegator.ReadingManagementDelegate;
import BusinessDelegator.SessionDelegate;
import BusinessDelegator.UserServicesDelegate;
import entities.Ebook;
import entities.Traveler;

public class EbookTableModel extends AbstractTableModel {
	List<Ebook> ebooks;
	String[] entete = { "Title", "Author", "Description", "Category", "Type" };
	

	public EbookTableModel() {
		if(SessionDelegate.doGetDuration()==null)
		{
		ebooks = ReadingManagementDelegate.doViewLibrary();
		}else{
			ebooks=ReadingManagementDelegate.doSuggestEbooks(SessionDelegate.doGetDuration(), (Traveler) UserServicesDelegate.doAuthenticate(SessionDelegate.doGetLogin(),SessionDelegate.doGetPwd()));
		}
	}

	// public EbookTableModel(String category){
	// ebooks=ReadingManagementDelegate.doViewLibraryByCategory(category);
	// }

	public EbookTableModel(String search) {
		ebooks = ReadingManagementDelegate.doLookUpEbook(search);
	}

	@Override
	public int getRowCount() {
		return ebooks.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			return ebooks.get(rowIndex).getTitle();
		}
		case 1: {
			return ebooks.get(rowIndex).getAuthor();
		}
		case 2: {
			return ebooks.get(rowIndex).getDescription();

		}
		case 3: {
			return ebooks.get(rowIndex).getCategory();
		}
		case 4: {
			return ebooks.get(rowIndex).getType();

		}
		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public String getColumnName(int column) {

		return entete[column];

	}

	public List<Ebook> lookUpEbook(String search) {
		return ebooks = ReadingManagementDelegate.doLookUpEbook(search);
	}

	public List<Ebook> lookUpEbookByCategory(String category) {
		return ebooks = ReadingManagementDelegate.doViewLibraryByCategory(category);
	}
}
