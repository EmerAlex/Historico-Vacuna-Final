package co.vacunaController.command;

import lombok.Data;

import java.util.Date;

@Data
public class VacunaCommand {
    private String idVacuna;
    private String nombre;
    private Date fechaCaducidad;
}
