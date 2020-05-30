class Diamond{
public static void main(String [] args){
        //top
        for(int i=1;i<=3;i++){
                for(int j=0;j<=5;j++){
                        if(4-i<=j&&j<=2+i){
                                System.out.print("*");
                         }else{
                                 System.out.print(" ");
        }//else
        } //for(j)
        System.out.println("");
        }//for(i)

        //bottom
        for(int i=1;i<=2;i++){
                for(int j=1;j<=5;j++){
                        if(2+i<=j&&j<=6-i) {
                                System.out.print("*");
                        }else{
                                System.out.print(" ");
        }//else
        }//for(j)
        System.out.println("");
        }//for(i)
        System.out.println("");
        }//diamond
        }