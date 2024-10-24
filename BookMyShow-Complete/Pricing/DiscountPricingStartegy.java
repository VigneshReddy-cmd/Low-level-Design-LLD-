package Pricing;

public class DiscountPricingStartegy implements PricingStatergy{

    @Override
    public double CalculatePrice(double basePrice) {
       return basePrice*0.5;
    }

    

}
