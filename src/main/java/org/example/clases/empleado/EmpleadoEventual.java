package org.example.clases.empleado;

import javax.swing.*;

public class EmpleadoEventual extends Empleado{

    private double honorariosPorHora;
    private String fechaTerminoContrato;

    @Override
    public void registrarDatos() throws Exception{
        super.registrarDatos();

        honorariosPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
        fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese la fecha de terminación de contrato (dd/mm/aaaa");
    }
    @Override
    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);
        datos = "Honorarios por hora "+honorariosPorHora+"\n";
        datos+= "Fecha termino del contrato: "+fechaTerminoContrato+"\n";
        System.out.println(datos);
    }
    public double getHonorariosPorHora() {
        return honorariosPorHora;
    }

    public void setHonorariosPorHora(double honorariosPorHora) {
        this.honorariosPorHora = honorariosPorHora;
    }

    public String getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }
}
