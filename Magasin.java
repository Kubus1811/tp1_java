package gestionMagasin;

import java.util.ArrayList;
import java.util.List;

public class Magasin {
    private ArrayList<Produit> produits;

    public Magasin() {
        this.produits = new ArrayList<>();
    }

    public Magasin(List<Produit> produits) {
        if (produits != null) {
            this.produits = new ArrayList<>(produits);
        } else {
            this.produits = new ArrayList<>();
        }
    }

    public void ajouterProduit(Produit produit) {
        if (produit != null) {
            produits.add(produit);
        }
    }

    public void afficherProduitsDisponibles() {
        if (produits == null || produits.isEmpty()) {
            System.out.println("Aucun produit n'est disponible dans le magasin.");
            return;
        }
        System.out.println("--- Liste des produits disponibles ---");
        for (Produit p : produits) {
            if (p != null) {
                p.afficherDetails();
            }
        }
    }

    public Produit trouverProduitParNom(String nom) {
        if (nom == null) {
            return null;
        }
        for (Produit p : produits) {
            if (p != null && p.getNom() != null && p.getNom().trim().equalsIgnoreCase(nom.trim())) {
                return p;
            }
        }
        return null;
    }

    public Produit trouverProduitParId(int id) {
        if (produits != null) {
            for (Produit p : produits) {
                if (p != null && p.getId() == id) {
                    return p;
                }
            }
        }
        return null;
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
