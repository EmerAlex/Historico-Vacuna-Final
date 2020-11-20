package co.pacienteController.controller;

import co.pacienteController.command.PacienteCommand;
import co.pacienteController.command.PacienteCommandActualizar;
import co.pacienteController.fabrica.PacienteFabrica;
import co.pacienteController.servicio.PacienteService;
import co.pacienteController.util.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteFabrica pacienteFabrica;

    @GetMapping("/listar")
    public List<PacienteCommand> findAll(){
        return pacienteService.listaPacientes();
    }

    @GetMapping("/buscar/{id}")
    public PacienteCommand findById(@PathVariable String id){
           return pacienteFabrica.entityToCommand(pacienteService.findById(id));
    }
    @PostMapping("/registrar")
    public String registrar(@RequestBody PacienteCommand pacienteCommand){
       if(pacienteService.findById(pacienteCommand.getIdPaciente())==null) {
           return pacienteService.registrarPaciente(pacienteCommand);
       }else {
           return Mensajes.REGISTRO_PACIENTE_NO_EXITOSO;
       }
    }
    @PostMapping("/actualizar/{id}")
    public  String actualizar(@PathVariable String id, @RequestBody PacienteCommandActualizar pacienteCommandActualizar){
        return pacienteService.actualizarPaciente(id, pacienteCommandActualizar);
    }
}
