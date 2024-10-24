package Pricing;

public class OffPeakPricingStartegy  implements PricingStatergy{

    @Override
    public double CalculatePrice(double basePrice) {
        return basePrice*0.9;
    }
    

}
