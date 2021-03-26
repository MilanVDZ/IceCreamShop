package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {
    private final PriceList priceList;
    private final Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) throws NoMoreIceCreamException {
        // TODO: split the logic ..
        // orderCode : totalProfit..
        return prepareCone(balls);
    }

    private Cone prepareCone(Cone.Flavor[] balls) throws NoMoreIceCreamException{
        // TODO: stock management..

        if(this.stock.getCones() <= 0 || this.stock.getBalls() <= 0) throw new NoMoreIceCreamException("There are no more cones!");

        Cone cone = new Cone(balls);
        this.stock.setCones(this.stock.getCones() - 1);
        this.stock.setBalls(this.stock.getBalls() - balls.length);
        
        this.profit += (balls != null && balls.length > 0) 
                        ? (this.priceList.getBallPrice() * balls.length) 
                        : priceList.getBallPrice();
        return cone;
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        // TODO: split logic ..
        return prepareRocket();
    }

    private IceRocket prepareRocket() throws NoMoreIceCreamException{
      
        if(this.stock.getIceRockets() <= 0)throw new NoMoreIceCreamException("There are no more ice rockets!");

        IceRocket iceRocket = new IceRocket();
        this.stock.setIceRockets(this.stock.getIceRockets() - 1);
        this.profit += this.priceList.getRocketPrice();
        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        // TODO: split logic ..
        return prepareMagnum(magnumType);
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException{
        
        if(this.stock.getMagni() <= 0) throw new NoMoreIceCreamException("There are no more magnums!");

        Magnum magnum = new Magnum(magnumType);
        this.stock.setMagni(this.stock.getMagni() - 1);
        this.profit += this.priceList.getMagnumPrice(magnumType);
        return magnum;
    }

    @Override
    public double getProfit() {
        return this.profit;
    }
}
