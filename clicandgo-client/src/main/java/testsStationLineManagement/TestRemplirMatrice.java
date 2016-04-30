package testsStationLineManagement;

import BusinessDelegator.StationLineManagementDelegate;

public class TestRemplirMatrice {
	public static void main(String[] args) {

		int[][] matrice = StationLineManagementDelegate.doRemplirMatrice();
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();

		}

	}
}
