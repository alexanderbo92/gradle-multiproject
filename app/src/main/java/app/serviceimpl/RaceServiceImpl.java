package app.serviceimpl;

import app.model.Race;
import app.repository.IRaceRepository;
import app.service.IRaceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RaceServiceImpl implements IRaceService {

  @Autowired private IRaceRepository dRace;

  @Override
  @Transactional
  public boolean registrar(Race race) {
    Race objRace = dRace.save(race);
    if (objRace == null) return false;
    else return true;
  }

  @Override
  @Transactional
  public void eliminar(int idRace) {
    dRace.deleteById(idRace);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Race> listarId(int idRace) {
    return dRace.findById(idRace);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Race> listar() {
    return dRace.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Race> buscarNombre(String nameRace) {
    return dRace.buscarNombre(nameRace);
  }
}
