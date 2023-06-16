package org.example.clases.empleado;

import javax.swing.*;

public class Medico extends EmpleadoPlanilla{

    private String especialidad;;
    private int numeroDeConsultorio;

    @Override
    public void registrarDatos() throws Exception {
        super.registrarDatos();

        especialidad= JOptionPane.showInputDialog("Ingrese su especialidad");
        numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Numero de consultorio"));

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroDeConsultorio() {
        return numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(int numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }
}
