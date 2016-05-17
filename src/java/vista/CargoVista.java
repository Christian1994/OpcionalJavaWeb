/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.CargoLogicaLocal;
import modelo.Cargo;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "cargoVista")
@RequestScoped
public class CargoVista {

    @EJB
    private CargoLogicaLocal cargoLogica;
    
    private InputText txtIdCargo;
    private InputText txtDescripcion;
    private InputText txtSalario;
    
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    private List<Cargo> listaCargos;
    private Cargo selectedCargo;
    
    public InputText getTxtIdCargo() {
        return txtIdCargo;
    }

    public void setTxtIdCargo(InputText txtIdCargo) {
        this.txtIdCargo = txtIdCargo;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtSalario() {
        return txtSalario;
    }

    public void setTxtSalario(InputText txtSalario) {
        this.txtSalario = txtSalario;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public List<Cargo> getListaCargos() {
        if(listaCargos == null){
            try {
                listaCargos = cargoLogica.consultarCargos();
            } catch (Exception ex) {
                Logger.getLogger(CargoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Cargo getSelectedCargo() {
        return selectedCargo;
    }

    public void setSelectedCargo(Cargo selectedCargo) {
        this.selectedCargo = selectedCargo;
    }

    public void onRowSelect(SelectEvent event){
        this.selectedCargo = (Cargo) event.getObject();
        
        this.txtIdCargo.setValue(selectedCargo.getIdcargo());
        this.txtDescripcion.setValue(selectedCargo.getDescripcion());
        this.txtSalario.setValue(selectedCargo.getSalario());
        
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtIdCargo.setDisabled(true);        
    }

    public void limpiar() {
        this.txtIdCargo.setValue("");
        this.txtDescripcion.setValue("");
        this.txtSalario.setValue("");
        
        this.txtIdCargo.setDisabled(false);
    }

    public void action_modificar(){
        try{
            Cargo objCargo = new Cargo();

            try{ objCargo.setIdcargo(Integer.parseInt(this.txtIdCargo.getValue().toString())); }catch(Exception ex){}
            objCargo.setDescripcion(this.txtDescripcion.getValue().toString());
            try{ objCargo.setSalario(Integer.parseInt(this.txtSalario.getValue().toString())); }catch(Exception ex){}
            
            cargoLogica.modificarCargo(objCargo);
            listaCargos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información de modificación del Cargo", 
                    "El Cargo fue modificado con éxito."));
        }
        catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));           
        }
    }
    
    public void action_eliminar(){
        try{
            Cargo objCargo = new Cargo();

            try{ objCargo.setIdcargo(Integer.parseInt(this.txtIdCargo.getValue().toString())); }catch(Exception ex){}            
            objCargo.setDescripcion(this.txtDescripcion.getValue().toString());
            try{ objCargo.setSalario(Integer.parseInt(this.txtSalario.getValue().toString())); }catch(Exception ex){}
            
            cargoLogica.eliminarCargo(objCargo);
            listaCargos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información de eliminación del Cargo", 
                    "El Cargo fue eliminado con éxito."));
        }
        catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));           
        }        
    }
    
    /**
     * Creates a new instance of CargoVista
     */
    public CargoVista() {
    }
    
}
