package co.pacienteController.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data


@Document(collection = "Usuarios")
public class PacienteEntity {
    @Id
    private String idPaciente;
    private String nombre;
    private String especie;
    private String raza;
    private String nombreDueno;
    private Long telefono;
}
