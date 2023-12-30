package ma.project.siteecommerce.entites;


import jakarta.persistence.*;


@Entity

public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String descriptionFacture;
    private Double montant;

    @OneToOne
    private Commande commande;

    public Facture() {
        super();

    }
}
