package co.historicoVacuna.restclient;

import co.historicoVacuna.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio.paciente")
public interface PacienteRestClient {
    @GetMapping("/paciente/buscar/{id}")
    PacienteDTO findById(@PathVariable String id);
}
