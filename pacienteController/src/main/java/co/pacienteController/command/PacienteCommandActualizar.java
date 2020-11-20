package co.pacienteController.command;

import lombok.Data;

@Data
public class PacienteCommandActualizar {

    private String nombre;
    private String especie;
    private String raza;
    private String nombreDueno;
    private Long telefono;
}
