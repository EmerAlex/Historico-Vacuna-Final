package co.historicoVacuna.restclient;

import co.historicoVacuna.dto.VacunaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio.vacuna")
public interface VacunaRestClient {
    @GetMapping("/vacuna/buscar/{id}")
    VacunaDTO findById(@PathVariable String id);
}
