package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import BusinessDelegator.UserServicesDelegate;
import entities.User;

public class UserTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<User> users;
	String[] entete = {"userId", "name", "surname", "email"};

	public UserTableModel(String name) {
		users = UserServicesDelegate.doFindUserByName(name);
	}

	public UserTableModel() {
		users = UserServicesDelegate.doFindAllUsers();
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			return users.get(rowIndex).getUserId();
		}
		case 1: {
			return users.get(rowIndex).getName();
		}
		case 2: {
			return users.get(rowIndex).getSurname();

		}
		case 3: {
			return users.get(rowIndex).getEmail();
		}
		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public String getColumnName(int column) {

		return entete[column];

	}

	@SuppressWarnings("unused")
	public List<User> searchUsers(String name) {

		List<User> users = UserServicesDelegate.doFindUserByName(name);
		List<User> searchUsers = new ArrayList<>();
		List<User> resultList = new ArrayList<>();

		return searchUsers;
	}

}