public class ProgrammeFamille {
	
	public static void main(String[] args) {

        /*------------------------------------------------------*/
        /* Plan pour la fonction principale :                   */
        /*                                                      */
        /*  0.  D�clarations des tableaux de noms et pr�noms    */
        /*  1.  Affichage des tableaux                          */
        /*  2.  Cr�ation de la famille SW                       */
        /*  3.  Cr�ation et ajouts des Personne dans la Famille */
        /*  4.  Affichage de la Famille                         */
        /*  5.  Tri de la Famille                               */
        /*  6.  Affichage de la Famille                         */
        /*  7.0 Ajustement des champs de luke, padme et anakin  */
        /*  7.1 Ajout des naissances et unions                  */
        /*  8.  Affichage des champs d'une personne             */
        /*  9.  Affichage du graphe au format texte             */
        /* 10.  Sauvegarde dans un fichier                      */
        /*                                                      */
        /*------------------------------------------------------*/

        Personne luke = new Personne("Luke","SKYWALKER");
        Personne padme = new Personne("Padmé","AMIDALA");
        Personne anakin = new Personne("Anakin","SKYWALKER");
        Personne morrigan = new Personne("Morrigan","CORDE");
        Personne mara = new Personne("Mara","JADE");
        Personne leia = new Personne("Leia","ORGANA");
        Personne ben = new Personne("Ben","SKYWALKER");
        Personne cade = new Personne("Cade","SKYWALKER");
        Personne kol = new Personne("Kol","SKYWALKER");
        Personne nat = new Personne("Nat","SKYWALKER");
        Personne shmi = new Personne("Shmi","SKYWALKER");
        Personne anakins = new Personne("Anakin","SOLO");
        Personne han = new Personne("Han","SOLO");
        Personne jacen = new Personne("Jacen","SOLO");
        Personne jaina = new Personne("Jaina","SOLO");
        
        Famille famille = new Famille();
        
        try {
        	ajoutPersonne(famille, luke);
        	ajoutPersonne(famille, padme);
        	ajoutPersonne(famille, anakin);
        	ajoutPersonne(famille, morrigan);
        	ajoutPersonne(famille, mara);
        	ajoutPersonne(famille, leia);
        	ajoutPersonne(famille, ben);
        	ajoutPersonne(famille, cade);
        	ajoutPersonne(famille, kol);
        	ajoutPersonne(famille, nat);
        	ajoutPersonne(famille, shmi);
        	ajoutPersonne(famille, anakins);
        	ajoutPersonne(famille, han);
        	ajoutPersonne(famille, jacen);
        	ajoutPersonne(famille, jaina);
        }
    	catch (Exception e){ System.out.println("[CRASH "+e+"] "); }
        catch (Error e){ System.out.println("[CRASH "+e+"] "); }
        
        
        afficheFamille(famille);
        trierFamille(famille);
        System.out.println("");
        afficheFamille(famille);
        
        luke.pere = anakin;
        luke.mere = padme;
        anakin.conjoint = padme;
        padme.conjoint = anakin;
        luke.conjoint = mara;
        anakin.mere = shmi;
        
        mariage(leia, han);
        mariage(morrigan, kol);
        
        naissance(leia, padme, anakin);
        naissance(anakin, shmi, null);
        naissance(ben, mara, luke);
        naissance(jacen, leia, han);
        naissance(jaina, leia, han);
        naissance(anakins, leia, han);
        naissance(nat, null, ben);
        naissance(cade, morrigan, kol);
        
        for (int i=0; i<famille.nbMembres; i++) {
        	System.out.println("\n" + toString(famille.membres[i]));
        }   
    }
	

	/** Ajoute pfPersonne � la famille pfFamille
	 *
	 * @param pfFamille IN/OUT : la famille
	 * @param pfPersonne IN : le membre � ajouter
	 *
	 * @throws Exception si plus de place dans la famille
	 */
	public static void ajoutPersonne(Famille pfFamille, Personne pfPersonne) throws Exception {
	    if(pfFamille.membres.length < pfFamille.nbMembres + 1) {
	        throw new Exception("Plus de place dans la famille !") ;
	    }
	    pfFamille.membres[pfFamille.nbMembres] = pfPersonne ;
	    pfFamille.nbMembres ++ ;
	}
	
	
	/** Affiche la famille pfFamille.
	 *
	 * @param pfFamille IN : la famille
	 */
	public static void afficheFamille(Famille pfFamille) {
		System.out.println("Les " + pfFamille.nbMembres + " membres de la famille sont:");
		for (int i=0; i<pfFamille.nbMembres; i++) {
			System.out.println(pfFamille.membres[i].prenom + " " + pfFamille.membres[i].nom);
		}
	}
	
	
	public static void trierFamille(Famille pfFamille) {
		boolean permut = true;
		while (permut) {
			int nbPermut = 0;
			for (int i=0; i<pfFamille.nbMembres-1; i++) {
				if (pfFamille.membres[i].nom.compareTo(pfFamille.membres[i+1].nom) >0) {
					Personne ech = pfFamille.membres[i];
					pfFamille.membres[i] = pfFamille.membres[i+1];
					pfFamille.membres[i+1] = ech;
					nbPermut ++;
				}
				else if (pfFamille.membres[i].nom.compareTo(pfFamille.membres[i+1].nom) == 0) {
					if (pfFamille.membres[i].prenom.compareTo(pfFamille.membres[i+1].prenom) >0) {
						Personne ech = pfFamille.membres[i];
						pfFamille.membres[i] = pfFamille.membres[i+1];
						pfFamille.membres[i+1] = ech;
						nbPermut ++;
					}
				}
			}
			if (nbPermut == 0) {
				permut = false;
			}
		}
	}
	
	
	/** Marie des personnes.
	 *
	 * @param pfPersonne1 IN/OUT : première personne mariage
	 * @param pfPersonne2 IN/OUT : seconde personne mariage
	 */
	public static void mariage(Personne pfPersonne1, Personne pfPersonne2) {
		pfPersonne1.conjoint = pfPersonne2;
		pfPersonne2.conjoint = pfPersonne1;
	}
	
	
	/** Indique que pfMere et pfPere ont eu un enfant pfEnfant.
	 *
	 * @param pfEnfant IN/OUT : enfant de pfMere et pfPere
	 * @param pfMere IN : mère de pfEnfant
	 * @param pfPere IN : père de pfEnfant
	 */
	public static void naissance(Personne pfEnfant, Personne pfMere, Personne pfPere) {
		pfEnfant.pere = pfPere;
		pfEnfant.mere = pfMere;
	}
	
	
	public static String toString(Personne pfPersonne) {
		String infos = "";
		infos += "Prenom: " + pfPersonne.prenom + "\n";
		infos += "Nom: " + pfPersonne.nom + "\n";
		infos += "Mere: " + pfPersonne.mere + "\n";
		infos += "Pere: " + pfPersonne.pere + "\n";
		infos += "Conjoint: " + pfPersonne.conjoint;
		return infos;
	}

	
	public static boolean inTab(Personne[] pfTab, Personne pfPersonne) {
		for (Personne i : pfTab) {
			if(i==pfPersonne) {
				return true;
			}
		}
		return false;
	}
	
}
