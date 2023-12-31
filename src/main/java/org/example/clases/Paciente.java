package org.example.clases;

import javax.swing.*;
import java.util.ArrayList;

public class Paciente extends  Persona{

    private int numeroHistoriaClinica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;

    @Override
    public void registrarDatos() throws Exception{
        super.registrarDatos();

        listaMedicamentosAlergico = new ArrayList<String>();
        numeroHistoriaClinica=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia clinica"));
        sexo=JOptionPane.showInputDialog("Ingrese el sexo");
        grupoSanguineo=JOptionPane.showInputDialog("Ingrese el grupo sanguineo");

        String pregunta=JOptionPane.showInputDialog("¿Es alergico a algun medicamento? Ingrrese si o no");

        if(pregunta.equalsIgnoreCase("si")){
            String medicamento="";
            String continuar="";
            do{
                medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
                listaMedicamentosAlergico.add(medicamento);

                continuar=JOptionPane.showInputDialog("Ingrese sí, si desea continuar");

            }while(continuar.equalsIgnoreCase("si"));
        }
    }

    @Override
    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);

        datos="Numero historia clinica "+numeroHistoriaClinica+"\n";
        datos+="Sexo: "+sexo+"\n";
        datos+="Grupo sanguineo: "+grupoSanguineo+"\n";

        if(listaMedicamentosAlergico.size()>0){
            datos+="Lista de medicamentos a los que es alergico\n";
            for(int i=0;i<listaMedicamentosAlergico.size();i++){
                datos+="\t"+listaMedicamentosAlergico.get(i)+"\n";
            }

        }else {
            datos="El paciente, no es alergico a ningún medicamento";
        }
        System.out.println(datos);
    }

    public int getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<String> getListaMedicamentosAlergico() {
        return listaMedicamentosAlergico;
    }

    public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) {
        this.listaMedicamentosAlergico = listaMedicamentosAlergico;
    }
}
