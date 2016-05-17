/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ciudad;

/**
 *
 * @author AuxSala
 */
@Local
public interface CiudadLogicaLocal {
    
    public void registrarCiudad(Ciudad ciudad) throws Exception;
    public List<Ciudad> consultarCiudades() throws Exception;
    public String importarCiudades(String archivo) throws Exception;
}
