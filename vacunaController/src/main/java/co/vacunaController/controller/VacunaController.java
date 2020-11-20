package co.vacunaController.controller;

import co.vacunaController.command.VacunaCommand;
import co.vacunaController.entity.VacunaEntity;
import co.vacunaController.fabrica.VacunaFabrica;
import co.vacunaController.servicio.VacunaService;
import co.vacunaController.util.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacuna")
public class VacunaController{
    @Autowired
    private VacunaService vacunaService;
    @Autowired
    private VacunaFabrica vacunaFabrica;

    @PostMapping("/registro")
    public String registrarIngreso(@RequestBody VacunaCommand vacunaCommand){

        if(vacunaService.findById(vacunaCommand.getIdVacuna())==null){
            return vacunaService.registrarVacuna(vacunaCommand);
        }else {
            return Mensajes.REGISTRO_VACUNA_NO_EXISTOSO;
        }

    }
    @GetMapping("/listar")
    public List<VacunaCommand> listarVacunas(){
        return vacunaService.listarVacunas();
    }

    @GetMapping("/buscar/{id}")
    public VacunaCommand findById(@PathVariable String id){
        return vacunaFabrica.entityToCommand(vacunaService.findById(id));
    }
}