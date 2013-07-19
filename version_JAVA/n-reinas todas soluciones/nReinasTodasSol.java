
public class nReinas {

	/*
 	 * parametros importantes :
 	 * numeroSoluciones-> especifica el numero de soluciones diferentes que hemos encontrado
	 * nReinas -> numero de reinas a colocar en el tablero que cumplan las restricciones
	 * importante -> para mas de 13 reinas el problema tarda mucho en encontrar todas las posibles soluciones
	 * Usando otro algoritmo que mas adelante colgare se puede resolver mas reinas en un tiempo menor
	 * para cualquier duda contacta con tutoinformatica2013@gmail.com
	 */

	static final int nReinas = 4;
	static int numeroSoluciones = 0;

	public static void inicializarTablero(int [][]solucion,int valor){
		for(int i = 0;i < nReinas ; i++)
			for(int j = 0; j < nReinas ; j++)solucion[i][j] = valor; 
	}
	public static void mostrarTablero(int [][]solucion){
		for(int i = 0;i < nReinas ; i++){
			for(int j = 0; j < nReinas ; j++){
				System.out.print(solucion[i][j]+"  "); 
			}
			System.out.println();
		}
	}
	public static boolean mismaDiagonal(int [][] solucion,int fila , int columna){

		for(int i = 0;i < nReinas ; i++){
			for(int j = 0; j < nReinas ; j++){
				if(solucion[i][j] != 0 ){
					if(Math.abs(i-fila) == Math.abs(j-columna))return true;
				}
			}
		}
		return false;
	}
	public static boolean mismaFila(int [][]solucion, int fila){
		for(int j = 0 ; j < nReinas ;j++){
			if(solucion[fila][j] != 0)return true;
		}
		return false;
	}
	public static boolean mismaColumna(int [][]solucion, int columna){
		for(int i = 0 ; i < nReinas ;i++){
			if(solucion[i][columna] != 0)return true;
		}
		return false;
	}
	public static boolean cumpleRestricciones(int [][]solucion, int fila , int columna){
		if(mismaFila(solucion, fila))return false;
		if(mismaColumna(solucion, columna))return false;
		if(mismaDiagonal(solucion, fila, columna))return false;
		return true;
	}

	public static boolean BacktrackingTodasSoluciones(int[][] solucion , int etapa){

		if(etapa == nReinas){
			numeroSoluciones++;
			System.out.println("solucion numero : "+numeroSoluciones+"\n");
			mostrarTablero(solucion);
			System.out.println("\n");
		}
		else{
			for(int columna = 0 ; columna < nReinas ; columna++){
				if(cumpleRestricciones(solucion,etapa,columna)){
					solucion[etapa][columna] = etapa+1;
					boolean exito= BacktrackingTodasSoluciones(solucion, etapa+1);

					if(exito)return true;
					else solucion[etapa][columna] = 0;
				}
			}
		}
		return false;
	}

	public static void main(String args[]){

		int [][] solucion = new int[nReinas][nReinas];
		inicializarTablero(solucion, 0);
		BacktrackingTodasSoluciones(solucion, 0);
		System.out.println("se han encontrado un total de : "+numeroSoluciones + "soluciones diferentes");




	}


}
