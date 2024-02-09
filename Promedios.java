import java.util.Scanner;
import java.util.InputMismatchException;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("============ PROMEDIO DE ALUMNOS ===============\nIngrese el numero de alumnos a evaluar: ");
        do{
            try{
                n = scanner.nextInt();
            }catch(Exception InputMismatchException){
                scanner.nextLine();
                System.out.print("no valido. Intente de nuevo: ");
            }
            if(n <= 0) System.out.print("Vuelva a ingresar: ");
        }while(n <= 0);
        double[] examenParcial = new double[n];
        double[] examenFinal = new double[n];
        double[] promedioDePracticasCalificadas = new double[n];
        double[] promedioDeTrabajosPracticos = new double[n];
        double[] promedio = new double[n];
        for(int i = 0; i < n; i++){
            System.out.printf("========= ALUMNO %d =========\n", (i + 1));
            System.out.print("Examen parcial: ");
            do{
                try{
                    examenParcial[i] = scanner.nextDouble();
                    if(examenParcial[i] == 0) break;
                }catch(Exception InputMismatchException){
                    scanner.nextLine();
                    System.out.print("Intente de nuevo: ");
                    continue;
                }
                if(examenParcial[i] <= 0 || examenParcial[i] >20) System.out.print("Se salio del limite: Intente de nuevo: ");
            }while(examenParcial[i] <= 0 || examenParcial[i] >20);
            System.out.print("Examen Final: ");
            do{
                try{
                    examenFinal[i] = scanner.nextDouble();
                    if(examenFinal[i] == 0) break;
                }catch(Exception InputMismatchException){
                    scanner.nextLine();
                    System.out.print("Intente de nuevo: ");
                    continue;
                }
                if(examenFinal[i] <= 0 || examenFinal[i] >20) System.out.print("Se salio del limite: Intente de nuevo: ");
            }while(examenFinal[i] <= 0 || examenFinal[i] >20);
            System.out.print("Promedio de practicas calificadas: ");
            do{
                try{
                    promedioDePracticasCalificadas[i] = scanner.nextDouble();
                    if(promedioDePracticasCalificadas[i] == 0) break;
                }catch(Exception InputMismatchException){
                    scanner.nextLine();
                    System.out.print("Intente de nuevo: ");
                    continue;
                }
                if(promedioDePracticasCalificadas[i] <= 0 || promedioDePracticasCalificadas[i] >20) System.out.print("Se salio del limite: Intente de nuevo: ");
            }while(promedioDePracticasCalificadas[i] <= 0 || promedioDePracticasCalificadas[i] >20);
            System.out.print("Promedio de trabajos practicos: ");
            do{
                try{
                    promedioDeTrabajosPracticos[i] = scanner.nextDouble();
                    if(promedioDeTrabajosPracticos[i] == 0) break;
                }catch(Exception InputMismatchException){
                    scanner.nextLine();
                    System.out.print("Intente de nuevo: ");
                    continue;
                }
                if(promedioDeTrabajosPracticos[i] <= 0 || promedioDeTrabajosPracticos[i] >20) System.out.print("Se salio del limite: Intente de nuevo: ");
            }while(promedioDeTrabajosPracticos[i] <= 0 || promedioDeTrabajosPracticos[i] >20);
            promedio[i] = examenParcial[i] * 0.3 + examenFinal[i] * 0.4 + promedioDePracticasCalificadas[i] * 0.15 + promedioDeTrabajosPracticos[i] * 0.15;
        }
        System.out.print("-------------- PROMEDIOS ----------------\n");
        for(int i = 0; i < n; i++){
            System.out.printf("Alumno %d: %.2f - ", (i + 1), promedio[i]);
            String resultado = promedio[i] >= 10.5 ? "Aprobado" : "Desaprobado";
            System.out.println(resultado);
        }
        scanner.close();
    }
}
//Zublime
