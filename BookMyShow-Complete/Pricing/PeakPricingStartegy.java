package Pricing;

public class PeakPricingStartegy implements PricingStatergy {

    @Override
    public double CalculatePrice(double basePrice) {
        return basePrice*2;
    }

}
