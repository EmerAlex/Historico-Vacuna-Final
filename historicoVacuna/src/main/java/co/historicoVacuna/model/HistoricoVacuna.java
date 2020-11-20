package co.historicoVacuna.model;

import co.historicoVacuna.model.exception.BussinessException;
import co.historicoVacuna.util.Mensajes;
import co.historicoVacuna.util.Validador;

import java.util.Date;

public class HistoricoVacuna {
    private String idHistorico;
    private String idPaciente;
    private String idVacuna;
    private Date fechaAplicación;

    private HistoricoVacuna (){
        super();
    }

    public static class HistoricoVacunaBuilder{
        private String idHistorico;
        private String idPaciente;
        private String idVacuna;
        private Date fechaAplicación;

        public HistoricoVacunaBuilder setIdHistorico(String idHistorico) {
            this.idHistorico = idHistorico;
            return this;
        }

        public HistoricoVacunaBuilder setIdPaciente(String paciente) {
            this.idPaciente = paciente;
            return this;
        }

        public HistoricoVacunaBuilder setIdVacuna(String vacuna) {
            this.idVacuna = vacuna;
            return this;
        }

        public HistoricoVacunaBuilder setFechaAplicación(Date fechaAplicación) {
            this.fechaAplicación = fechaAplicación;
            return this;
        }
        public HistoricoVacuna build() throws BussinessException {
            HistoricoVacuna historicoVacuna = new HistoricoVacuna();
            Validador.textoNulo(idHistorico, Mensajes.ID_NULO_HISTORICO);
            Validador.textoVacio(idHistorico, Mensajes.ID_CERO_HISTORICO);
            historicoVacuna.idHistorico = idHistorico;
            Validador.textoNulo(idPaciente, Mensajes.PACIENTE_NO_NULO);
            Validador.textoVacio(idPaciente, Mensajes.PACIENTE_NO_NULO);
            historicoVacuna.idPaciente = idPaciente;
            Validador.textoNulo(idVacuna, Mensajes.VACUNA_NO_NULA);
            Validador.textoVacio(idVacuna, Mensajes.VACUNA_NO_NULA);
            historicoVacuna.idVacuna = idVacuna;
            Validador.fechaNula(fechaAplicación, Mensajes.FECHA_APLICACION_NULA);
            historicoVacuna.fechaAplicación = fechaAplicación;
            return historicoVacuna;
        }
    }

    public String getIdHistorico() {
        return idHistorico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdVacuna() {
        return idVacuna;
    }

    public Date getFechaAplicación() {
        return fechaAplicación;
    }
}
