package org.example.clases.empleado;

import javax.swing.*;

public class EmpleadoPlanilla extends Empleado{

    private double salarioMensual;
    private double procentajeAdicionalPorHoraExtra;


    @Override
    public void registrarDatos() throws Exception{
        super.registrarDatos();

        salarioMensual=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
        procentajeAdicionalPorHoraExtra=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje adicional por hora extra"));

    }

    @Override
    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);
        datos="Salario mensual: "+salarioMensual+"\n";
        datos+="Porcentaje adicional por hora extra: "+procentajeAdicionalPorHoraExtra+"\n";
        datos+="###########################################################\n";
        System.out.println(datos);
    }
    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public double getProcentajeAdicionalPorHoraExtra() {
        return procentajeAdicionalPorHoraExtra;
    }

    public void setProcentajeAdicionalPorHoraExtra(double procentajeAdicionalPorHoraExtra) {
        this.procentajeAdicionalPorHoraExtra = procentajeAdicionalPorHoraExtra;
    }
}
