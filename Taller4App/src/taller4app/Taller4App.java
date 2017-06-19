

package taller4app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ucn.StdOut;

public class Taller4App {





 public static void main(String[] args) throws IOException  {
     
    App app = new App();
       
    app.leerInscripciones();
    app.leerAsignaturas();
    app.leerPersonas();
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  
    StdOut.println(" Taller 4");
    StdOut.println(" (1) - RF1");
    StdOut.println(" (2) - RF2" );
    StdOut.println(" (3) - RF3" );
    StdOut.println(" (4) - RF4" );
    StdOut.println(" (5) - RF5" );
    StdOut.println(" (6) - RF6" );
    StdOut.println(" (7) - Salir. " );              
    
    int op;
        do{  
            StdOut.println("\nIngrese una opción del menú: " );
            op = Integer.parseInt(bf.readLine()); 
            switch(op){
                
                case 1: 
                    app.RF1(); 
                    break;
                case 2:
                    app.RF2(); 
                    break;
                case 3:
                    app.RF3();
                    break;
                case 4:
                    app.RF4();
                    break;
                case 5:
                    app.RF5();
                    break;    
                case 6:
                    app.RF6();
                    break;
                case 7:
                default:
                    StdOut.println("\nUsted está saliendo del menú..." );
                    break;               
            }
            }while( op != 7 );
  } 
}

