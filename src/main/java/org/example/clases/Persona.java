package org.example.clases;

import javax.swing.*;

public class Persona {

    private String numeroDeDni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private String ciudadProcedencia;

    public void imprimirDatosPersona(String datos){
        datos+="Nombre: "+nombre+"\n";
        datos+="Apellido: "+apellido+"\n";
        datos+="Fecha de nacimiento: "+fechaNacimiento+"\n";
        datos+="Direccion: "+direccion+"\n";
        datos+="Ciudad de procedencia: "+ciudadProcedencia+"\n";

        System.out.println(datos);
    }
    public void registrarDatos() throws Exception {
        try {
            numeroDeDni = JOptionPane.showInputDialog("Ingrese el numero del documento");
            nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            apellido = JOptionPane.showInputDialog("Ingrese el apellido");
            fechaNacimiento = JOptionPane.showInputDialog("Ingrese fecha de nacimiento (dd/mm/aaaa)");
            direccion = JOptionPane.showInputDialog("Ingrese la direccion");
            ciudadProcedencia = JOptionPane.showInputDialog("Ingrese la ciudad de procedencia");
        }catch (Exception error){
            throw new Exception("Ingreso un dato incorrecto");
        }

    }

    public String getNumeroDeDni() {
        return numeroDeDni;
    }

    public void setNumeroDeDni(String numeroDeDni) {
        this.numeroDeDni = numeroDeDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }
}
