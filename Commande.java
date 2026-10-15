package gestionMagasin;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int idCommande;
    private Client client;
    private ArrayList<Produit> produitsCommandes;
    private double total;

    // Compteur statique pour generer automatiquement les identifiants
    private static int compteur = 1;

    // Constructeur par defaut
    public Commande() {
        this.idCommande = compteur++;
        this.produitsCommandes = new ArrayList<>();
        this.total = 0.0;
    }

    public Commande(Client client, Panier panier) {
        this.idCommande = compteur++;
        this.client = client;
        if (panier != null) {
            this.produitsCommandes = new ArrayList<>(panier.getProduits());
            this.total = panier.calculerTotal();
        } else {
            this.produitsCommandes = new ArrayList<>();
            this.total = 0.0;
        }
    }


    public Commande(int idCommande, Client client, Panier panier) {
        this.idCommande = idCommande;
        if (idCommande >= compteur) {
            compteur = idCommande + 1;
        }
        this.client = client;
        if (panier != null) {
            this.produitsCommandes = new ArrayList<>(panier.getProduits());
            this.total = panier.calculerTotal();
        } else {
            this.produitsCommandes = new ArrayList<>();
            this.total = 0.0;
        }
    }

    public Commande(Client client, List<Produit> produitsCommandes) {
        this.idCommande = compteur++;
        this.client = client;
        if (produitsCommandes != null) {
            this.produitsCommandes = new ArrayList<>(produitsCommandes);
            this.total = calculerSomme(this.produitsCommandes);
        } else {
            this.produitsCommandes = new ArrayList<>();
            this.total = 0.0;
        }
    }

    public Commande(int idCommande, Client client, List<Produit> produitsCommandes) {
        this.idCommande = idCommande;
        if (idCommande >= compteur) {
            compteur = idCommande + 1;
        }
        this.client = client;
        if (produitsCommandes != null) {
            this.produitsCommandes = new ArrayList<>(produitsCommandes);
            this.total = calculerSomme(this.produitsCommandes);
        } else {
            this.produitsCommandes = new ArrayList<>();
            this.total = 0.0;
        }
    }

    public Commande(int idCommande, Client client, List<Produit> produitsCommandes, double total) {
        this.idCommande = idCommande;
        if (idCommande >= compteur) {
            compteur = idCommande + 1;
        }
        this.client = client;
        this.produitsCommandes = (produitsCommandes != null) ? new ArrayList<>(produitsCommandes) : new ArrayList<>();
        this.total = Math.round(total * 100.0) / 100.0;
    }

    private double calculerSomme(List<Produit> liste) {
        double somme = 0.0;
        if (liste != null) {
            for (Produit p : liste) {
                if (p != null) {
                    somme += p.getPrix();
                }
            }
        }
        return Math.round(somme * 100.0) / 100.0;
    }

    // Getters et setters
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
        if (idCommande >= compteur) {
            compteur = idCommande + 1;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Produit> getProduitsCommandes() {
        return produitsCommandes;
    }

    public void setProduitsCommandes(List<Produit> produitsCommandes) {
        if (produitsCommandes != null) {
            this.produitsCommandes = new ArrayList<>(produitsCommandes);
            this.total = calculerSomme(this.produitsCommandes);
        } else {
            this.produitsCommandes = new ArrayList<>();
            this.total = 0.0;
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = Math.round(total * 100.0) / 100.0;
    }

    public void afficherDetailsCommande() {
        System.out.println("Commande No: " + idCommande);
        if (client != null) {
            System.out.println("Client: " + client.getNom() + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Client: Non specifie");
        }
        System.out.println("Produits commandes :");
        if (produitsCommandes == null || produitsCommandes.isEmpty()) {
            System.out.println("  (Aucun produit)");
        } else {
            for (Produit p : produitsCommandes) {
                if (p != null) {
                    System.out.println("  - " + p.getNom() + " : " + p.getPrix() + " EUR");
                }
            }
        }
        System.out.println("Montant total : " + total + " EUR");
        System.out.println("=================================");
    }
}
