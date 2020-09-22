package TP1;

import java.util.List;

public class ASD {
	static public class Document {
		
		class Turtle {
			List<Sujet> sujets;

			public Turtle(List<Sujet> s) {
				sujets = s;
			}
		}

		class Sujet {
			Nom nom;
			List<Predicat> preds;

			public Sujet(Nom n, List<Predicat> p) {
				nom = n;
				preds = p;
			}
		}

		class Predicat {
			Nom nom;
			List<Objet> objets;

			public Predicat(Nom n, List<Objet> o) {
				nom = n;
				objets = o;
			}
		}

		abstract class Objet {

		}

		class ObjNom extends Objet {
			Nom nom;

			public ObjNom(Nom n) {
				nom = n;
			}
		}

		class ObjTxt extends Objet {
			String string;

			public ObjTxt(String s) {
				string = s;
			}
		}

		class Nom {
			String string;

			public Nom(String s) {
				string = s;
			}
		}

		public String toNtriples() {
			return "…";
		}
	}

}
