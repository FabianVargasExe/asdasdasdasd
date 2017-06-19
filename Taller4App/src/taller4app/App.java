/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4app;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;


public class App implements IApp {
 
    
    private ListaInscripciones listaInscripciones;
    private ListaMensajes listaMensajes;
    private LinkedList listaAsignaturas;
    private ListaPersonas listaPersonas;
    private LinkedList registroErrores;
    

    public App() {
        
        listaPersonas = new ListaPersonas();
        listaInscripciones = new ListaInscripciones();
        listaAsignaturas = new LinkedList();
        registroErrores = new LinkedList();
        listaMensajes = new ListaMensajes();
        
    }

   // Método de lectura de los archivos .txt
    @Override        
    public void leerInscripciones() {
             
        try {
            ArchivoEntrada in = new ArchivoEntrada("Inscripciones.txt");
            while(!in.isEndFile()){
                Registro reg = in.getRegistro();
                
                String Alias = reg.getString();
                String CodigoA = reg.getString();
                
                Inscripcion i = new Inscripcion(Alias,CodigoA);
                
                listaInscripciones.ingresar(i);               
                }
     
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }

    }
    
    @Override 
    public void leerAsignaturas() {
       
            try {
            
            FileReader f = new FileReader("asignaturas.txt");
            BufferedReader  br = new BufferedReader(f);
            
            String linea;
            
            while((linea=br.readLine())!=null){
                
                int ValidadorIngreso = 0;
                String[] campos = linea.split(".");
   
                String Cod = campos[0];
                String Nombre = campos[1];
                int CantPersona = Integer.parseInt(campos[2]);
                
                Asignatura a = new Asignatura(Cod,Nombre,CantPersona);

                if (!Cod.matches("[0-9]*")){
                    registroErrores.add(new RegistroError("Asignatura","codigo",Cod,2));
                    ValidadorIngreso++;     
                } else {               
                    listaAsignaturas.add(a);   
                }
                
            }
            
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
   } 
   
   
    @Override 
    public void leerPersonas() {
       
        try {
            
            FileReader f = new FileReader("creditos.txt");
            BufferedReader  br = new BufferedReader(f);
            
            String linea;
            
            while((linea=br.readLine())!=null){
                String[] campos = linea.split(";");
   
                String Rut = campos[0];
                String Nombre = campos[1];
                String Apellido = campos[2];
                String Correo = campos[3];
                String Estudio = campos[4];
                int Dato1 = Integer.parseInt(campos[5]);
                int Dato2 = Integer.parseInt(campos[6]); 
                
                // Variable Alias a partir del correo
                
                int ValidadorIngreso = 0;
                int n = Correo.indexOf("@");
                String Alias =  Correo.substring(0,n); 

                
                /*
                * Verificación Datos
                * Solo se ingresara si
                */
 
                // entrega el digito codificador 
                String ultimoCaracter = Rut.substring(Rut.length()-1);
                
                // entrega una cadena a partir de @
                String Dominio =  Correo.substring(n);
                
                // Entrega el rut sin el digito verificador
                String RutSinDigito = Rut.substring(0, Rut.length()-2);
                
                
                
                Long.parseLong(Dominio);
                
                
                // si esta bien se ingresa
                
                // Validador Rut

                if (!validarRut(RutSinDigito,ultimoCaracter)){
                    registroErrores.add(new RegistroError("Persona","Rut",Rut,1));
                    ValidadorIngreso++;
                }
                     
                // Validador Dominio Mail
                
                if (!Dominio.equals("@gmail.com")){
    
                    registroErrores.add(new RegistroError("Persona","Correo",Correo,3));
                    ValidadorIngreso++;
                }
                
                
                // Se ingresara a la lista de Persona si paso todos los validadores
                if (ValidadorIngreso == 0){
                    
                   if(Estudio.equals("alumno")){
                      listaPersonas.ingresaAlumno(Rut,Nombre,Apellido,Correo,Alias,Dato1,Dato2);  
                   }
                   if(Estudio.equals("profesor")){
                      listaPersonas.ingresaProfesor(Rut,Nombre,Apellido,Correo,Alias,Dato1,Dato2);
                   }
                }
                           
            }

            
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }       
   
   }    
   
   
   
   
  public static boolean validarRut(String vrut, String vverificador) 
      { 
          // verificar esta mierda
          boolean flag = false; 
          String rut = vrut.trim(); 

          String posibleVerificador = vverificador.trim(); 
          int cantidad = rut.length(); 
          int factor = 2; 
          int suma = 0; 
          String verificador = ""; 

          for(int i = cantidad; i > 0; i--) 
          { 
              if(factor > 7) 
              { 
                  factor = 2; 
              } 
              suma += (Integer.parseInt(rut.substring((i-1), i)))*factor; 
              factor++; 

          } 
          verificador = String.valueOf(11 - suma%11); 
          if(verificador.equals(posibleVerificador)) 
          { 
              flag = true; 
          } 
          else 
          { 
              if((verificador.equals("10")) && (posibleVerificador.toLowerCase().equals("k"))) 
              { 
                  flag = true; 
              } 
              else 
              { 
                  if((verificador.equals("11") && posibleVerificador.equals("0"))) 
                  { 
                      flag = true; 
                  } 
                  else 
                  { 
                      flag = false; 
                  } 
              } 
          } 
          return flag;         
      }  
   
   // Errores de Registro 
   @Override 
   public void RF1() {
       
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
         fichero = new FileWriter("ErroresDeRegistro.txt");
         pw = new PrintWriter(fichero);  
         
         pw.println("                     Errores de Registro                   ");
         pw.println("-------------------------------------------------------------");
          
         Iterator ite = registroErrores.iterator();  
         while(ite.hasNext()){
             
            RegistroError re = (RegistroError) ite;
          
            pw.print(re.getCategoria());
            pw.print(re.getCampo());
            pw.print(re.getValorCampo());  
            pw.print(re.errorEncontrato());  

            pw.println();
            
            }
                
            StdOut.println("\nEl archivo 'ErroresDeRegistro.txt' se ha creado exitosamente.");
                   
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }  
   }  
   

