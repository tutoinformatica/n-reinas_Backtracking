




public class nReinas {

	/*
	 * Parametros importantes :
	 * nReinas -> especifica el numero de reinas que queremos colocar
	 * etapa -> fila en la que se encuentra en  cada momento el algoritmo hay que 
	 * inicializar a 0
	 */


	
	static final int nReinas = 4;
	
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
	public static boolean BacktrackingUnaSolucion(int[][]solucion , int etapa){
		if(etapa == nReinas){
			mostrarTablero(solucion);
			return true;
		}
			for(int columna = 0 ; columna < nReinas ; columna++){
				if(cumpleRestricciones(solucion,etapa,columna)){
					solucion[etapa][columna] = etapa+1;
					boolean exito= BacktrackingUnaSolucion(solucion, etapa+1);
					
					if(exito)return true;
					else solucion[etapa][columna] = 0;
				}
			}
		return false;
	}
	public static boolean BacktrackingTodasSoluciones(int[][] solucion , int etapa){
		
		if(etapa == nReinas){
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
		BacktrackingUnaSolucion(solucion, 0);
		
	}
	
	
}
