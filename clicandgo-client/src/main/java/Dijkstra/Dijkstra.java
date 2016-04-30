package Dijkstra;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import BusinessDelegator.SessionDelegate;
import BusinessDelegator.StationDelegate;
import BusinessDelegator.StationLineManagementDelegate;
import entities.Station;

public class Dijkstra {
	@PersistenceContext
	EntityManager entitymanager;

	// creation du graphe
	public static final int INFINITE = 1000;// Integer.MAX_VALUE;
	public final static int ALPHA_NOTDEF = -999;// on met final psk c'est une
												// constante
	private int x0;
	private int[] S;// ensemble de sommets dont les distances les plus courtes �
					// la source sont connues au d�part seulement Source
	private int[] R;// ensemble des pr�d�cesseur des sommets de 0 � N-1;
	private Graphe g0;
	private int[] D;// tableau des valeurs du meilleur raccourci pour se rendre
					// � chaque sommet
	// rajout
	private boolean[] noeudsMarqu�s;
	private static int dimensionDeLaMatrice;// je rajoute �a pour simplifier le
											// code.

	public Dijkstra(int x, Graphe g) {
		x0 = x;
		g0 = g;
		dimensionDeLaMatrice = g0.nbSommet();
		S = new int[dimensionDeLaMatrice];// sommets atteints
		D = new int[dimensionDeLaMatrice];// distances
		noeudsMarqu�s = new boolean[dimensionDeLaMatrice];
		R = new int[dimensionDeLaMatrice];
		calculePlusCourtChemin();
	}

	private void calculePlusCourtChemin() {
		int n = 0;
		for (int a = 0; a < dimensionDeLaMatrice; a++) {
			noeudsMarqu�s[a] = false;
			S[a] = -1; // en supposant qu'on num�rote les sommets de 0 ou de 1 �
						// n.
			R[a] = -1; // pour les noeuds qui n'ont pas de pr�dec�sseur
		}

		S[n] = x0;
		D[x0] = 0;
		R[x0] = x0;
		initDistMin();
		for (int i = 0; i < dimensionDeLaMatrice; i++) {
			if (!contains(S, i)) {// � revoir
				int t = choixSommet();
				noeudsMarqu�s[t] = true;
				n++;
				S[n] = t;
				majDistMin(t);
			} // end if
		}// end for
			// for (int i=0; i<dimensionDeLaMatrice;i++){
		// System.out.print(" S[i]"+S[i]);
		// }
		// for (int i=0; i<dimensionDeLaMatrice;i++){
		// System.out.print(" R["+i+"]"+R[i]);
		// }
		// System.out.println();
	}

	// impl�mentation de initDistMin
	private void initDistMin() {
		noeudsMarqu�s[x0] = true;
		for (int i = 0; i < dimensionDeLaMatrice; i++) {
			if (g0.existeArc(x0, i)) {
				D[i] = g0.getU()[x0][i];
				R[i] = x0;
			} else {
				if (x0 != i)
					D[i] = -g0.ALPHA_NOTDEF + 1;
			}
		}
	}

	private void majDistMin(int n) {
		for (int i = 0; i < dimensionDeLaMatrice; i++) {
			if (!contains(S, i)) {
				// D[i] = min(D[i], D[n] + distanceDsGraphe(n,i));
				if (D[n] + distanceDsGraphe(n, i) < D[i]) {
					D[i] = D[n] + distanceDsGraphe(n, i);
					R[i] = n;
				}
			}
		}
	}

	private int distanceDsGraphe(int t, int s) {
		if (g0.existeArc(t, s)) {
			return g0.getU()[t][s];
		} else {
			return INFINITE;
		}
	}

	public int choixSommet() {
		int valeurMin = INFINITE;
		int min = x0;
		for (int i = 0; i < dimensionDeLaMatrice; i++) {
			if (!noeudsMarqu�s[i])
				if (D[i] <= valeurMin) {
					min = i;
					valeurMin = D[i];
				}
		}
		return min;
	}

	// fonction � d�finir :S.contains(i)
	private boolean contains(int[] S, int i) {
		return noeudsMarqu�s[i];
	}

	public int longueurChemin(int i) {
		return D[i];
	}

	// fonction � d�finir min
	private int min(int i, int j) {
		if (i <= j)
			return i;
		else
			return j;
	}

	public String afficheCheminByStation(String depart, String arrivee) {
		String ch = null;
		String sh = "";
		Station stationdepart = StationDelegate
				.findStationByStationName(depart);
		Station stationarrivee = StationDelegate
				.findStationByStationName(arrivee);
		int i = stationarrivee.getReference();
		int source = stationdepart.getReference();

		int ant�c�dent = i;
		Vector<Integer> lesNoeudsIntermediaires = new Vector<Integer>();
		;
		System.out.println(" de " + depart + " � " + arrivee + ":");
		while (ant�c�dent != source) {
			lesNoeudsIntermediaires.add(ant�c�dent);
			ant�c�dent = R[ant�c�dent];

		}
		lesNoeudsIntermediaires.add(source);
		for (int j = lesNoeudsIntermediaires.size() - 1; j > 0; j--) {
			Station stationvariable = StationDelegate
					.doFindStationByReference(lesNoeudsIntermediaires.get(j));
			System.out.print("-->" + stationvariable.getName());
			sh = sh + "-->" + stationvariable.getName();
		}
		System.out.print("-->" + stationarrivee.getName());
		System.out.println();
		String yy = "-->" + arrivee;
		ch = "To go from  " + depart + " to " + arrivee + ": \n" + sh + yy;
		return ch;
	}

