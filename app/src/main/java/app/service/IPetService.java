package app.service;

import app.model.Pet;
import java.util.List;
import java.util.Optional;

public interface IPetService {
  public boolean registrar(Pet pet);

  public void eliminar(int idPet);

  public Optional<Pet> listarId(int idPet);

  public Optional<Pet> buscarId(int idPet);

  List<Pet> listar();

  List<Pet> buscarNombre(String namePet);

  List<Pet> buscarRaza(String nameRace);

  List<Pet> buscarPropietario(String nameDueno);
}
