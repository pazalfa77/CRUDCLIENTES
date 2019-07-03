package duoc.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import duoc.prueba.modelo.ClientesVO;

@Repository
public interface ClientesDAO extends JpaRepository<ClientesVO, String>{

}
