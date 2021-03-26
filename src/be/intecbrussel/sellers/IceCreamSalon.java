package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller{
    private final PriceList priceList;
    private double totalProfit = 0;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        this.totalProfit += (balls != null && balls.length > 0) 
                ? (this.priceList.getBallPrice() * balls.length) 
                : this.priceList.getBallPrice();

        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        this.totalProfit += this.priceList.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        this.totalProfit += this.priceList.getMagnumPrice(magnumType);
        return new Magnum(magnumType);
    }

    @Override
    public double getProfit() {
        return this.totalProfit;
    }

    @Override
    public String toString(){
        return "The pricelist: €" + this.priceList.getMagnumPrice(Magnum.MagnumType.ALPINENUTS) + " for a standard magnum, €" +
                this.priceList.getRocketPrice() + " for a rocket and €" + this.priceList.getBallPrice() + " per scoop of ice cream." +
                " The total profit of the day is € " + this.totalProfit + ".";
    }
}
