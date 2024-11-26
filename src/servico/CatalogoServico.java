package servico;

import modelos.Artista;
import modelos.Disco;
import modelos.Faixa;
import repositorio.ICatalogoRepositorio;

import java.util.List;

public abstract class CatalogoServico implements ICatalogoServico {
    private ICatalogoRepositorio repositorio;

    public CatalogoServico (ICatalogoRepositorio repository) {
        this.repositorio = repository;
    }

    @Override
    public void cadastrarDisco(String titulo, int ano, Artista artista, List<Faixa> faixas) {
        Disco existente = repositorio.buscarDiscoPorTitulo(titulo);
        if (existente != null) {
            System.out.println("Erro: Um disco com esse título já existe");
            return;
        }

        Disco novoDisco = new Disco(titulo, artista, ano, faixas);
        repositorio.addDisco(novoDisco);
        System.out.println("Disco cadastrado com sucesso!");
    }

    @Override
    public void listarDiscos() {
        List<Disco> discos = repositorio.getDiscos();
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado!");
        } else {
            discos.forEach(System.out::println);
        }
    }

    @Override
    public void editarDisco(String tituloAntigo, String novoTitulo, int anoNovo) {
        Disco disco = repositorio.buscarDiscoPorTitulo(tituloAntigo);
        if (disco == null) {
            System.out.println("Erro: Disco não encontrado.");
            return;
        }
        disco.setTitulo(novoTitulo);
        disco.setAno(anoNovo);
        System.out.println("Disco editado com sucesso!");
    }

    @Override
    public void removerDisco(String titulo) {
        Disco disco = repositorio.buscarDiscoPorTitulo(titulo);
        if (disco == null){
            System.out.println("Erro: Disco não encontrado!");
            return;
        }
        repositorio.removeDisco(disco);
        System.out.println("Disco removido com sucesso!");
    }
}