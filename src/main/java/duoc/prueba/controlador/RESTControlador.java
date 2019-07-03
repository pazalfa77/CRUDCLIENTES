package duoc.prueba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import duoc.prueba.dao.ClientesDAO;
import duoc.prueba.modelo.ClientesVO;

@RestController
public class RESTControlador {
    @Autowired
    ClientesDAO dao;
    
    @GetMapping("/")
    
    public List<ClientesVO> lista(){
    	return dao.findAll();
    }
    
   @GetMapping("/cliente/{rut}")
   public ClientesVO listarut(@PathVariable String rut ) {
	   return dao.findById(rut).get();
	         }
   
   @PostMapping("/cliente")
   public boolean insertar(@RequestBody ClientesVO nuevo) {
	   if(!dao.existsById(nuevo.getRut())) {
		   dao.save(nuevo);
		   return true;
		   	   }
	   return false;
               }
   @PutMapping("/cliente")
    public boolean modificar(@RequestBody ClientesVO modif) {
	      if(dao.existsById(modif.getRut())) {
	    	  dao.save(modif);
	    	  return true;
	      }
	          return false;
   }
   
   @DeleteMapping("/cliente/{rut}")
   public boolean eliminar(@PathVariable String rut) {
	       
	   	   if(this.dao.existsById(rut) ) {
		     dao.deleteById(rut);
	   	     return true;
		   		   }
	         return false; 
   }
   
}
