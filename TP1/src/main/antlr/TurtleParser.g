parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
}

document returns [ASD.Document out]
  : s=turtle[new ASD.Document(null)] EOF {$out = new ASD.Document($s.out);}
  ;

turtle[ASD.Document doc] returns [ASD.Document.Turtle out] : l=listSujet[doc] {System.out.println("one");$out = doc.new Turtle($l.out);};

listSujet[ASD.Document doc] returns [List<ASD.Document.Sujet> out] : s=sujet[doc] l=listSujet[doc] {$out = $l.add(s);}
																	| s=sujet[doc] {$out = new List<ASD.Document.Sujet>();$out.add(s);};

sujet[ASD.Document doc] returns [ASD.Document.Sujet out] :  n=nom[doc] l=predicat[doc] PT{$out = doc.new Sujet($n.out,$l.out);};


listPredicat[ASD.Document doc] returns [List<ASD.Document.Predicat> out] :  p=predicat[doc] l=listPredicat[doc] {$out = $l.add(p);}
																		 |	p=predicat[doc]{$out = new List<ASD.Document.Predicat>();$out.add(p);};
																		 
predicat[ASD.Document doc] returns [ASD.Document.Predicat out] :n=nom[doc] l=objet[doc] PTV{$out = doc.new Predicat($n.out,$l.out);};

listObjet[ASD.Document doc] returns [List<ASD.Document.Objet> out] : o=objet[doc] l=listObjet[doc] {$out = $l.add(o);}
																	| o=objet[doc] {$out = new List<ASD.Document.Objet>();$out.add(o);};
																	
objet[ASD.Document doc] returns [ASD.Document.Objet out] : n=nom[doc] {$out = doc.new ObjNom($n.out);}
														| GUI NOM* GUI {$out = doc.new ObjTxt("hello");};
	
nom[ASD.Document doc] returns [ASD.Document.Nom out] :  CHEVRONLEFT n=NOM CHEVRONRIGHT {$out = doc.new Nom("hello");};
