package app.repository;

import app.model.Race;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRaceRepository extends JpaRepository<Race, Integer> {
  @Query("from Race r where r.nameRace like %:nameRace%")
  List<Race> buscarNombre(@Param("nameRace") String nameRace);
}
