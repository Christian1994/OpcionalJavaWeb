/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ciudad;
import persistencia.CiudadFacadeLocal;

/**
 *
 * @author AuxSala
 */
@Stateless
public class CiudadLogica implements CiudadLogicaLocal {

    @EJB
    CiudadFacadeLocal ciudadDAO;
    
    @Override
    public void registrarCiudad(Ciudad ciudad) throws Exception {        
        Ciudad objCiudad = ciudadDAO.find(ciudad.getIdciudad());
        if(objCiudad != null){
            throw new Exception("Ciudad ya existe.");
        }
        else{
            ciudadDAO.create(ciudad);
        }
    }

    @Override
    public List<Ciudad> consultarCiudades() throws Exception {
        return ciudadDAO.findAll();
    }

    @Override
    public String importarCiudades(String archivo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
