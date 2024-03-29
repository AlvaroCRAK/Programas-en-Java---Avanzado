import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============== SISTEMA DE SUELDOS =================");
		System.out.print("Ingrese el numero de profesores: ");
		int profesores = scanner.nextInt();
		
		String[] nombre = new String[profesores];
		int[] gradoEstudio = new int[profesores];
		int[] hijos =  new int[profesores];
		double[] bonos = new double[profesores];
		double[] sueldo = new double[profesores];
		int[] contrato =  new int[profesores];
		int[] cantidadBonos = new int[profesores];
		
		System.out.println("========== LLENAR DATOS DE LOS PROFESORES ===========");
		
		llenarDatos(nombre, gradoEstudio, hijos, bonos, sueldo, scanner, contrato, cantidadBonos);
		
		System.out.println("=========== RESULTADOS ==========");
		
		resultados(nombre, gradoEstudio, contrato, hijos, bonos, sueldo);
		
		System.out.println("======= RESULTADOS GENERALES =======");
		
		resultadosGenerales(sueldo, bonos, hijos, cantidadBonos);
		
		scanner.close();
	}
	
	static void llenarDatos(String nombre[], int gradoEstudio[], int hijos[], double bonos[], double sueldo[], Scanner scanner, int contrato[], int cantidadBonos[]) {
		for(int i=0;i<nombre.length;i++) {
			
			scanner.nextLine();
			
			System.out.println("===== PROFESOR "+ (i+1)+ ": ======");
			System.out.print("Nombre completo: ");
			nombre[i] = scanner.nextLine();
			do {
				System.out.print("Grado de estudios: \nIngeniero:   [1]\nMaestria:    [2]\nDoctorado:   [3]\n");
				gradoEstudio[i] = scanner.nextInt();
			}while(gradoEstudio[i]!=1 && gradoEstudio[i]!=2 && gradoEstudio[i]!=3);
			do {
				System.out.print("Tipo de contrato:\nDocente contratado:   [1]\nDocente nombrado:   [2]\n");
				contrato[i]=scanner.nextInt();
			}while(contrato[i]!=1 && contrato[i]!=2);
			do {
				System.out.print("Numero de hijos: ");
				hijos[i] = scanner.nextInt();
			}while(hijos[i]<0);
			
			switch(gradoEstudio[i]) {
			case 1:
				switch(contrato[i]) {
				case 1:sueldo[i]= 850; break;
				case 2:sueldo[i] = 1000; break;
				}
				break;
			case 2:
				switch(contrato[i]) {
				case 1:sueldo[i] = 1400; break;
				case 2:sueldo[i] = 1800; break;
				}
				break;
			case 3:
				switch(contrato[i]) {
				case 1:sueldo[i] = 1700; break;
				case 2:sueldo[i] = 2500; break;
				}
				break;
			default:
				System.out.println("====== HUBO UN ERROR =====");
				break;
			}
			if(hijos[i]>5) {bonos[i]= sueldo[i]*0.2; cantidadBonos[i]=3;}
			else if(hijos[i]>2) {bonos[i]=sueldo[i]*0.15;cantidadBonos[i]=2;}
			else if(hijos[i]>0) {bonos[i]=sueldo[i]*0.1;cantidadBonos[i]=1;}
			else {bonos[i]=0;cantidadBonos[i]=0;}
		}
	}
	
	static void resultados(String nombre[], int gradoEstudio[],int contrato[] , int hijos[], double bonos[], double sueldo[]) {
		for(int i =0;i<nombre.length;i++) {
			System.out.println("\n=== PROFESOR "+nombre[i]+" ===");
			System.out.println("Grado de estudios: " + gradoEstudio[i]);
			System.out.println("Numero de hijos: " + hijos[i]+"\n");
			System.out.printf("Sueldo Bruto: %.2f\n",sueldo[i]);
			System.out.printf("Bono: %.2f\n", bonos[i]);
			System.out.printf("Sueldo Neto: %.2f\n", (sueldo[i] + bonos[i]));
		}
	}
	
	static void resultadosGenerales(double sueldo[], double bonos[], int hijos[], int cantidadBonos[]){
		double sumabrutos=0, sumabonos =0, sumanetos=0;
		int hijos0=0, hijos1=0, hijos2=0, hijos3=0;
		int bono0=0,bono1=0, bono2=0, bono3=0;
		
		for(int i=0;i<sueldo.length;i++) {
			sumabrutos +=sueldo[i];
			sumabonos += bonos[i];
			sumanetos += (sueldo[i] + bonos[i]);
			
			if(hijos[i]>5)hijos3++;
			else if(hijos[i]>2)hijos2++;
			else if(hijos[i]>0)hijos1++;
			else hijos0++;
			
			if(cantidadBonos[i]==1)bono1++;
			else if(cantidadBonos[i]==2)bono2++;
			else if(cantidadBonos[i]==3)bono3++;
			else if(cantidadBonos[i]==0)bono0++;
			
		}
		System.out.printf("Suma de sueldos bruto: %.2f\n",sumabrutos);
		System.out.printf("Suma de bonos: %.2f\n", sumabonos);
		System.out.printf("Suma de sueldos neto: %.2f\n", sumanetos);
		System.out.printf("Rango de hijos de los docentes\n0:    %d\n1 - 2: %d\n3 - 5: %d\n6 - mas: %d\n",hijos0,hijos1,hijos2,hijos3 );
		System.out.printf("Rango de bonos que recibieron: \nNo recibieron bono:   %d\nBono del 10%%   %d\nBono del 15%%   %d\nBono del 20%%   %d\n\n", bono0, bono1, bono2, bono3);
		System.out.print("============================\n==== GRACIAS POR SU USO!====\n============================\n");
		
		
	}
}
