package co.pacienteController.servicio.implementacion;

import co.pacienteController.command.PacienteCommand;
import co.pacienteController.command.PacienteCommandActualizar;
import co.pacienteController.entity.PacienteEntity;
import co.pacienteController.fabrica.PacienteFabrica;
import co.pacienteController.model.Paciente;
import co.pacienteController.repository.PacienteRepository;
import co.pacienteController.servicio.PacienteService;
import co.pacienteController.util.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteFabrica pacienteFabrica;

    @Override
    public String registrarPaciente(PacienteCommand pacienteCommand) {
        pacienteRepository.save(pacienteFabrica.commandaToEntity(pacienteCommand));
        return Mensajes.REGISTRO_PACIENTE_EXITOSO;
    }

    @Override
    public PacienteEntity findById(String id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<PacienteCommand> listaPacientes() {
        return pacienteFabrica.entityToCommand(pacienteRepository.findAll());
    }


    @Override
    public String actualizarPaciente(String id, PacienteCommandActualizar pacienteCommandActualizar) {
        String mensaje = Mensajes.ACTUALIZACION_PACIENTE_RECHAZADA;
        if(pacienteRepository.findById(id)!=null){
            PacienteEntity pacienteEntity = pacienteFabrica.commandActualizarToEntity(id, pacienteCommandActualizar);
            pacienteRepository.save(pacienteEntity);
            mensaje = Mensajes.ACTUALIZACION_PACIENTE_EXITOSA;
        }
        return mensaje;
    }
}
