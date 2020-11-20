package co.historicoVacuna.repository;

import co.historicoVacuna.entity.HistoricoVacunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoVacunaRepository extends MongoRepository<HistoricoVacunaEntity, String> {

}
