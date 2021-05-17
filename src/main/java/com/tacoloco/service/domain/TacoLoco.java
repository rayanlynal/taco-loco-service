package com.tacoloco.service.domain;

public class TacoLoco {

    private long tacoId;
    private String tacoItemName;
    private int tacoItemQuantity;

    /**
     * @return the tacoId
     */
    public long getTacoId() {
        return tacoId;
    }

    /**
     * @param tacoId the tacoId to set
     */
    public void setTacoId(long tacoId) {
        this.tacoId = tacoId;
    }

    /**
     * @return the tacoItemName
     */
    public String getTacoItemName() {
        return tacoItemName;
    }

    /**
     * @param tacoItemName the tacoItemName to set
     */
    public void setTacoItemName(String tacoItemName) {
        this.tacoItemName = tacoItemName;
    }

    /**
     * @return the tacoItemQuantity
     */
    public int getTacoItemQuantity() {
        return tacoItemQuantity;
    }

    /**
     * @param tacoItemQuantity the tacoItemQuantity to set
     */
    public void setTacoItemQuantity(int tacoItemQuantity) {
        this.tacoItemQuantity = tacoItemQuantity;
    }

}
