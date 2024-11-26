package servico;

import modelos.Artista;
import modelos.Faixa;
import modelos.Disco;

import java.util.List;

public interface ICatalogoServico {
    void cadastrarDisco(String titulo, int ano, Artista artista, List<Faixa> faixas);
    void listarDiscos();
    void editarDisco(String tituloAntigo, String novoTitulo, int anoNovo);
    void removerDisco(String titulo);

}
