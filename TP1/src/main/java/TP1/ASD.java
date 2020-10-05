package TP1;

import java.util.ArrayList;
import java.util.List;

public class ASD {
	static public class Document {
		Turtle turt;

		public Document(Turtle t) {
			turt = t;
		}

		public class Turtle {
			List<Sujet> sujets;

			public Turtle(List<Sujet> s) {
				sujets = s;
			}
			
			public ArrayList<String> toStringList() {
				ArrayList<String> s = new ArrayList<String>();
				for (Sujet suj : sujets) {
					System.out.println(suj);
					for (String str : suj.toStringList())
					s.add(str);
				}
				return s;
			}
		}

		public class Sujet {
			Nom nom;
			List<Predicat> preds;

			public Sujet(Nom n, List<Predicat> p) {
				nom = n;
				preds = p;
			}
			public ArrayList<String> toStringList() {
				ArrayList<String> s = new ArrayList<String>();
				for (Predicat p : preds) {
					for (String l : p.toStringList()) {
						s.add(s.size(),(nom.toString()+l));
					}
				}
				return s;
			}

		}

		public class Predicat {
			Nom nom;
			List<Objet> objets;

			public Predicat(Nom n, List<Objet>  o) {
				nom = n;
				objets = o;
			}
			public ArrayList<String> toStringList() {
				ArrayList<String> s = new ArrayList<String>();
				for (Objet o : objets) {
					s.add(nom.toString() + o.toString());
				}
				return s;
			}
		}

		public abstract class Objet {

		}

		public class ObjNom extends Objet {
			Nom nom;

			public ObjNom(Nom n) {
				nom = n;
			}
			public String toString() {
				
				return nom.toString();
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
			
			public String toString() {
				return "\""  + string + "\"";
			}
		}

		public class Nom {
			String string;

			public Nom(String s) {
				string = s;
			}
			public String toString() {
				
				return "<" + string + ">";
			}
		}

		public String toNtriples() {
			 ArrayList<String> l = turt.toStringList();
			 System.out.println(l.size());
			 String s = "";
			 for (String str : l) {
				 s = str + "\n" + s;
			 }
			return s;
		}
	}

}