	public List<Station> afficheListStations(String depart, String arrivee) {
		List<Station> stationsToDraw = new Vector<Station>();
		Station stationdepart = StationDelegate
				.findStationByStationName(depart);
		Station stationarrivee = StationDelegate
				.findStationByStationName(arrivee);
		int i = stationarrivee.getReference();
		int source = stationdepart.getReference();

		int ant�c�dent = i;
		Vector<Integer> lesNoeudsIntermediaires = new Vector<Integer>();
		;
		System.out.println(" de " + depart + " � " + arrivee + ":");
		while (ant�c�dent != source) {
			lesNoeudsIntermediaires.add(ant�c�dent);
			ant�c�dent = R[ant�c�dent];

		}
		lesNoeudsIntermediaires.add(source);

		for (int j = lesNoeudsIntermediaires.size() - 1; j > 0; j--) {
			Station stationvariable = StationDelegate
					.doFindStationByReference(lesNoeudsIntermediaires.get(j));
			stationsToDraw.add(stationvariable);
			System.out.print("-->" + stationvariable.getName());

		}
		System.out.print("-->" + stationarrivee.getName());
		System.out.println();
		String yy = "-->" + arrivee;
		stationsToDraw.add(stationarrivee);
		return stationsToDraw;

	}

	public String afficheChemin(int i) {
		String ch = null;
		String sh = null;
		int source = x0;
		int ant�c�dent = i;
		Vector<Integer> lesNoeudsIntermediaires = new Vector<Integer>();
		;
		System.out.println("Chemin de " + x0 + " � " + i + ":");
		while (ant�c�dent != source) {
			lesNoeudsIntermediaires.add(ant�c�dent);
			ant�c�dent = R[ant�c�dent];

		}
		lesNoeudsIntermediaires.add(source);
		for (int j = lesNoeudsIntermediaires.size() - 1; j > 0; j--) {
			System.out.print("-->" + lesNoeudsIntermediaires.get(j));
			sh = sh + "-->" + lesNoeudsIntermediaires.get(j);
		}
		System.out.print("-->" + i);
		System.out.println();
		ch = "Your Itinerary  from " + x0 + " to " + i + ": " + sh;

		return ch;
	}

	public String AfficherDestinationEtCout(String depart, String arrivee) { // Station
		int time = 0;
		String ch = null;
		String sh = null;// stationdepart=StationDelegate.findStationByStationName(depart);
		Station stationarrivee = StationDelegate
				.findStationByStationName(arrivee);
		System.out.print("le cout du chemin est ");
		int duree = longueurChemin(stationarrivee.getReference());
		SessionDelegate.doSetDuration(duree);
		System.out.println(SessionDelegate.doGetDuration());
		System.out.println(+duree);
		System.out.print("/n");
		System.out.print("le chemain a prendre");
		sh = afficheCheminByStation(depart, arrivee);

		// SessionDelegate.doSetDeparture(depart);
		// SessionDelegate.doSetDuration(duree);

		time = (int) (duree / 0.75);

		String timer = "";
		timer = "Your itinerary takes about " + time + " minutes";

		ch = "Your itinerary is  " + duree + " km long .\n " + sh + " \n"
				+ timer;
		return ch;

	}

	public static void main(String[] args) {
		int N = Graphe.ALPHA_NOTDEF;
		Station stationdepart = StationDelegate
				.findStationByStationName("Ariana");
		// Station
		// stationarrivee=StationDelegate.findStationByStationName("La marsa");

		int[][] matDuree = StationLineManagementDelegate.doRemplirMatrice();
		// { { N, 2, 4, 1, N }, { 2, N, 3, 3, 6 },
		// { 4, 3, N, N, 7 }, { 1, 3, N, N, 2 }, { N, 6, 7, 2, N },
		//
		// };
		// cr�ation du graphe
		Graphe g0 = new Graphe(matDuree);
		// LA SUITE

		// creation d'une instance de l'algorithme avec le graphe g0
		Dijkstra beaulieuAutresStations = new Dijkstra(
				stationdepart.getReference(), g0);

		// Calcul du plus court chemin avec l'algorithme de Dijkstra
		beaulieuAutresStations.calculePlusCourtChemin();

		// Affichage du temps de trajet
		// int duree = beaulieuAutresStations.longueurChemin(4);
		// System.out.println("Le temps mini pour aller de beaulieu a Clemenceau est :"+duree);
		// int duree2 = beaulieuAutresStations.longueurChemin(8);
		// System.out.println("Le temps mini pour aller de beaulieu au Stade est :"+duree2);
		// //Faire d'autres tests
		// int dureeVillejean = beaulieuAutresStations.longueurChemin(10);
		// System.out.println("Le temps mini pour aller de beaulieu � VilleJean est :"+dureeVillejean);

		// Pour afficher le chemin le plus rapide pour aller de beaulieu a
		// Clemenceau
		// beaulieuAutresStations.afficheCheminByStation(barcelone); // pour �a
		// il faut un tableau de pr�d�cesseur, il nous faudra un tableau de
		// routage
		// il nous faudrait cr�er un tableau R des pr�decesseurs.

		beaulieuAutresStations.AfficherDestinationEtCout("Ariana", "La marsa");
		// Creation d'une nouvelle instance de l'algorithme avec un d�part de
		// Republique
		// Dijkstra republiqueAutresStations= new Dijkstra(7,g0);
		// republiqueAutresStations.calculePlusCourtChemin();
		// int duree3 = republiqueAutresStations.longueurChemin(3);
		// System.out.println("Le temps mini pour aller de republique a Clemenceau est :"+duree3);
		List<Station> stations = beaulieuAutresStations.afficheListStations(
				"Ariana", "La marsa");

		for (Station s : stations) {
			System.out.println(s.getName());
		}
	}

}