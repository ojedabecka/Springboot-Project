package br.com.gerenciamentoprojetos.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gerenciamentoprojetos.model.Usuario;

public interface Usuariorespository extends JpaRepository<Usuario, Long>{
    public List findByNome(String nome);
    public List findByNomeNot(String nome);

}