package co.vacunaController.repository;

import co.vacunaController.entity.VacunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends MongoRepository<VacunaEntity, String> {
}

