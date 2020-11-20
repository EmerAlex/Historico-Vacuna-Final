package co.pacienteController.servicio;

import co.pacienteController.command.PacienteCommand;
import co.pacienteController.command.PacienteCommandActualizar;
import co.pacienteController.entity.PacienteEntity;
import co.pacienteController.model.Paciente;

import java.util.List;

public interface PacienteService {
    String registrarPaciente(PacienteCommand pacienteCommand);
    PacienteEntity findById(String id);
    List<PacienteCommand> listaPacientes ();
    String actualizarPaciente(String id, PacienteCommandActualizar pacienteCommandActualizar);
}
