package org.example.clases.empleado;

import org.example.clases.Persona;

import javax.swing.*;

public class Empleado extends Persona {

    private String coidgoDelEmpleado;
    private int numeroDeHorasExtras;
    private String fechaDeIngreso;
    private String area;
    private String cargo;

    @Override
    public void registrarDatos() throws Exception{
        super.registrarDatos();

        coidgoDelEmpleado= JOptionPane.showInputDialog("Ingrese el codigo del empleado");
        numeroDeHorasExtras=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
        fechaDeIngreso=JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aaaa)");
        cargo=JOptionPane.showInputDialog("Ingrese el cargo");

    }
    @Override
    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);

        datos="Codigo de empleado: "+coidgoDelEmpleado+"\n";
        datos+="Numero de horas extras: "+numeroDeHorasExtras+"\n";
        datos+="Fecha de ingreso: "+fechaDeIngreso+"\n";
        datos+="Area: "+area+"\n";
        datos+="Cargo: "+cargo+"\n";

        System.out.println(datos);
    }

    public String getCoidgoDelEmpleado() {
        return coidgoDelEmpleado;
    }

    public void setCoidgoDelEmpleado(String coidgoDelEmpleado) {
        this.coidgoDelEmpleado = coidgoDelEmpleado;
    }

    public int getNumeroDeHorasExtras() {
        return numeroDeHorasExtras;
    }

    public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
        this.numeroDeHorasExtras = numeroDeHorasExtras;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
