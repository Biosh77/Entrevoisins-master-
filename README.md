Entrevoisins
Entre voisins est une application qui permet à des personnes ( voisins)  d’un même quartier de se rendre des petits services : petit bricolage,cours particuliers etc 
après collecte des retours vis à vis de cette application, j'ai été solicité pour développer une nouvelle fonctionnalité

Prérequis
Un ordinateur fonctionnel , Android Studio, un téléphone portable sous android.

Pour compiler le projet 
Pour compiler l'application Entrevoisins il fait cliquer sur le bouton run en haut à droite dans android studio.
 

Les tests
Les tests sont présents dans : 
- NeighbourServiceTest.java
public void getNeighboursWithSuccess(): test pour vérifier si la récupération de Neighbour se passe.
public void deleteNeighbourWithSuccess(): test pour vérifier si le Neighbour est supprimé avec succès.
public void changeFavoriteNeighbourWithSuccess(): test pour vérifier qu'on peut mettre des voisins dans les favoris.
public void getFavoriteNeighboursWithSuccess(): test pour vérifier que getFavoriteNeighbours renvoie bien que les voisins favoris.

- NeighbourDetailTest.java
public void showDetailNeighbourWithSuccess():Test vérifiant que le détail sur un Neighbour est bien affiché après avoir cliqué dessus.
public void showDetailNameWithSuccess():Test vérifiant que le Neighbour montré est bien le bon.
public void checkIfRemovingUserIsWorking():Test vérifiant que le Neighbour a bien été supprimé.
public void showFavoriteInTab() :Test vérifiant que les favoris sont bien visibles dans l'onglet.

Built With
Android Studio.
Auteur
Jordane Meunier
