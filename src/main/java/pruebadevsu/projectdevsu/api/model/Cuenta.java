package pruebadevsu.projectdevsu.api.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroCuenta;

    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
