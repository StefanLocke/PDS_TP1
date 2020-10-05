package TP1;

import java.nio.file.Paths;
import java.util.ArrayList;

import TP1.ASD.Document;
import TP1.ASD.Document.*;

import java.io.IOException;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {
	public static void main(String[] args) {
		/* Use with a manually made AST
		ASD.Document ast = new ASD.Document();
		
		ArrayList<Objet> listObjType = new ArrayList<Objet>();
		listObjType.add(ast.new ObjNom(ast.new Nom("poly")));
		Predicat type = ast.new Predicat(ast.new Nom("Type"), listObjType);

		ArrayList<Objet> listObjTitre = new ArrayList<Objet>();
		listObjTitre.add(ast.new ObjTxt("Compilation"));
		Predicat titre = ast.new Predicat(ast.new Nom("Titre"), listObjTitre);

		ArrayList<Objet> listObjAuteur = new ArrayList<Objet>();
		listObjAuteur.add(ast.new ObjNom(ast.new Nom("Ridoux")));
		listObjAuteur.add(ast.new ObjNom(ast.new Nom("Ferre")));
		Predicat auteur = ast.new Predicat(ast.new Nom("Auteur"), listObjAuteur);

		ArrayList<Predicat> listPredPoly = new ArrayList<Predicat>();
		listPredPoly.add(type);
		listPredPoly.add(auteur);
		listPredPoly.add(titre);
		Sujet poly = ast.new Sujet(ast.new Nom("poly 117"), listPredPoly);

		ArrayList<Objet> listObjR = new ArrayList<>();
		listObjR.add(ast.new ObjNom(ast.new Nom("personne")));
		listObjR.add(ast.new ObjNom(ast.new Nom("professeur")));

		Predicat typeR = ast.new Predicat(ast.new Nom("type"), listObjR);

		ArrayList<Predicat> listPredRidoux = new ArrayList<>();
		listPredRidoux.add(typeR);

		Sujet ridoux = ast.new Sujet(ast.new Nom("Ridoux"), listPredRidoux);

		ArrayList<Sujet> listS = new ArrayList<>();
		listS.add(poly);
		listS.add(ridoux);
		Turtle t = ast.new Turtle(listS);
		ast.turt = t;
		System.out.println(ast.toNtriples());*/

		// Use with lexer and parser
		
		ASD.Document d = new ASD.Document(null);
		ASD.Document.Nom n = d.new Nom("hello");
		System.out.println(n.string);
		try {
		      // Set input
		      CharStream input;
		      if(args.length == 0) {
		        // From standard input
		        input = CharStreams.fromStream(System.in);
		      }
		      else {
		        // From file set in first argument
		        input = CharStreams.fromPath(Paths.get(args[0]));
		      }

		      // Instantiate Lexer
		      TurtleLexer lexer = new TurtleLexer(input);
		      CommonTokenStream tokens = new CommonTokenStream(lexer);

		      // Instantiate Parser
		      TurtleParser parser = new TurtleParser(tokens);

		      // Parse
		      ASD.Document ast = parser.document().out;

		      // Print as Ntriples
		      System.out.println(ast.toNtriples());
		    } catch(IOException e) {
		      e.printStackTrace();
		    }
	}
}
