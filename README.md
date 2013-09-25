Aloysia De Bernes De Longvilliers 
Mathilde De l'Hermuziere
------------------------------------------------------------------
CORRECTION+CODE REVIEW:
------------------------------------------------------------------

-------------------------
Expérience utilisateur:
-------------------------
On arrive sur la page principale, ca a l'air sympa!

L'affichage de la date est facilité (on n'affiche pas les secondes etc...), j'aime!

L'ordre de départ aurait pu être le Computer Name, mais bon pas grave.

Orderby: ca marche aussi, mais si je veux un ordinateur "ZZ", recliquer sur "Computer Name" devrait pouvoir afficher l'ordre décroissant, ca aurait été sympa d'implémenter ça. 

Recherche: dommage! la recherche ne change ni le nombre d'ordinateurs, ni la pagination. Donc quand je recherche Apple, j'ai toujours 574 ordinateurs et autant de pages. Ce n'est pas cohérent...
Pareil, quand je clique sur orderby ensuite, ca me pert la recherche!

Ajout d'ordinateur: Contrôle du nom: pas de problème.
Je mets la date 2001-01-03, et je valide et là: message du navigateur "Please match the requested format". 

Pourtant, la date a bien été mise en format YYYY-MM-DD comme indiqué dans l'aide. Je cherche dans votre js, et votre script a l'air d'être bon. où est le problème?

Balise pattern dans votre formulaire est à "YY-MM-DD" (donc déjà, ca devrait être YYYY-MM-DD). Mais ca ne suffit pas: ce pattern est une expression régulière (ou regex), quand vous mettez ceci en pattern, il va chercher la chaine "YYYY-MM-DD", alors que vous voulez en réalité quatre chiffres, un tiret, deux chiffres <= 12, un tiret etc... il aurait fallu écrire un truc du style:

(19[6-9][0-9]|20[0-9][0-9])\-(0?[1-9]|1[12])\-(0?[1-9]|[1-2][0-9]|3[01])


Edit d'ordinateur:
Les dates sont préremplies: bravo!
Par contre, que se passe-t-il quand il n'y avait pas de date?

Clear: ok, si je voulais update mais que j'ai cliqué sur clear, mon ordi est perdu... une petite confirm dialog pour "etes vous sur de vouloir supprimer?" aurait été pas mal.

-------------------------
Le code:
-------------------------
-Commentaires: yes! pour la javadoc, n'hésitez pas à rajouter @author, @returns, @param etc...

-Protection des jsp: bien

-Utilisation des builder: bien!

-Utilisation des enums pour les singletons: yes!

-Controllers: Bon... les 50 000 if else if en java 7 c'est dépassé, on fait un switch sur le string! Sinon c'est pas mal, n'hésitez pas à aérer un peu plus le code.

-Services: RAS

-Dao: Un commentaire au dessus d'une méthode est un peu inutile, il vaut mieux mettre des commentaires javadoc /** */
Attention: les em.close() ne sont pas tous dans un bloc try/finally: du coup si une exception arrive, vous ne fermerez pas la connexion et elle ne sera pas utilisable dans le pool de connexion! c'est dangereux!

-Domain: RAS

-JSP: C'est bien. le code est clair et indenté.

Bien d'avoir exporté les scripts dans un fichier js, et bonne utilisation de jquery

-------------------------
Bilan: 
-------------------------
Bon projet, vous avez fait des efforts sur la validation et l'affichage et globalement bien travaillé. C'est dommage de ne pas avoir poussé vos tests pour les dates et la recherche, il ne manquait pas grand chose pour que ce soit parfait.
Attention à cette phase de test donc, car c'est essentiel dans tout bon programme.
