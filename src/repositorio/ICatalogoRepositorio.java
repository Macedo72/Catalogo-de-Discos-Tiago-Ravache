package repositorio;

import modelos.Disco;
import java.util.List;

public interface ICatalogoRepositorio {
    void addDisco (Disco disco);
    void removeDisco (Disco disco);
    List<Disco> getDiscos();
    Disco buscarDiscoPorTitulo(String titulo);
}
