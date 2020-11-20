package co.historicoVacuna.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VacunaDTO {

    private String idVacuna;
    private String nombre;
    private Date fechaCaducidad;

}