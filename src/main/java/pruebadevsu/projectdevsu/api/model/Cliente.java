package pruebadevsu.projectdevsu.api.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Cliente extends Persona {
    @Column(unique = true)
    private String clienteId;

    private String contrasena;
    private Boolean estado;
}
