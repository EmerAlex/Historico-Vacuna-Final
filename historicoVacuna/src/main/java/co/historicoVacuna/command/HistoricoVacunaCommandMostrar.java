package co.historicoVacuna.command;

import lombok.Data;

import java.util.Date;
@Data
public class HistoricoVacunaCommandMostrar {
    private String idHistorico;
    private String idPaciente;
    private String idVacuna;
    private Date fechaAplicación;
    private String nombreMascota;
    private String nombreDueno;
    private String nombreVacuna;
}
