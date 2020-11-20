package co.pacienteController.fabrica;

import co.pacienteController.command.PacienteCommand;
import co.pacienteController.command.PacienteCommandActualizar;
import co.pacienteController.entity.PacienteEntity;
import co.pacienteController.model.Paciente;
import co.pacienteController.model.exception.BussinessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteFabrica {
    public Paciente entityToModel(PacienteEntity pacienteEntity) throws BussinessException {
        Paciente paciente = new Paciente.PacienteBuilder()
                .setIdPaciente(pacienteEntity.getIdPaciente())
                .setTelefono(pacienteEntity.getTelefono())
                .setRaza(pacienteEntity.getRaza())
                .setEspecie(pacienteEntity.getEspecie())
                .setNombre(pacienteEntity.getNombre())
                .setNombreDueno(pacienteEntity.getNombreDueno())
                .build();
        return paciente;
    }
    public PacienteEntity commandaToEntity(PacienteCommand pacienteCommand) throws BussinessException{
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setIdPaciente(pacienteCommand.getIdPaciente());
        pacienteEntity.setNombre(pacienteCommand.getNombre());
        pacienteEntity.setEspecie(pacienteCommand.getEspecie());
        pacienteEntity.setNombreDueno(pacienteCommand.getNombreDueno());
        pacienteEntity.setRaza(pacienteCommand.getRaza());
        pacienteEntity.setTelefono(pacienteCommand.getTelefono());
        return pacienteEntity;
    }
    public  PacienteEntity commandActualizarToEntity(String id, PacienteCommandActualizar pacienteCommandActualizar){
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setIdPaciente(id);
        pacienteEntity.setNombre(pacienteCommandActualizar.getNombre());
        pacienteEntity.setEspecie(pacienteCommandActualizar.getEspecie());
        pacienteEntity.setNombreDueno(pacienteCommandActualizar.getNombreDueno());
        pacienteEntity.setRaza(pacienteCommandActualizar.getRaza());
        pacienteEntity.setTelefono(pacienteCommandActualizar.getTelefono());
        return pacienteEntity;
    }
    public PacienteCommand entityToCommand(PacienteEntity pacienteEntity) throws BussinessException{
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setIdPaciente(pacienteEntity.getIdPaciente());
        pacienteCommand.setEspecie(pacienteEntity.getEspecie());
        pacienteCommand.setNombre(pacienteEntity.getNombre());
        pacienteCommand.setNombreDueno(pacienteEntity.getNombreDueno());
        pacienteCommand.setRaza(pacienteEntity.getRaza());
        pacienteCommand.setTelefono(pacienteEntity.getTelefono());
        return pacienteCommand;
    }
    public List<PacienteCommand> entityToCommand(List<PacienteEntity> listaPacienteEntity) throws BussinessException{
        List<PacienteCommand> listaPacienteCommand = new ArrayList<>();
        listaPacienteEntity.forEach(e-> {
            try {
                listaPacienteCommand.add(entityToCommand(e));
            } catch (BussinessException exception) {
                exception.printStackTrace();
            }
        });
        return listaPacienteCommand;
    }
}
