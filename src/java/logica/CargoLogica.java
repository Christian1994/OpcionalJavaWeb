/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Cargo;
import persistencia.CargoFacadeLocal;

/**
 *
 * @author AuxSala
 */
@Stateless
public class CargoLogica implements CargoLogicaLocal {

    @EJB
    CargoFacadeLocal cargoDAO;
    
    @Override
    public void modificarCargo(Cargo cargo) throws Exception {
        if(cargo.getIdcargo().equals("")){
            throw new Exception("Campo ID Cargo Obligatorio.");
        }
        if(cargo.getDescripcion().equals("")){
            throw new Exception("Campo Descripción Cargo Obligatorio.");
        }
        // Campo Salario Cargo se validará en la Vista de Cargo.
        
        Cargo objCargo = cargoDAO.find(cargo.getIdcargo());
        if(objCargo == null){
            throw new Exception("Cargo a modificar no existe.");
        }
        else{
            objCargo.setDescripcion(cargo.getDescripcion());
            objCargo.setSalario(cargo.getSalario());
            cargoDAO.edit(cargo);
        }
    }

    @Override
    public void eliminarCargo(Cargo cargo) throws Exception {
        Cargo objCargo = cargoDAO.find(cargo.getIdcargo());
        if(objCargo == null){
            throw new Exception("Cargo a eliminar no existe.");
        }
        else{
            if(cargo.getEmpleadoList().size() > 0){
                throw new Exception("El Cargo tiene Empleado asociados. Elíminelos primero.");
            }
            cargoDAO.remove(cargo);
        }
    }

    @Override
    public List<Cargo> consultarCargos() throws Exception {
        return cargoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
