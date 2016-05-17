/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;
import logica.CargoLogicaLocal;
import logica.CiudadLogicaLocal;
import logica.EmpleadoLogicaLocal;
import modelo.Cargo;
import modelo.Ciudad;
import modelo.Empleado;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "empleadoVista")
@Dependent
public class EmpleadoVista {

    @EJB
    private EmpleadoLogicaLocal empleadoLogica;
 
    @EJB
    private CargoLogicaLocal cargoLogica;
    
    @EJB
    private CiudadLogicaLocal ciudadLogica;
    
    private InputText txtIdEmpleado;
    private InputText txtCodigo;
    private InputText txtNombre;
    private InputText txtApellido;
    private InputText txtDireccion;
    private InputText txtTelefono;
    private InputText txtEmail;
    private InputText txtEdad;
    
    private SelectOneMenu cmbCargos;
    private ArrayList<SelectItem> itemsCargos;
    
    private SelectOneMenu cmbCiudades;
    private ArrayList<SelectItem> itemsCiudades;

    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    private List<Empleado> listaEmpleados;
    private Empleado selectedEmpleado;    

    public InputText getTxtIdEmpleado() {
        return txtIdEmpleado;
    }

    public void setTxtIdEmpleado(InputText txtIdEmpleado) {
        this.txtIdEmpleado = txtIdEmpleado;
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(InputText txtEdad) {
        this.txtEdad = txtEdad;
    }

    public SelectOneMenu getCmbCargos() {
        return cmbCargos;
    }

    public void setCmbCargos(SelectOneMenu cmbCargos) {
        this.cmbCargos = cmbCargos;
    }

    public ArrayList<SelectItem> getItemsCargos() {        
        try {
            List<Cargo> listaCargos = cargoLogica.consultarCargos();
            itemsCargos = new ArrayList<>();
            
            for(Cargo c: listaCargos){
                itemsCargos.add(new SelectItem(c.getIdcargo(), c.getDescripcion()));
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsCargos;
    }

    public void setItemsCargos(ArrayList<SelectItem> itemsCargos) {
        this.itemsCargos = itemsCargos;
    }

    public SelectOneMenu getCmbCiudades() {
        return cmbCiudades;
    }

    public void setCmbCiudades(SelectOneMenu cmbCiudades) {
        this.cmbCiudades = cmbCiudades;
    }

    public ArrayList<SelectItem> getItemsCiudades() {
        try {
            List<Ciudad> listaCiudades = ciudadLogica.consultarCiudades();
            itemsCiudades = new ArrayList<>();
            
            for(Ciudad c: listaCiudades){
                itemsCiudades.add(new SelectItem(c.getIdciudad(), c.getNombre()));
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsCiudades;
    }

    public void setItemsCiudades(ArrayList<SelectItem> itemsCiudades) {
        this.itemsCiudades = itemsCiudades;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
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

    public List<Empleado> getListaEmpleados() {
        if(listaEmpleados == null){
            try {
                listaEmpleados = empleadoLogica.consultarEmpleados();
            } catch (Exception ex) {
                Logger.getLogger(EmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleado getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(Empleado selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }

    public void onRowSelect(SelectEvent event){
        this.selectedEmpleado = (Empleado) event.getObject();
        
        this.txtIdEmpleado.setValue(selectedEmpleado.getIdcargo());
        this.txtCodigo.setValue(selectedEmpleado.getCodigo());
        this.txtNombre.setValue(selectedEmpleado.getNombre());
        this.txtApellido.setValue(selectedEmpleado.getApellido());
        this.txtDireccion.setValue(selectedEmpleado.getDireccion());
        this.txtTelefono.setValue(selectedEmpleado.getTelefono());
        this.txtEmail.setValue(selectedEmpleado.getEmail());
        this.txtEdad.setValue(selectedEmpleado.getEdad());
        
        this.cmbCargos.setValue(selectedEmpleado.getIdcargo().getDescripcion());
        this.cmbCiudades.setValue(selectedEmpleado.getCodciudad().getNombre());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtIdEmpleado.setDisabled(true);        
    }

    public void limpiar() {
        this.txtIdEmpleado.setValue("");
        this.txtCodigo.setValue("");
        this.txtNombre.setValue("");
        this.txtApellido.setValue("");
        this.txtDireccion.setValue("");
        this.txtTelefono.setValue("");
        this.txtEmail.setValue("");
        this.txtEdad.setValue("");
        
        this.cmbCargos.setValue("");
        this.cmbCiudades.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);
        
        this.txtIdEmpleado.setDisabled(false);
    }    

    public void action_registrar(){
        try {
            Cargo objCargo = new Cargo();
            try { objCargo.setIdcargo(Integer.parseInt(this.cmbCargos.getValue().toString())); } catch(Exception ex) {}
            Ciudad objCiudad = new Ciudad();
            try { objCiudad.setIdciudad(this.cmbCiudades.getValue().toString()); } catch(Exception ex) {}
            Empleado objEmpleado = new Empleado();
            objEmpleado.setIdempleado(Integer.parseInt(txtIdEmpleado.getValue().toString()));
            objEmpleado.setCodigo(Integer.parseInt(txtCodigo.getValue().toString()));
            objEmpleado.setNombre(txtNombre.getValue().toString());
            objEmpleado.setApellido(txtApellido.getValue().toString());
            objEmpleado.setIdcargo(objCargo);
            objEmpleado.setDireccion(txtDireccion.getValue().toString());
            objEmpleado.setTelefono(txtTelefono.getValue().toString());
            objEmpleado.setEmail(txtEmail.getValue().toString());
            objEmpleado.setCodciudad(objCiudad);
            objEmpleado.setEdad(Integer.parseInt(txtEdad.getValue().toString()));
            empleadoLogica.registrarEmpleado(objEmpleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void action_modificar(){
        try {
            Cargo objCargo = new Cargo();
            try { objCargo.setIdcargo(Integer.parseInt(this.cmbCargos.getValue().toString())); } catch(Exception ex) {}
            Ciudad objCiudad = new Ciudad();
            try { objCiudad.setIdciudad(this.cmbCiudades.getValue().toString()); } catch(Exception ex) {}
            Empleado objEmpleado = new Empleado();
            objEmpleado.setIdempleado(Integer.parseInt(txtIdEmpleado.getValue().toString()));
            objEmpleado.setCodigo(Integer.parseInt(txtCodigo.getValue().toString()));
            objEmpleado.setNombre(txtNombre.getValue().toString());
            objEmpleado.setApellido(txtApellido.getValue().toString());
            objEmpleado.setIdcargo(objCargo);
            objEmpleado.setDireccion(txtDireccion.getValue().toString());
            objEmpleado.setTelefono(txtTelefono.getValue().toString());
            objEmpleado.setEmail(txtEmail.getValue().toString());
            objEmpleado.setCodciudad(objCiudad);
            objEmpleado.setEdad(Integer.parseInt(txtEdad.getValue().toString()));
            empleadoLogica.modificarEmpleado(objEmpleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
    
    /**
     * Creates a new instance of EmpleadoVista
     */
    public EmpleadoVista() {
    }
    
}
