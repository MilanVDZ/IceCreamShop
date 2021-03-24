package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(1.5,1.75,2);
        Stock stock = new Stock();
        stock.setMagni(2);
        stock.setIceRockets(2);
        stock.setBalls(2);
        stock.setCones(2);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList,stock);

        try {
            Cone.Flavor[] balls = {Cone.Flavor.LEMON, Cone.Flavor.BANANA, Cone.Flavor.STRACIATELLA, Cone.Flavor.STRAWBERRY,Cone.Flavor.PISTACHE};
            Eatable[] eatables = {iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS), iceCreamCar.orderIceRocket(), iceCreamCar.orderCone(balls)};
            for (Eatable order : eatables) {
                order.eat();
            }
        } catch (NoMoreIceCreamException nmice) {
            System.out.println(nmice.getMessage());
            nmice.printStackTrace();
        }
    }
}
