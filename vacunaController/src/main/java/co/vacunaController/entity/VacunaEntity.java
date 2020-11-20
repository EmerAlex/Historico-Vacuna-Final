package co.vacunaController.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Vacunas")
public class VacunaEntity {
    @Id
    private String idVacuna;
    private String nombre;
    private Date fechaCaducidad;
}