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

turtle[ASD.Document doc] returns [ASD.Document.Turtle out] : l=listSujet[doc] {$out = doc.new Turtle($l.out);};

listSujet[ASD.Document doc] returns [List<ASD.Document.Sujet> out] : s=sujet[doc] l=listSujet[doc] {$l.out.add($s.out);$out = $l.out;}
																	| s=sujet[doc] {$out = new ArrayList<ASD.Document.Sujet>();$out.add($s.out);};

sujet[ASD.Document doc] returns [ASD.Document.Sujet out] :  n=nom[doc] l=listPredicat[doc]{$out = doc.new Sujet($n.out,$l.out);};


listPredicat[ASD.Document doc] returns [List<ASD.Document.Predicat> out] :  p=predicat[doc] PTV l=listPredicat[doc] {$l.out.add($p.out);$out = $l.out;}
																		 |	p=predicat[doc] PT{$out = new ArrayList<ASD.Document.Predicat>();$out.add($p.out);};
																		 
predicat[ASD.Document doc] returns [ASD.Document.Predicat out] :n=nom[doc] l=listObjet[doc] {$out = doc.new Predicat($n.out,$l.out);};

listObjet[ASD.Document doc] returns [List<ASD.Document.Objet> out] : o=objet[doc] VRG l=listObjet[doc] {$l.out.add($o.out);$out = $l.out;}
																	| o=objet[doc] {$out = new ArrayList<ASD.Document.Objet>();$out.add($o.out);};
																	
objet[ASD.Document doc] returns [ASD.Document.Objet out] : n=nom[doc] {$out = doc.new ObjNom($n.out);}
														| GUI a=NOM GUI {$out = doc.new ObjTxt($a.text);};
	
nom[ASD.Document doc] returns [ASD.Document.Nom out] :  CHEVRONLEFT n=NOM CHEVRONRIGHT {$out = doc.new Nom($n.text);};
