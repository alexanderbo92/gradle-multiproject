package app.service;

import app.model.Dueno;
import java.util.List;
import java.util.Optional;

public interface IDuenoService {
  public boolean registrar(Dueno dueno);

  public void eliminar(int idDueno);

  public Optional<Dueno> listarId(int idDueno);

  List<Dueno> listar();
}
