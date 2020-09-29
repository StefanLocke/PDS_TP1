package TP1;

import java.util.List;

public class ASD {
	static public class Document {
		Turtle turt;

		/*public Document(Turtle t) {
			turt = t;
		}*/

		public class Turtle {
			List<Sujet> sujets;

			public Turtle(List<Sujet> s) {
				sujets = s;
			}
		}

		public class Sujet {
			Nom nom;
			List<Predicat> preds;

			public Sujet(Nom n, List<Predicat> p) {
				nom = n;
				preds = p;
			}

		}

		public class Predicat {
			Nom nom;
			List<Objet> objets;

			public Predicat(Nom n, List<Objet> o) {
				nom = n;
				objets = o;
			}
		}

		public abstract class Objet {

		}

		public class ObjNom extends Objet {
			Nom nom;

			public ObjNom(Nom n) {
				nom = n;
			}
		}

		public class ObjTxt extends Objet {
			String string;

			public String getVal() {
				return string;
			}

			public ObjTxt(String s) {
				string = s;
			}
		}

		public class Nom {
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
