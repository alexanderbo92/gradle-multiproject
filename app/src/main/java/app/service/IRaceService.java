package app.service;

import app.model.Race;
import java.util.List;
import java.util.Optional;

public interface IRaceService {
  public boolean registrar(Race race);

  public void eliminar(int idRace);

  public Optional<Race> listarId(int idRace);

  List<Race> listar();

  List<Race> buscarNombre(String nameRace);
}
