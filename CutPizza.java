
/**
 * Write a description of class CutPizza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CutPizza
{
    static int[][] pizzaOne = {{1,1,1,1},{1,2,1,1},{1,2,1,2},{1,2,1,1},{1,1,1,1},{2,2,2,1}};
    static int[][] pizzaTwo = {{1,1,1,1},{1,2,1,1},{1,2,1,2},{1,2,1,1},{1,1,1,1},{2,2,2,1}};
    static int[][] pizzaThree = {{1,2,2,2,1,1,1},{2,2,2,2,1,2,2},{1,1,2,1,1,2,1},{1,2,2,1,2,2,2},{1,1,1,1,1,1,2},{1,1,1,1,1,1,2}};
    static int[][] pizzaFour = {{1,1,1,1},{1,2,1,1},{1,2,1,2},{1,2,1,1},{1,1,1,1},{2,2,2,1}};
    static int[][] googlepizza = null;
    static int score = 0;
    public CutPizza(int[][] googlepizza){
        this.googlepizza = googlepizza;
    }
    public static void main(String [] args){        
        int numChamp;
        int numTom;        
        numChamp = getIngredient(pizzaThree,2);
        numTom = getIngredient(pizzaThree,1);
        System.out.println("Champiñones: "+numChamp);
        System.out.println("Tomatitos  : "+numTom);
        System.out.println("---------------------");
        getSlices(20,numChamp,numTom,pizzaThree,5,1);
    }
    public static int getIngredient(int[][] pizza,int ingredient){
        int x = 0;
        for(int j = 0;j<pizza.length;j++){
            for(int i = 0;i<pizza[j].length;i++){
              if(ingredient == pizza[j][i] ){
                  x++;
                }                
            }
        }
        return x;
    }
    public static void getSlices(int numeroSlices,int champ,int tom,int[][] pizza,int max,int min){
        int[][] trozo = new int[pizza.length][pizza[2].length];
        int[][] pizzaRec;
        boolean hasMin = false;
        int minIn;
        int maxTrozos;
        int rectangles = 0;      
        int llevo_min = 0;
        boolean terminaya = false;
        if(champ > tom){
            minIn = tom;
        }
        else{
            minIn = champ;
        }
       maxTrozos = minIn/1;
        // poner en horizontal
        for(int m = 0;m<maxTrozos;m++){
        
        for(int j = 0;j<pizza.length;j++){
           for(int i = 0;i<pizza[j].length;i++){
                if(pizza[j][i] == -1){break;}
                trozo[j][i] = pizza[j][i];                 
                if(pizza[j][i] == 2){
                    terminaya = true;
                    hasMin = true;
                    llevo_min++;
                    minIn--;
                }
                if(minIn == 0){
                    terminaya = false;
                }
                if(m==numeroSlices-1){
                    terminaya = false;
                }
                rectangles++;
                pizza[j][i] = -1;
                if(rectangles == max){
                    if(llevo_min<min){
                        rectangles--;
                        trozo = quitarElprimero(trozo);
                    }else{
                        rectangles = 0;
                        llevo_min = 0;
                        if(terminaya){
                            System.out.println("Trozo");
                            hasMin = false;
                            terminaya = false;
                            rectangles = 0;
                            for(int js = 0;js<trozo.length;js++){
                                for(int is = 0;is<trozo[js].length;is++){
                                    if(trozo[js][is] != 0){
                                        System.out.print(trozo[js][is]);
                                        score++;
                                    }               
                                }  
                                if(trozo[js][0] != 0){
                                    System.out.println();
                                }
                            }
                            System.out.println();
                            trozo = new int[pizza.length][pizza[2].length];
                            if(pizza.length-j < max){
                                break;
                            }
                        }                        
                    }                                        
                }
                
            }             
        }  
        
        for(int j = 0;j<trozo.length;j++){
           for(int i = 0;i<trozo[j].length;i++){
               if(trozo[j][i] != 0){
                   System.out.print(trozo[j][i]);
                   score++;
                }               
            }  
           if(trozo[j][0] != 0){
                System.out.println();
           }
        }
        System.out.println();
        trozo = new int[pizza.length][pizza[2].length];
       }
       System.out.println(score);
    }
    public static int[][] quitarElprimero(int[][] trozo){
        boolean x = false;
        for(int i = 0;i<trozo.length;i++){
            for(int j = 0;j<trozo[0].length;j++){
                if(trozo[i][j] != 0){
                    trozo[i][j] = 0;      
                    x = true;
                    break;                    
                }                
            }
            if(x){break;}
        }
        return trozo;
    }
}
