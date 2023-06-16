package org.example.clases;

import org.example.clases.empleado.EmpleadoEventual;
import org.example.clases.empleado.EmpleadoPlanilla;
import org.example.clases.empleado.Medico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ModeloDatos {

    public HashMap<String, Paciente> pacienteHashMap;
    public HashMap<String, EmpleadoPlanilla> empleadoPlanillaHashMap;
    public HashMap<String, EmpleadoEventual> empleadoEventualHashMap;
    public HashMap<String, Medico> medicoHashMap;
    public ArrayList<CitaMedica> citasList;

    public ModeloDatos(){
        pacienteHashMap = new HashMap<String, Paciente>();
        empleadoPlanillaHashMap = new HashMap<String, EmpleadoPlanilla>();
        empleadoEventualHashMap = new HashMap<String, EmpleadoEventual>();
        medicoHashMap = new HashMap<String, Medico>();
        citasList = new ArrayList<CitaMedica>();
    }

    public void registrarPersona(Paciente miPaciente){
        pacienteHashMap.put(miPaciente.getNumeroDeDni(), miPaciente);
        System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" Satisfactoriamente");
    }
    public void registrarPersona(EmpleadoPlanilla miEmpleadoPlanilla){
        empleadoPlanillaHashMap.put(miEmpleadoPlanilla.getNumeroDeDni(), miEmpleadoPlanilla);
        System.out.println("Se ha registrado el paciente por planilla "+miEmpleadoPlanilla.getNombre()+" Satisfactoriamente");
    }
    public void registrarPersona(EmpleadoEventual miEmpleadoEventual){
        empleadoEventualHashMap.put(miEmpleadoEventual.getNumeroDeDni(), miEmpleadoEventual);
        System.out.println("Se ha registrado el paciente eventual "+miEmpleadoEventual.getNombre()+" Satisfactoriamente");
    }
    public void registrarPersona(Medico miMedico){
        medicoHashMap.put(miMedico.getNumeroDeDni(), miMedico);
        System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
    }

    public void imprimirPacientes(){
        String msj="PACIENTES REGISTRADOS\n";
        Iterator<String> iterador=pacienteHashMap.keySet().iterator();
        if(pacienteHashMap.size()!=0){
            while(iterador.hasNext()){
                String clave = iterador.next();
                pacienteHashMap.get(clave).imprimirDatosPersona(msj);
            }
        }else{
            System.out.println("No hay pacientes registrados");
        }
    }

    public void imprimirEmpleadosEventuales(){
        String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
        if(empleadoEventualHashMap.size()!=0){
        for(String clave: empleadoEventualHashMap.keySet()){
            empleadoEventualHashMap.get(clave).imprimirDatosPersona(msj);
        }}else{
            System.out.println("No hay empleados eventuales registrados");
        }
    }
    public void imprimirEmpleadosPorPlanilla(){
        String msj="EMPLEADOS POR PLANILLA REGISTRADOS\n";
        if(empleadoPlanillaHashMap.size()!=0){
        for(String clave: empleadoPlanillaHashMap.keySet()){
            empleadoPlanillaHashMap.get(clave).imprimirDatosPersona(msj);
            imprimirMedicos();

        }}else{
            System.out.println("No hay empleados por planilla registrados");
        }
    }
    public void imprimirMedicos(){
        String msj="MEDICOS REGISTRADOS\n";
        if(medicoHashMap.size() != 0){
        for(Map.Entry<String, Medico> e:medicoHashMap.entrySet()){
            e.getValue().imprimirDatosPersona(msj);
        }}else {
            System.out.println("No hay medicos registrados");
        }
    }

    public Medico consultarMedicoPorNombre(String nombreMedico){
        for(Medico medico:medicoHashMap.values()){
            if(medico.getNombre().equalsIgnoreCase(nombreMedico)){
                return medico;
            }
        }
        return null;
    }

    public Paciente consultarPacientePorDocumento(String documentoPaciente){
        Paciente miPaciente=null;
        String msj="Paciente";
        if(pacienteHashMap.containsKey(documentoPaciente)){
            miPaciente= pacienteHashMap.get(documentoPaciente);
            pacienteHashMap.get(documentoPaciente).imprimirDatosPersona(msj);
        }

        return miPaciente;
    }
    public Medico consultarMedicoPorDocumento(String documentoMedico){
        Medico miMedico=null;
        String msj="Medico";

        if(medicoHashMap.containsKey(documentoMedico)){
            miMedico= medicoHashMap.get(documentoMedico);
            medicoHashMap.get(documentoMedico).imprimirDatosPersona(msj);
        }

        return miMedico;
    }
    public EmpleadoEventual consultarEmpleadoEventualPorDocumento(String documentoEmpleadoEventual){
        EmpleadoEventual miEmpleado=null;
        String msj="Empleado eventual";

        if(empleadoEventualHashMap.containsKey(documentoEmpleadoEventual)){
            miEmpleado= empleadoEventualHashMap.get(documentoEmpleadoEventual);
            empleadoEventualHashMap.get(documentoEmpleadoEventual).imprimirDatosPersona(msj);
        }

        return miEmpleado;
    }
    public EmpleadoPlanilla consultarEmpleadoPlanillaPorDocumento(String documentoEmpleadoPlanilla){
        EmpleadoPlanilla miEmpleado=null;
        String msj="Empleado planilla";

        if(empleadoPlanillaHashMap.containsKey(documentoEmpleadoPlanilla)){
            miEmpleado= empleadoPlanillaHashMap.get(documentoEmpleadoPlanilla);
            empleadoPlanillaHashMap.get(documentoEmpleadoPlanilla).imprimirDatosPersona(msj);
        }

        return miEmpleado;
    }


    public void registrarCitaMedica(CitaMedica miCita){
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }
    public void imprimirCitasMedicasProgramadas(){
        String msj="CITAS MEDICAS PROGRAMADAS\n";
        CitaMedica miCita=null;
        System.out.println(msj+"\n");

        if(citasList.size()>0){
            for(int i=0;i<citasList.size();i++){
                miCita=citasList.get(i);
                System.out.println(miCita.informacionCitaMedica());

            }
        }else{
            System.out.println("No existen citas programadas");
        }
    }
}
