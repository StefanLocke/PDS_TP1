# PDS_TP1

ASD etendue :


turtle ::= Turt(sujet*)

sujet ::= Suj(nom,predicats*)

predicats ::= Pred(nom,objets+)

objets ::= Obj(nom) 
         | Objtxt(String)

nom ::= Name(String)

ASD Non-e :


turtle ::= Turt(listSujet)

listSujet ::= ListS(sujet,listSujet) 
            | Nil

sujet ::= Suj(nom,listPredicats*)

listPredicats ::= ListPred(predicats,listPredicats)
                  | Nil

predicats ::= Pred(nom,listObjets)

listObjets ::= ListObj(objets,listObjets)
              | objets

objets ::= Obj(nom) 
         | Objtxt(String)

nom ::= Name(String)
