package app.serviceimpl;

import app.model.Dueno;
import app.repository.IDuenoRepository;
import app.service.IDuenoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DuenoServiceImpl implements IDuenoService {

  @Autowired private IDuenoRepository dDueno;

  @Override
  @Transactional
  public boolean registrar(Dueno dueno) {
    Dueno objDueno = dDueno.save(dueno);
    if (objDueno == null) return false;
    else return true;
  }

  @Override
  @Transactional
  public void eliminar(int idDueno) {
    dDueno.deleteById(idDueno);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Dueno> listarId(int idDueno) {
    return dDueno.findById(idDueno);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Dueno> listar() {
    return dDueno.findAll();
  }
}
