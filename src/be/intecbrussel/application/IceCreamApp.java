package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

public class IceCreamApp {
    public static void main(String[] args)  {
        PriceList priceList = new PriceList(1.5,1.75,2);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);
        Cone.Flavor[] flavors = {Cone.Flavor.LEMON, Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.STRAWBERRY};
        Eatable[] eatables = {iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS), iceCreamSalon.orderIceRocket(), iceCreamSalon.orderCone(flavors)};

        for(int i = 0; i < eatables.length; i++){
            eatables[i].eat();
        }
        System.out.println();
        System.out.println("The profit you've made is " + iceCreamSalon.getProfit());
    }
}
