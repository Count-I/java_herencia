package org.example;

import org.example.clases.CitaMedica;
import org.example.clases.ModeloDatos;
import org.example.clases.Paciente;
import org.example.clases.empleado.EmpleadoEventual;
import org.example.clases.empleado.EmpleadoPlanilla;
import org.example.clases.empleado.Medico;

import javax.swing.*;
import java.sql.SQLOutput;

public class Procesos {

    ModeloDatos miModeloDatos;

    public Procesos() throws Exception {
        miModeloDatos= new ModeloDatos();
        presentarMenuOpciones();
    }

    private void presentarMenuOpciones() throws Exception {
        String menu="MENU HOSPITAL\n\n";
        menu+="1. Registrar paciente\n";
        menu+="2. Registrar empleado\n";
        menu+="3. Registrar Medico\n";
        menu+="4. Registrar cita medica\n";
        menu+="5. Imprimir informacion\n";
        menu+="6. Salir\n\n";
        menu+="Ingrese una opcion\n";

        int opcion=0;
        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarMedico(); break;
                case 4: registrarCitaMedica(); break;
                case 5: imprimirInformacion(); break;
                case 6: System.out.println("El sistema ha terminado"); break;
                default: System.out.println("No existe el codigo ingresado, verifique nuevamente");
                    break;
            }
        }while (opcion!=5);

    }

    private void registrarPaciente() throws Exception {
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();
        if(!miModeloDatos.pacienteHashMap.containsKey(miPaciente.getNumeroDeDni())) {
            miModeloDatos.registrarPersona(miPaciente);
        }else {
            System.out.println("El paciente ya se encuentra registrado");
        }
    }
    private void registrarMedico() throws Exception {
        Medico miMedico = new Medico();
        miMedico.registrarDatos();
        if(!miModeloDatos.medicoHashMap.containsKey(miMedico.getNumeroDeDni())){
        miModeloDatos.registrarPersona(miMedico);
        }else {
            System.out.println("El medico ya se encuentra registrado");
        }
    }
    private void registrarEmpleado() throws Exception {
        String menuTipoEmpleado="Registro de Empleado\n";
        menuTipoEmpleado+="1. Empleado Eventual\n";
        menuTipoEmpleado+="2. Empleado por planilla\n";
        menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";

        int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

        switch (tipoEmpleado){
            case 1:
                EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
                miEmpleadoEventual.registrarDatos();
                if(!miModeloDatos.empleadoEventualHashMap.containsKey(miEmpleadoEventual.getNumeroDeDni())){
                miModeloDatos.registrarPersona(miEmpleadoEventual);
                }else {
                    System.out.println("El Empleado eventual ya se encuentra registrado");
                }
                break;
            case 2:
                EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
                miEmpleadoPlanilla.registrarDatos();
                if(!miModeloDatos.empleadoPlanillaHashMap.containsKey(miEmpleadoPlanilla.getNumeroDeDni())){
                miModeloDatos.registrarPersona(miEmpleadoPlanilla);
                }else {
                    System.out.println("El empleado plantilla ya se encuentra registrado");
                }
                break;
            default:
                System.out.println("El tipo de empleado no es valido, intente nuevamente");
                break;
        }
    }
    private void registrarCitaMedica(){
        String documentoPaciente= JOptionPane.showInputDialog("Ingrese el documento del paciente");
        Paciente pacienteEncontrado= miModeloDatos.consultarPacientePorDocumento(documentoPaciente);

        if(pacienteEncontrado!=null){
            String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del medico");
            Medico medicoEncontrado= miModeloDatos.consultarMedicoPorNombre(nombreMedico);

            if(medicoEncontrado!=null){
                String servicio=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
                String fechaConsulta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");

                String lugar="La cita sera en el consultario "+medicoEncontrado.getNumeroDeConsultorio();
                CitaMedica miCita= new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);

            }else{
                System.out.println("El medico no se encuentra registrado en el sistema");
            }
        }else{
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }

    }
    private void imprimirInformacion(){

        String menuImprimir="MENU IMPRESIONAES\n";
        menuImprimir+="1. Listar pacientes\n";
        menuImprimir+="2. Listar empleados eventuales\n";
        menuImprimir+="3. Listar empleados por planilla\n";
        menuImprimir+="4. Listar medicos\n";
        menuImprimir+="5. Listar ciatas programadas\n";
        menuImprimir+="6. Consultar paciente por documento\n";
        menuImprimir+="7. Consultar empleado eventual por documento\n";
        menuImprimir+="8. Consultar empleado planilla por documento\n";
        menuImprimir+="6. Consultar medico por documento\n";
        menuImprimir+="Ingrese una opcion\n";

        System.out.println("*************************************************************");

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

        switch (opcion){
            case 1: miModeloDatos.imprimirPacientes(); break;
            case 2: miModeloDatos.imprimirEmpleadosEventuales(); break;
            case 3: miModeloDatos.imprimirEmpleadosPorPlanilla(); break;
            case 4: miModeloDatos.imprimirMedicos(); break;
            case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); break;
            case 6: miModeloDatos.consultarPacientePorDocumento(JOptionPane.showInputDialog("Ingrese el documento")); break;
            case 7: miModeloDatos.consultarEmpleadoPlanillaPorDocumento(JOptionPane.showInputDialog("Ingrese el documento")); break;
            case 8: miModeloDatos.consultarMedicoPorDocumento(JOptionPane.showInputDialog("Ingrese el documento")); break;
            default:System.out.println("No existe esa opcion"); break;
        }

    }
}
