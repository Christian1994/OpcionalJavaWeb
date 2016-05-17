/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Empleado;
import persistencia.EmpleadoFacadeLocal;

/**
 *
 * @author AuxSala
 */
@Stateless
public class EmpleadoLogica implements EmpleadoLogicaLocal {

    @EJB
    EmpleadoFacadeLocal empleadoDAO;
    
    @Override
    public void registrarEmpleado(Empleado empleado) throws Exception {
        
        // Campo Código Empleado se validará en la Vista Empleado.
        
        if(empleado.getNombre().equals("")){
            throw new Exception("Campo Nombre Empleado Obligatorio.");
        }
        if(empleado.getApellido().equals("")){
            throw new Exception("Campo Apellido Empleado Obligatorio.");
        }
        if(empleado.getDireccion().equals("")){
            throw new Exception("Campo Dirección Empleado Obligatorio.");
        }
        
        // Campo Teléfono Empleado se validará en la Vista Empleado.
        
        if(empleado.getEmail().equals("")){
            throw new Exception("Campo E-mail Empleado Obligatorio.");
        }
        
        // Campo Edad Empleado se validará en la Vista Empleado.
        
        if(empleado.getIdcargo().getIdcargo() == null){
            throw new Exception("Debes seleccionar el cargo al que el Empleado va a asociarse.");
        }
        if(empleado.getIdciudad().getIdciudad() == null){
            throw new Exception("Debes seleccionar la ciudad en el que el Empleado vive.");
        }
        
        Empleado objEmpleado = empleadoDAO.find(empleado.getIdcargo());
        if(objEmpleado != null){
            throw new Exception("Empleado ya existe.");
        }
        else{
            empleadoDAO.create(empleado);
        }
    }

    @Override
    public void modificarEmpelado(Empleado empleado) throws Exception {
        
        // Campo Código Empleado se validará en la Vista Empleado.
        
        if(empleado.getNombre().equals("")){
            throw new Exception("Campo Nombre Empleado Obligatorio.");
        }
        if(empleado.getApellido().equals("")){
            throw new Exception("Campo Apellido Empleado Obligatorio.");
        }
        if(empleado.getDireccion().equals("")){
            throw new Exception("Campo Dirección Empleado Obligatorio.");
        }
        
        // Campo Teléfono Empleado se validará en la Vista Empleado.
        
        if(empleado.getEmail().equals("")){
            throw new Exception("Campo E-mail Empleado Obligatorio.");
        }
        
        // Campo Edad Empleado se validará en la Vista Empleado.
        
        if(empleado.getIdcargo().getIdcargo() == null){
            throw new Exception("Debes seleccionar el cargo al que el Empleado va a asociarse.");
        }
        if(empleado.getIdciudad().getIdciudad() == null){
            throw new Exception("Debes seleccionar la ciudad en el que el Empleado vive.");
        }
        
        Empleado objEmpleado = empleadoDAO.find(empleado.getIdcargo());
        if(objEmpleado == null){
            throw new Exception("Empleado a modificar no existe.");
        }
        else{
            objEmpleado.setNombre(empleado.getNombre());
            objEmpleado.setApellido(empleado.getApellido());
            objEmpleado.setDireccion(empleado.getDireccion());
            objEmpleado.setTelefono(empleado.getTelefono());
            objEmpleado.setEmail(empleado.getEmail());
            objEmpleado.setEdad(empleado.getEdad());
            objEmpleado.setIdcargo(empleado.getIdcargo());
            objEmpleado.setIdciudad(empleado.getIdciudad());
            empleadoDAO.edit(empleado);
        }
    }

    @Override
    public List<Empleado> consultarEmpleados() throws Exception {
        return empleadoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
