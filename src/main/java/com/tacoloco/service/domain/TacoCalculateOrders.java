package com.tacoloco.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacoloco.service.constant.ItemPrices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TacoCalculateOrders {

    private static final Logger LOGGER = LoggerFactory.getLogger(TacoCalculateOrders.class.getName());

    @JsonProperty
    private long tacoOrderId;
    @JsonProperty
    private TacoLoco[] tacoLocoArray;

    /**
     * @return the tacoOrderId
     */
    public long getTacoOrderId() {
        return tacoOrderId;
    }

    /**
     * @param tacoOrderId the tacoOrderId to set
     */
    public void setTacoOrderId(long tacoOrderId) {
        this.tacoOrderId = tacoOrderId;
    }

    /**
     * @return the tacoLocosArray
     */
    public TacoLoco[] getTacoLocoArray() {
        return tacoLocoArray;
    }

    /**
     * @param tacoLocoArray the tacoLocosArray to set
     */
    public void setTacoLocosArray(TacoLoco[] tacoLocoArray) {
        this.tacoLocoArray = tacoLocoArray;

    }

    // Order total response

    public double getTacoOrderTotal() {
        LOGGER.info("---getTacoOrderTotal() INVOKED---");
        double tacoOrderTotal = 0;
        int numberOfTotalOrderQuantity = 0;
        for (TacoLoco tacoLoco : tacoLocoArray) {
            double tacoPrice = 0;
            if (tacoLoco.getTacoItemName().equalsIgnoreCase("veggie taco")) {
                LOGGER.info("-----VEGGIE TACO PRICE CALCULATION...----");
                tacoPrice = tacoLoco.getTacoItemQuantity() * ItemPrices.TACO_VEGGIE_PRICE;
                numberOfTotalOrderQuantity += tacoLoco.getTacoItemQuantity();
                LOGGER.info("--- TACO PRICE:: $" + tacoPrice + " ea AND ORDER QUANTITY:: " + numberOfTotalOrderQuantity
                        + "  ---");

            } else if (tacoLoco.getTacoItemName().equalsIgnoreCase("chicken taco")) {
                LOGGER.info("-----CHICKEN TACO PRICE CALCULATION...----");
                tacoPrice = tacoLoco.getTacoItemQuantity() * ItemPrices.TACO_CHICKEN_PRICE;
                numberOfTotalOrderQuantity += tacoLoco.getTacoItemQuantity();
                LOGGER.info("--- TACO PRICE:: $" + tacoPrice + " ea AND ORDER QUANTITY:: " + numberOfTotalOrderQuantity
                        + "  ---");

            } else if (tacoLoco.getTacoItemName().equalsIgnoreCase("beef taco")) {
                LOGGER.info("-----BEEF TACO PRICE CALCULATION...----");
                tacoPrice = tacoLoco.getTacoItemQuantity() * ItemPrices.TACO_BEEF_PRICE;
                numberOfTotalOrderQuantity += tacoLoco.getTacoItemQuantity();
                LOGGER.info("--- TACO PRICE:: $" + tacoPrice + " ea AND ORDER QUANTITY:: " + numberOfTotalOrderQuantity
                        + "  ---");

            } else if (tacoLoco.getTacoItemName().equalsIgnoreCase("chorizo taco")) {
                LOGGER.info("-----CHORIZO TACO PRICE CALCULATION...----");
                tacoPrice = tacoLoco.getTacoItemQuantity() * ItemPrices.TACO_CHORIZO_PRICE;
                numberOfTotalOrderQuantity += tacoLoco.getTacoItemQuantity();
                LOGGER.info("--- TACO PRICE:: $" + tacoPrice + " ea AND ORDER QUANTITY:: " + numberOfTotalOrderQuantity
                        + "  ---");

            }
            tacoOrderTotal += tacoPrice;
        }
        // Check condition for discount
        if (numberOfTotalOrderQuantity >= 4) {
            LOGGER.info("-----20% DISCOUNT APPLIED..----");
            double discount_20PERCENT = 0.2;
            tacoOrderTotal -= (discount_20PERCENT * tacoOrderTotal);
            LOGGER.info("-----TACO ORDER TOTAL:: $" + tacoOrderTotal + " ----");
        }
        return tacoOrderTotal;

    }
}
