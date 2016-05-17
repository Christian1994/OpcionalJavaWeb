/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Cargo;

/**
 *
 * @author AuxSala
 */
@Local
public interface CargoLogicaLocal {

    public void modificarCargo(Cargo cargo) throws Exception;
    public void eliminarCargo(Cargo cargo) throws Exception;
    public List<Cargo> consultarCargos() throws Exception;
    
}
