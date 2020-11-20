package co.vacunaController.fabrica;

import co.vacunaController.command.VacunaCommand;
import co.vacunaController.entity.VacunaEntity;
import co.vacunaController.model.Vacuna;
import co.vacunaController.model.exception.BussinessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacunaFabrica {
    public Vacuna entityToModel(VacunaEntity vacunaEntity) throws BussinessException {
        Vacuna vacuna = new Vacuna.VacunaBuilder()
                .setIdVacuna(vacunaEntity.getNombre())
                .setNombre(vacunaEntity.getNombre())
                .setFechaCaducidad(vacunaEntity.getFechaCaducidad())
                .build();
        return vacuna;
    }
    public VacunaCommand entityToCommand(VacunaEntity vacunaEntity) throws BussinessException{
        VacunaCommand vacunaCommand = new VacunaCommand();
        vacunaCommand.setIdVacuna(vacunaEntity.getIdVacuna());
        vacunaCommand.setNombre(vacunaEntity.getNombre());
        vacunaCommand.setFechaCaducidad(vacunaEntity.getFechaCaducidad());
        return vacunaCommand;
    }
    public VacunaEntity commandToEntity(VacunaCommand vacunaCommand)throws BussinessException{
        VacunaEntity vacunaEntity = new VacunaEntity();
        vacunaEntity.setIdVacuna(vacunaCommand.getIdVacuna());
        vacunaEntity.setNombre(vacunaCommand.getNombre());
        vacunaEntity.setFechaCaducidad(vacunaCommand.getFechaCaducidad());
        return vacunaEntity;
    }
    public List<VacunaCommand> entityToCommand(List<VacunaEntity> listaVacunaEntity) throws BussinessException {
        List<VacunaCommand> listaVacunaCommand = new ArrayList<>();
        listaVacunaEntity.forEach(e-> {
            try {
                listaVacunaCommand.add(entityToCommand(e));
            } catch (BussinessException exception) {
                exception.printStackTrace();
            }
        });
        return listaVacunaCommand;
    }
}