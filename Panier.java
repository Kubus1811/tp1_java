package gestionMagasin;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private ArrayList<Produit> produits;

    public Panier() {
        this.produits = new ArrayList<>();
    }

    public Panier(List<Produit> produits) {
        if (produits != null) {
            this.produits = new ArrayList<>(produits);
        } else {
            this.produits = new ArrayList<>();
        }
    }

    public void ajouterProduit(Produit produit) {
        if (produit != null) {
            produits.add(produit);
            System.out.println("Produit " + produit.getNom() + " ajoute au panier.");
        } else {
            System.out.println("Erreur : Produit invalide.");
        }
    }

    public void supprimerProduit(Produit produit) {
        if (produit == null) {
            System.out.println("Erreur : Produit invalide.");
            return;
        }
        if (produits.remove(produit)) {
            System.out.println("Produit " + produit.getNom() + " supprime du panier.");
        } else {
            System.out.println("Le produit n'a pas ete trouve dans le panier.");
        }
    }

    public void afficherPanier() {
        if (produits == null || produits.isEmpty()) {
            System.out.println("Le panier est vide.");
            return;
        }
        System.out.println("--- Contenu du Panier ---");
        for (int i = 0; i < produits.size(); i++) {
            Produit p = produits.get(i);
            if (p != null) {
                System.out.println((i + 1) + ". " + p.getNom() + " - " + p.getPrix() + " EUR");
            }
        }
        System.out.println("Total : " + calculerTotal() + " EUR");
    }

    public double calculerTotal() {
        double total = 0.0;
        if (produits != null) {
            for (Produit p : produits) {
                if (p != null) {
                    total += p.getPrix();
                }
            }
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public void viderPanier() {
        if (produits != null) {
            produits.clear();
        }
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        if (produits != null) {
            this.produits = new ArrayList<>(produits);
        } else {
            this.produits = new ArrayList<>();
        }
    }
}
