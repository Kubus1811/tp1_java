package gestionMagasin;

import java.util.Scanner;

// Classe principale pour lancer l'application
public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin();
        Magasin magasinSecondaire = new Magasin(); 

        Produit p1 = new Produit(1, "Ordinateur Portable", 799.99, 5);
        Produit p2 = new Produit(2, "Souris sans fil", 19.99, 15);
        Produit p3 = new Produit(3, "Clavier mecanique", 49.99, 10);
        Produit p4 = new Produit(4, "Ecran 24 pouces", 129.50, 7);
        Produit p5 = new Produit(5, "Casque audio", 39.90, 12);

        magasin.ajouterProduit(p1);
        magasin.ajouterProduit(p2);
        magasin.ajouterProduit(p3);
        magasin.ajouterProduit(p4);
        magasin.ajouterProduit(p5);


        magasinSecondaire.ajouterProduit(new Produit(6, "Cle USB 64Go", 12.99, 20));


        Client client = new Client(1, "Jean Dupont", "jean.dupont@email.com");
        Client client2 = new Client(2, "Alice Martin", "alice.martin@email.com"); 

        Panier panier = new Panier();

        int idCommande = 1;

        boolean continuer = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le magasin en ligne !");
        client.afficherDetails();

        // Boucle principale du menu
        while (continuer) {
            System.out.println("\n--- Menu Magasin ---");
            System.out.println("1. Afficher les produits disponibles");
            System.out.println("2. Ajouter un produit au panier");
            System.out.println("3. Afficher le panier");
            System.out.println("4. Passer la commande");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");

            
            String input = scanner.nextLine().trim();
            int choix = -1;

            try {
                choix = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre valide entre 1 et 5.");
                continue;
            }

            switch (choix) {
                case 1:
                    magasin.afficherProduitsDisponibles();
                    break;

                case 2:
                    System.out.print("Entrez le nom du produit a ajouter : ");
                    String nomRecherche = scanner.nextLine().trim();
                    Produit produitTrouve = magasin.trouverProduitParNom(nomRecherche);

                    // Si pas trouve par nom, on essaye par son id
                    if (produitTrouve == null) {
                        try {
                            int idRecherche = Integer.parseInt(nomRecherche);
                            produitTrouve = magasin.trouverProduitParId(idRecherche);
                        } catch (NumberFormatException e) {
                            // On ignore si ce n'est pas un id
                        }
                    }

                    if (produitTrouve != null) {
                        if (produitTrouve.getQuantite() > 0) {
                            produitTrouve.setQuantite(produitTrouve.getQuantite() - 1);
                            panier.ajouterProduit(produitTrouve);
                        } else {
                            System.out.println("Desole, le produit " + produitTrouve.getNom() + " est en rupture de stock.");
                        }
                    } else {
                        System.out.println("Produit introuvable dans le magasin.");
                    }
                    break;

                case 3:
                    panier.afficherPanier();
                    break;

                case 4:
                    if (panier.getProduits().isEmpty()) {
                        System.out.println("Votre panier est vide. Impossible de passer une commande.");
                    } else {
                        Commande commande = new Commande(idCommande, client, panier);
                        idCommande++;
                        System.out.println("Commande passee avec succes !");
                        commande.afficherDetailsCommande();
                        panier.viderPanier();
                    }
                    break;

                case 5:
                    System.out.println("Merci pour votre visite. A bientot !");
                    continuer = false;
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 5.");
                    break;
            }
        }

        scanner.close();
    }
}
