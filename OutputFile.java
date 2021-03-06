import java.io.*;
import java.util.*;
public class OutputFile {
    String name = "";
    public OutputFile(String s){
           this.name = s;
        }
    public int getScore( ArrayList<Slice> resp) throws Exception{ 
        int score = 0;
        int trozosvacios = 0;
        for(Slice aux : resp){
            score = aux.getScore()+score;
        }
        return score;
    }
    public int printPizza( ArrayList<Slice> resp) throws Exception{
       //double name = Math.random();
       int trozosvacios = 0;
       int score = 0;
       //System.out.println();     
       PrintWriter writer = new PrintWriter("Respuesta_"+name+".txt");     
       writer.println(resp.size()-trozosvacios+"");
       for(Slice aux : resp){
           try{
                //System.out.println(aux.get(0).posx+" "+aux.get(0).posy+" "+aux.get(aux.getScore()-1).posx+" "+aux.get(aux.getScore()-1).posy+" ");
                writer.println(aux.get(0).posx+" "+aux.get(0).posy+" "+aux.get(aux.getScore()-1).posx+" "+aux.get(aux.getScore()-1).posy+" ");
           }catch(Exception e){
                    trozosvacios++;
           }
           //System.out.println(aux.toString());           
            score = aux.getScore()+score;
        }
       writer.close();
       System.out.println("Trozos buenos: "+(resp.size()-trozosvacios));   
       System.out.println("Trozos vacios: "+trozosvacios);
       return score;
    }   
    public void printMatrix(char[][] matrix){
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