   // Despliegue datos de una asignatura
   @Override 
   public void RF2() {
       
       StdOut.println("Ingrese código de la asignatura para mostrar sus datos: ");
       StdOut.println("---------------------");
       int cod = StdIn.readInt();
       
       NodoInscripcion actual = listaInscripciones.getFirst();
       while(actual != null){ // poner algo como getnext != first
           actual.getNext();
           
           if(actual.getInscripcion().getCodigoAsig().equals(cod)){
               
               String alias = actual.getInscripcion().getAlias();
               NodoPersona personaAsig = listaPersonas.getFirst();
               
               while(personaAsig != null){
                   personaAsig.getNext();
                   
                    if(personaAsig.persona.getAlias().equals(alias)){
                      
                       StdOut.println(" Nombre: " + personaAsig.persona.getNombre());
                       StdOut.println(" Apellido: " + personaAsig.persona.getApellido());
                       StdOut.println(" Rut: " + personaAsig.persona.getRut());
                       StdOut.println(" Correo: " + personaAsig.persona.getCorreo());
                       StdOut.println(" Alias: " + personaAsig.persona.getAlias());
                       StdOut.println(" Nota: ");

                      
                       if(personaAsig.persona instanceof Alumno){
                           Alumno alum = (Alumno)personaAsig.persona;
                           
                          StdOut.println(" Cantidad Mensajes enviados: " +alum.getCantMsjEnviadosProfe());
                          StdOut.println(" Cantidad Asignaturas: " + alum.getCantAsignaturas());                   
                       }
                      
                       else{
                           Profesor profe = (Profesor)personaAsig.persona;
                          
                          StdOut.println(" Cantidad Mensajes enviados: " + profe.getCantMsjEnviados());
                          StdOut.println(" Cantidad Mensajes recibidos: " + profe.getCantMsjRecibidos()); 
                     }
                  
                    }
                    StdOut.println("----------------------");

               }
           }       
       }
   } 
   
   // Enviar un mensaje
   @Override 
   public void RF3() {
       
      Date fechaActual = new Date(); 
      DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
      DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
      
      StdOut.println("-----ENVIAR UN MENSAJE----");
      StdOut.println("Ingrese un alias valido: ");
      String alias = StdIn.readString();
      
      
      // Si existe el alias ingresado se procedera a preguntar el codigo de la asignatura
      if(listaPersonas.buscar(alias)){
            StdOut.println("Ingrese el código de la asignatura del destinatario: ");
            String CodDestino = StdIn.readString();
            
            Iterator ite = listaAsignaturas.iterator();
            // Si concide el codigo dentro del listado se procedera a preguntar el destinatario       
            while(ite.hasNext()){
               Asignatura a = (Asignatura) ite;
              
               if(a.getCodigo().equals(CodDestino)){
                   
                  NodoPersona curr = a.getListaPersonas().getFirst();
                  StdOut.println("Seleccione Destinatario:");
                  StdOut.println("---------------------");
                  
                  // Muestra el listado de personas segun la asignatura
                  while(curr != null ) {
                  
                     int i = 0;
     
                     StdOut.println("["+i+"] "+ curr.persona.getAlias());
                     curr = curr.getNext();
                     i++;
                     
                  }
                  
                  StdOut.println("Ingrese el alias del destinatario (Aprete 0 para cancelar el mensaje)");
                  String seleccionD = StdIn.readString();
                  if(!seleccionD.equals(0) && listaPersonas.buscar(seleccionD)){
                      StdOut.println("Ingrese asunto: ");
                      String asunto = StdIn.readString();
                      StdOut.println("Ingrese el mensaje: ");
                      String mensaje = StdIn.readString();
                      
                      String hora = formatoHora.format(fechaActual);
                      String fecha = formatoFecha.format(fechaActual);
                      Mensaje m = new Mensaje(asunto,mensaje,alias,seleccionD,hora,fecha);
                      listaMensajes.ingresar(m);
                           
                  }
                  else{
                      StdOut.println("SE HA CANCELADO EL ENVIO DEL MENSAJE");
                      StdOut.println("---------------------");
                      break;
                  
                  }     
               }  
              StdOut.println("El código ingresado no se encuentra en el listado");
              StdOut.println("---------------------");
              break;
            
            }
      
      
      
     }else{
          StdOut.println("EL ALIAS INGRESADO NO SE ENCUENTRA REGISTRADO"); 
          StdOut.println("---------------------------");
     }
   

   
   }    
   

   
   //Registrar una nueva persona en una asignatura.
   @Override 
   public void RF4() {
       // ingresar a la lista de personas y tambien al .txt de inscripcion y persona
   
   } 
   
   // Elimina una persona de una asignatura
   @Override 
   public void RF5() {
       // pedir alias y eliminar la inscripcion
   
   } 
   
   // Accede al registro de mensajes de una persona
   @Override 
   public void RF6() {
       // buscar mensajes segun emisor y receptor
   
   }    
    
}
 
    



    
    
    

