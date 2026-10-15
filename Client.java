package gestionMagasin;

public class Client {
    private int id;
    private String nom;
    private String email;

    public Client() {
    }

    // Constructeur pour initialiser les attributs
    public Client(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }
            




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void afficherDetails() {
        System.out.println("Client ID: " + id + " | Nom: " + nom + " | Email: " + email);
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", nom=" + nom + ", email=" + email + "]";
    }

    // Redefinition de equals et hashCode pour comparer les clients par leur id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Client other = (Client) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
