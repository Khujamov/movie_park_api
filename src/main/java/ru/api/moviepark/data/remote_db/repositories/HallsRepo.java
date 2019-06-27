package ru.api.moviepark.data.remote_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.api.moviepark.data.remote_db.entities.HallsEntity;
import ru.api.moviepark.data.remote_db.entities.HallsEntityId;

import java.util.Optional;

public interface HallsRepo extends JpaRepository<HallsEntity, HallsEntityId> {

    @Query(value = "SELECT CASE WHEN count(e.hallId)> 0 then true else false end " +
            "from HallsEntity e where e.hallId = :id")
    Optional<Boolean> checkIdExists(@Param("id") int income_id);
}
