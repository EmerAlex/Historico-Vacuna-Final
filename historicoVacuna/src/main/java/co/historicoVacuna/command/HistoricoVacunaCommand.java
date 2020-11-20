package co.historicoVacuna.command;

import lombok.Data;

import java.util.Date;

@Data
public class HistoricoVacunaCommand {
    private String idHistorico;
    private String idPaciente;
    private String idVacuna;
    private Date fechaAplicación;
}
