package com.tacoloco.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacoloco.service.constant.ItemPrices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TacoCalculateOrderItem {

    private static final Logger LOGGER = LoggerFactory.getLogger(TacoCalculateOrderItem.class.getName());

    @JsonProperty
    private int veggie;
    @JsonProperty
    private int chicken;
    @JsonProperty
    private int beef;
    @JsonProperty
    private int chorizo;

    /**
     * @return the veggie
     */
    public int getVeggie() {
        return veggie;
    }

    /**
     * @param veggie the veggie to set
     */
    public void setVeggie(int veggie) {
        this.veggie = veggie;
    }

    /**
     * @return the chicken
     */
    public int getChicken() {
        return chicken;
    }

    /**
     * @param chicken the chicken to set
     */
    public void setChicken(int chicken) {
        this.chicken = chicken;
    }

    /**
     * @return the beef
     */
    public int getBeef() {
        return beef;
    }

    /**
     * @param beef the beef to set
     */
    public void setBeef(int beef) {
        this.beef = beef;
    }

    /**
     * @return the chorizo
     */
    public int getChorizo() {
        return chorizo;
    }

    /**
     * @param chorizo the chorizo to set
     */
    public void setChorizo(int chorizo) {
        this.chorizo = chorizo;
    }

    public double getCalculateOrderTotal() {
        LOGGER.info("--- getCalculateOrderTotal() INVOKED---");
        int tacoOrderTotal = 0;
        tacoOrderTotal = veggie + chicken + beef + chorizo;
        LOGGER.info("--- TACO ORDER TOTAL::$" + tacoOrderTotal + " ---");
        double discount_20PERCENT = 0;
        if (tacoOrderTotal >= 4) {
            LOGGER.info("--- DISCOUNT APPLIED ---");
            discount_20PERCENT = 20.0 / 100; // 20%
        }

        double totalVeggieTaco = veggie * ItemPrices.TACO_VEGGIE_PRICE;
        double totalChickenTaco = chicken * ItemPrices.TACO_CHICKEN_PRICE;
        double totalBeefTaco = beef * ItemPrices.TACO_BEEF_PRICE;
        double totalChorizoTaco = chorizo * ItemPrices.TACO_CHORIZO_PRICE;
        double grandTotal = totalVeggieTaco + totalChickenTaco + totalBeefTaco + totalChorizoTaco;
        double totalPriceWithDiscounted = grandTotal - (discount_20PERCENT * grandTotal);
        LOGGER.info("--- GRAND TACO ORDER TOTAL::$" + totalPriceWithDiscounted + " ---");
        return totalPriceWithDiscounted;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + beef;
        result = prime * result + chicken;
        result = prime * result + chorizo;
        result = prime * result + veggie;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TacoCalculateOrderItem other = (TacoCalculateOrderItem) obj;
        if (beef != other.beef)
            return false;
        if (chicken != other.chicken)
            return false;
        if (chorizo != other.chorizo)
            return false;
        return veggie == other.veggie;
    }

    @Override
    public String toString() {
        return "TacoCalculateOrderItem [veggie=" + veggie + ", chicken=" + chicken + ", beef=" + beef + ", chorizo="
                + chorizo + "]";
    }
}
