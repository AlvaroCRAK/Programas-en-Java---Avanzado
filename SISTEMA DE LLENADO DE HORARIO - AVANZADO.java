import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("===================== SISTEMA DE ASIGNACION DE CURSOS =======================");
		System.out.println("Ingrese la cantidad de cursos a registrar: ");
		int cursos = scanner.nextInt();
		
		scanner.nextLine();
		
		Curso[] curso = new Curso[cursos];
		
		char[] docentec = {'a', 'b', 'c', 'd', 'e'};
		
		 char[] lunes = new char[14];
		 char[] martes = new char[14];
		 char[] miercoles = new char[14];
		 char[] jueves = new char[14];
		 char[] viernes = new char[14];
		 char[] sabado = new char[14];
		 char[] domingo = new char[14];
		 
		 boolean[] lunesb = new boolean[14];
		 boolean[] martesb = new boolean[14];
		 boolean[] miercolesb = new boolean[14];
		 boolean[] juevesb = new boolean[14];
		 boolean[] viernesb = new boolean[14];
		 boolean[] sabadob = new boolean[14];
		 boolean[] domingob = new boolean[14];
		 
		 String[] asignatura = new String[cursos]; 
		 char[] asignaturac = new char[cursos];
		 
		 char[] lunesa = new char[14];
		 char[] martesa = new char[14];
		 char[] miercolesa = new char[14];
		 char[] juevesa = new char[14];
		 char[] viernesa = new char[14];
		 char[] sabadoa = new char[14];
		 char[] domingoa = new char[14];
		
		for(int i=0;i<cursos;i++) {
		
			
			System.out.println("Ingrese la asignatura:                                                                                                       minimo 8 letras");
			asignatura[i] = scanner.nextLine();
			asignaturac[i] = (char)('a' + i);
			
			
			System.out.println("Ingrese el docente a dictar: \n'IVAN PETRLIK', 'VILMA PERALTA', 'JUAN GAMARRA', 'JORGE ZAVALETA', 'ARREDONDO GUSTAVO'");
			String docente = scanner.nextLine();
			while (!docente.equals("IVAN PETRLIK") && !docente.equals("VILMA PERALTA") && !docente.equals("JUAN GAMARRA") && !docente.equals("JORGE ZAVALETA") && !docente.equals("ARREDONDO GUSTAVO")) {
				System.out.print("Ingrese bien el nobre del docente: ");
				docente = scanner.nextLine();
			}
			char doc = asignarDocente(docente);
			
			int dian;
			do {
				System.out.println("Ingrese el dia: \nLunes     [1]\nMartes    [2]\nMiercoles [3]\nJueves    [4]\nViernes   [5]\nSabado    [6]\nDomingo   [7]");
				dian = scanner.nextInt();
			}while(dian !=1 && dian !=2 && dian !=3 && dian !=4 && dian !=5 && dian !=6 && dian !=7 );
			
			String dia = llenarDia(dian);
			
			int temp;
			int inicio;
			int salida;
			do {
			
				System.out.println("Ingrese la hora de manera de 00:00 a 23:59;");
				
				
				do {
					System.out.print("Ingrese la hora de inicio: ");
					inicio = scanner.nextInt();
				}while(inicio<8 || inicio>30);
					
				
				do {
					System.out.print("Ingrese la hora de salida: ");
					salida = scanner.nextInt();
				}while(salida<8 || salida>30);
				
				
				temp =verificar(inicio, salida, dian, lunesb, martesb, miercolesb, juevesb, viernesb, sabadob, domingob, doc, lunes, martes, miercoles, jueves, viernes, sabado, domingo,
						lunesa, martesa, miercolesa, juevesa, viernesa, sabadoa, domingoa, asignaturac, i);
				if(temp == 0)System.out.println("=============== REGISTRO CON EXITO ===============");
				else if(temp ==2) {System.out.println("====== CRUCE DE PROFESOR ======");
				System.out.println("Vuelva a llenar el horario: \n");
				}else if(temp != 0 ) {System.out.println("======= CRUCE DE HORARIO ======");
				System.out.println("Vuelva a llenar el horario: \n");
				}
			}while(temp != 0 || salida<inicio);
			
			
			curso[i] = new Curso(asignatura[i], docente, dia, inicio, salida, asignaturac[i]);
			
			scanner.nextLine();
		}
		//================================================================ FIN DEL CICLO FOR =============================================================================================================================
		System.out.println("=======================================================================");
		System.out.println("===================== CURSOS ASIGNADOS CON EXITO ======================");
		System.out.println("=======================================================================\n\n");
		
		//======================================================= PRUsaEBAS ========================================================================================
		/*
		for(int i=0;i<14;i++) {
			System.out.print(lunesa[i] + ", ");
		}
		*/
		//======================================================= PRUEBAS ========================================================================================
		panelDeOpciones(scanner, cursos, curso, docentec, asignaturac, cursos, lunesa, martesa, miercolesa, juevesa, viernesa, sabadoa, domingoa);
		
		scanner.close();
	}
	

	
	static String llenarDia(int dia) {
		String dian = "";
		switch(dia) {
		case 1:
			dian = "Lunes";
			break;
		case 2: 
			dian = "Martes";
			break;
		case 3:
			dian = "Miercoles";
			break;
		case 4:
			dian = "Jueves";
			break;
		case 5: 
			dian = "Viernes";
			break;
		case 6:
			dian = "Sabado";
			break;
		case 7:
			dian = "Domingo";
			break;	
		}
		return dian;
	}
		
	static int verificar(int inicio, int salida, int dia, boolean lunesb[], boolean martesb[], boolean miercolesb[], boolean juevesb[], boolean viernesb[], boolean sabadob[], boolean domingob[], char profesor,
			char lunes[], char martes[], char miercoles[],char jueves[],char viernes[], char sabado[], char domingo[],
			char lunesa[], char martesa[], char miercolesa[], char juevesa[], char viernesa[], char sabadoa[], char domingoa[],
					char asignaturac[], int x) {
		
		//==================================================================== ALGORITMO 1 ====================================================================================================
		
		int temp=0;
		int b = 0;
		switch(dia) {
		case 1:
			for(int i=inicio-8;i<salida-8;i++) {
				if(lunesb[i] == false && temp == 0 && lunes[i] == '\u0000') { 
					lunes[i] = profesor;
					lunesb[i] = true;
					lunesa[i] = asignaturac[x];//////////////////////////////////
					}else if(lunes[i] != '\u0000')b=1;
					else temp =1;
			}
			break;
		case 2:
			for(int i=inicio-8;i<salida-8;i++) {
				if(martesb[i] == false && temp == 0 && martes[i] == '\u0000') { 
					martes[i] = profesor;
					martesb[i] = true;
					martes[i] = asignaturac[x];
					}else if(martes[i] != '\u0000')b=1;
					else temp =1;
			}
			break;
		case 3:
			for(int i=inicio-8;i<salida-8;i++) {
				if(miercolesb[i] == false && temp == 0 && miercoles[i] == '\u0000') { 
					miercoles[i] = profesor;
					miercolesb[i] = true;
					miercoles[i] = asignaturac[x];
					}else if(miercoles[i] != '\u0000')b=1;
					else temp =1;
			}
			break;
		case 4:
			for(int i=inicio-8;i<salida-8;i++) {
				if(juevesb[i] == false && temp == 0 && jueves[i] == '\u0000') { 
					jueves[i] = profesor;
					juevesb[i] = true;
					jueves[i] = asignaturac[x];
					}else if(jueves[i] != '\u0000')b=1;
					else temp =1;
			}
			break;
		case 5:
			for(int i=inicio-8;i<salida-8;i++) {
				if(viernesb[i] == false && temp == 0 && viernes[i] == '\u0000') { 
					viernes[i] = profesor;
					viernesb[i] = true;
					viernes[i] = asignaturac[x];
					}else if(viernes[i] != '\u0000')b=1;
					else temp =1;
			}
			break;
		case 6:
			for(int i=inicio-8;i<salida-8;i++) {
				if(sabadob[i] == false && temp == 0 && sabado[i] == '\u0000') { 
					sabado[i] = profesor;
					sabadob[i] = true;
					sabado[i] = asignaturac[x];
					}else if(sabado[i] != '\u0000')b=1;
					else temp =1;
			}
			break;
		case 7:
			for(int i=inicio-8;i<salida-8;i++) {
				if(domingob[i] == false && temp == 0 && domingo[i] == '\u0000') { 
					domingo[i] = profesor;
					domingob[i] = true;
					domingo[i] = asignaturac[x];
					}else if(domingo[i] != '\u0000')b=1;
					else temp =1;
			}
			break;	
		}
		if(b==1) return 3;
		else return temp;
	}
	
	static char asignarDocente(String docente) {
		char a = '1';
		switch(docente) {
		case "IVAN PETRLIK": a = 'a'; break;
		case "VILMA PERALTA": a = 'b'; break;
		case "JUAN GAMARRA": a = 'c'; break;
		case "JORGE ZAVALETA": a = 'd'; break;
		case "ARREDONDO GUSTAVO": a = 'e'; break;		
		}
		return a;
	}

	static void panelDeOpciones(Scanner scanner, int cursos, Curso curso[], char docentec[], char asignaturac[], int cursosa, 
			char lunesc[], char martesc[], char miercolesc[], char juevesc[], char viernesc[], char sabadoc[], char domingoc[]) {
		int con;
		do {
			int opc;
			System.out.println("========= INGRESE LA OPCION A MOSTRAR =========");
			System.out.println("Horario                         [1]");
			System.out.println("Curso - Profesor - Dia - Hora   [2]");
			System.out.println("Salir                           [3]");
			opc = scanner.nextInt();
			
			switch(opc) {
				case 1: 
					horario(curso, docentec, asignaturac, cursosa, lunesc, martesc, miercolesc, juevesc, viernesc, sabadoc, domingoc);
					break;
				case 2:
					mostrarCursos(cursos, curso);
					break;
				case 3:
					break;
				}
			System.out.println("Desea continuar: \nSi  [1]\nNo  [otro numero]");
			con = scanner.nextInt();
		}while(con == 1 );
	}
	
	static void horario(Curso curso[], char docentec[], char asignaturac[], int cursos, char lunesc[], char martesc[], char miercolesc[], 
			char juevesc[], char viernesc[], char sabadoc[], char domingoc[]) {
		
		String[][] orden = new String[7][14];
		
		//============================================================ ALGORITMO II ====================================================================================
		
		for(int i=0;i<cursos;i++) {
			if(curso[i].dia == "Lunes") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[0][j] = curso[i].asignatura;
				}
			}	
			else if(curso[i].dia== "Martes") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[1][j] = curso[i].asignatura;
				}
			}
			else if(curso[i].dia == "Miercoles") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[2][j] = curso[i].asignatura;
				}
			}
			else if(curso[i].dia == "Jueves") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[3][j] = curso[i].asignatura;
				}
			}
			else if(curso[i].dia == "Viernes") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[4][j] = curso[i].asignatura;
				}
			}
			else if(curso[i].dia == "Sabado") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[5][j] = curso[i].asignatura;
				}
			}
			else if(curso[i].dia == "Domingo") {
				for(int j = curso[i].inicio-8; j< curso[i].salida-8;j++) {
					
					orden[6][j] = curso[i].asignatura;
				}
			}
		}
		
		
		
		//============================================================ PRUEBAS =================================================================================================
		for(int i=0;i<7;i++) {
			for(int j=0;j<14;j++) {
				if(orden[i][j] == null)orden[i][j] = "        ";
				
			}
		}
		
		//===============================================================================================================================================================

		System.out.println("==================================================================================================================================================================================");
    	System.out.println("||        HORA        ||        LUNES       ||        MARTES      ||      MIERCOLES     ||        JUEVES      ||       VIERNES      ||        SABADO      ||       DOMINGO      ||");
    	System.out.println("==================================================================================================================================================================================");
    	System.out.printf("||        8:00        ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][0].substring(0,8), orden[1][0].substring(0,8), orden[2][0].substring(0,8), orden[3][0].substring(0,8), orden[4][0].substring(0,8), orden[5][0].substring(0,8), orden[6][0].substring(0,8));
    	System.out.printf("||        9:00        ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][1].substring(0,8), orden[1][1].substring(0,8), orden[2][1].substring(0,8), orden[3][1].substring(0,8), orden[4][1].substring(0,8), orden[5][1].substring(0,8), orden[6][1].substring(0,8));
    	System.out.printf("||        11:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][2].substring(0,8), orden[1][2].substring(0,8), orden[2][2].substring(0,8), orden[3][2].substring(0,8), orden[4][2].substring(0,8), orden[5][2].substring(0,8), orden[6][2].substring(0,8));
    	System.out.printf("||        12:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][3].substring(0,8), orden[1][3].substring(0,8), orden[2][3].substring(0,8), orden[3][3].substring(0,8), orden[4][3].substring(0,8), orden[5][3].substring(0,8), orden[6][3].substring(0,8));
    	System.out.printf("||        13:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][4].substring(0,8), orden[1][4].substring(0,8), orden[2][4].substring(0,8), orden[3][4].substring(0,8), orden[4][4].substring(0,8), orden[5][4].substring(0,8), orden[6][4].substring(0,8));
    	System.out.printf("||        14:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][5].substring(0,8), orden[1][5].substring(0,8), orden[2][5].substring(0,8), orden[3][5].substring(0,8), orden[4][5].substring(0,8), orden[5][5].substring(0,8), orden[6][5].substring(0,8));
    	System.out.printf("||        15:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][6].substring(0,8), orden[1][6].substring(0,8), orden[2][6].substring(0,8), orden[3][6].substring(0,8), orden[4][6].substring(0,8), orden[5][6].substring(0,8), orden[6][6].substring(0,8));
    	System.out.printf("||        16:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][7].substring(0,8), orden[1][7].substring(0,8), orden[2][7].substring(0,8), orden[3][7].substring(0,8), orden[4][7].substring(0,8), orden[5][7].substring(0,8), orden[6][7].substring(0,8));
    	System.out.printf("||        17:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][8].substring(0,8), orden[1][8].substring(0,8), orden[2][8].substring(0,8), orden[3][8].substring(0,8), orden[4][8].substring(0,8), orden[5][8].substring(0,8), orden[6][8].substring(0,8));
    	System.out.printf("||        18:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][9].substring(0,8), orden[1][9].substring(0,8), orden[2][9].substring(0,8), orden[3][9].substring(0,8), orden[4][9].substring(0,8), orden[5][9].substring(0,8), orden[6][9].substring(0,8));
    	System.out.printf("||        19:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][10].substring(0,8), orden[1][10].substring(0,8), orden[2][10].substring(0,8), orden[3][10].substring(0,8), orden[4][10].substring(0,8),orden[5][10].substring(0,8), orden[6][10].substring(0,8));
    	System.out.printf("||        20:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][11].substring(0,8), orden[1][11].substring(0,8), orden[2][11].substring(0,8), orden[3][11].substring(0,8), orden[4][11].substring(0,8), orden[5][11].substring(0,8), orden[6][11].substring(0,8));
    	System.out.printf("||        21:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][12].substring(0,8), orden[1][12].substring(0,8), orden[2][12].substring(0,8), orden[3][12].substring(0,8), orden[4][12].substring(0,8), orden[5][12].substring(0,8), orden[6][12].substring(0,8));
    	System.out.printf("||        22:00       ||       %s     ||      %s      ||      %s      ||       %s     ||      %s      "
    			+ "||     %s       ||     %s      ||\n", orden[0][13].substring(0,8), orden[1][13].substring(0,8), orden[2][13].substring(0,8), orden[3][13].substring(0,8), orden[4][13].substring(0,8), orden[5][13].substring(0,8), orden[6][13].substring(0,8));
    	System.out.println("====================================================================================================="
    			+ "============================================================================");
    	
	}
	
	static void mostrarCursos(int cursos, Curso curso[]) {
		System.out.println();
		for(int i=0;i<cursos;i++) {
			System.out.println(curso[i].asignatura + " - " + curso[i].docente + " - " + curso[i].dia + " \n Hora: " + curso[i].inicio + " - " + curso[i].salida);
			System.out.println();
		}
	}
}

class Curso{
	
	char codigo;
	String asignatura;
	String docente;
	String dia;
	int inicio;
	int salida;
	
	Curso(String asignatura, String docente, String dia, int inicio, int salida, char codigo){
		this.asignatura = asignatura;
		this.docente = docente;
		this.dia = dia;
		this.inicio = inicio;
		this.salida = salida;
		this.codigo = codigo;
			
	}
	
}   //ZUBLIME
