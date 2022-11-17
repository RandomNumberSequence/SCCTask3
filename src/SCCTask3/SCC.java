package SCCTask3;


import java.io.*;
import java.util.*;


public class SCC {
	
	static int[][] adjacencyMatrix;
	static int[][] invertedAdjacencyMatrix;
	static VerticeColor[] coloredVertices;
	static int numVertices = 1000;
	static int[] distanceToSource;
	
	enum VerticeColor{
		WHITE,
		GREY,
		BLACK
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "big_graph.csv";
		String line;
		String[] splitLine;
		
		int counter = 0;
		BufferedReader br;
		
		//System.out.println("Dateipfad: \n");
		//filePath = System.console().readLine();
		
		//System.out.println("Wieviele Knoten hat der Graph: \n");
		//numVertices = Integer.parseInt(System.console().readLine());
		
		adjacencyMatrix = new int[numVertices][numVertices];
		invertedAdjacencyMatrix = new int[numVertices][numVertices];
		coloredVertices = new VerticeColor[numVertices];
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			while(br.ready()) {
				line = br.readLine();
				splitLine = line.split(",");
				for(int i = 0; i < numVertices; i++) {
					adjacencyMatrix[counter][i] = Integer.parseInt(splitLine[i]);
				}
				counter++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//for(int i = 0; i < array.length; i++) {
		//	for(int j = 0; j < array[i].length; j++) {
		//		System.out.print(array[i][j]);
		//	}
		//	System.out.println();
		//}
		
		for(int i = 0; i < adjacencyMatrix.length; i++) {
			for(int j = 0; j < adjacencyMatrix[i].length; j++) {
				invertedAdjacencyMatrix[j][i] = adjacencyMatrix[i][j];
			}
		}
		
		
	}
	
	public void resetColoredVertices() {
		for(VerticeColor c: coloredVertices) {	
				c = VerticeColor.WHITE;
		}
	}
	
	public void DFS(int[][] matrix) {
		resetColoredVertices();
		for(int i = 0; i < numVertices; i++) {
			if(coloredVertices[i] == VerticeColor.WHITE) {
				DFSVisit(matrix, i, 0);
			}
		}
	}
	
	public void DFSVisit(int[][] matrix, int src, int distance){
		coloredVertices[src] = VerticeColor.GREY;
		distanceToSource[src] = distance;
		for(int i : matrix[src]) {
			if(matrix[src][i] == 1) {
				if(coloredVertices[i] == VerticeColor.WHITE) {
					DFSVisit(matrix, i, distance++);
				}
			}		
		}
		coloredVertices[src] = VerticeColor.BLACK;
	}

}
