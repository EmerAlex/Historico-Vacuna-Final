package co.historicoVacuna.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Data
@Document(collection = "Historico")
public class HistoricoVacunaEntity {
    @Id
    private String idHistorico;
    private String idPaciente;
    private String idVacuna;
    private Date fechaAplicación;

}
