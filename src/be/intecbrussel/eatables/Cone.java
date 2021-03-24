package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable {

    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE
    }

    private Flavor[] balls;

    public Cone(){

    }

    public Cone(Flavor[] balls){
        this.balls = balls;
    }

    //EXTRA: Lowercase en laatste komma vervangen met een "en"
    private String cleanString(){
        String string = "I'm eating an ice cream with ";
        for(int i = 0; i < this.balls.length; i++){
            if(i == this.balls.length - 2){
                string += this.balls[i].toString().toLowerCase() + " and ";
            } else if(i == this.balls.length - 1) {
                string += this.balls[i].toString().toLowerCase();
            }else string += this.balls[i].toString().toLowerCase() + ", ";
        }
        string += " tastes.";
        return string;
    }

    @Override
    public void eat() {
        System.out.println(cleanString());
    }
}
