public class Tondeuse {


    private char orientation ;
    private int x ;
    private int y ;
    private static Pelouse pelouse;


    public Tondeuse() {

    }

    public Tondeuse(int x, int y,char orientation,Pelouse pelouse) {
        this.orientation = orientation;
        this.x = x;
        this.y = y;
        this.pelouse = pelouse;
    }




    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public static Pelouse getPelouse() {
        return pelouse;
    }

    public static void setPelouse(Pelouse pelouse) {
        Tondeuse.pelouse = pelouse;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }




    public void deplacement(String deplacement){
        char etapes[]= deplacement.toCharArray();
        for(Character etape : etapes) {
            if ((etape == 'D') || (etape == 'G')){
                pivot(etape);
            }
            if (etape == 'A'){
                avancer();
            }
        }
    }



    public void pivot(char pivot){
        if('D' == pivot){
            if(this.orientation=='N'){
                this.orientation ='E';
            }else if(this.orientation=='E'){
                this.orientation ='S';
            }else if(this.orientation=='S'){
                this.orientation ='W';
            }else if(this.orientation=='W'){
                this.orientation ='N';
            }
        }
        if('G' == pivot){
            if(this.orientation=='N'){
                this.orientation ='W';
            }else if(this.orientation=='E'){
                this.orientation ='N';
            }else if(this.orientation=='S'){
                this.orientation ='E';
            }else if(this.orientation=='W'){
                this.orientation ='S';
            }
        }

    }

    public void avancer(){
        if(this.orientation=='N')  {
            if(this.y<this.pelouse.getLimitation_Y())
                this.y++;
        }else if(this.orientation=='E'){
            if(this.x<this.pelouse.getLimitation_X())
                this.x++;
        }else if(this.orientation=='S'){
            if(this.y>0)
                this.y--;
        }else if(this.orientation=='W'){
            if(this.x>0)
                this.x--;
        }

    }


    @Override
    public String toString() {
        return   x +
                " "+
                 y +
                " "+
                orientation ;
    }
}//Tondeuse
