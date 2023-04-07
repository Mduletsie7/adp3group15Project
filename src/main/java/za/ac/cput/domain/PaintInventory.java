package za.ac.cput.domain;

import java.util.Objects;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Assignment 1
 * due date: 09/04/2023
 * */
public class PaintInventory {
    private String colorId;
    private String transHistory;
    private  String amtAvailable;

    public PaintInventory() {
    }

    public PaintInventory(Builder builder) {
        this.colorId = colorId;
        this.transHistory = transHistory;
        this.amtAvailable = amtAvailable;
    }

    public String getColorId() {
        return colorId;
    }
    public String getTransHistory() {
        return transHistory;
    }
    public String getAmtAvailable() {
        return amtAvailable;
    }
    private class Builder {
        private String colorId;
        private String transHistory;
        private  String amtAvailable;
        public Builder setColorId(String colorId) {
            this.colorId = colorId;
            return this;
        }
        public Builder setTransHistory(String transHistory) {
            this.transHistory = transHistory;
            return this;
        }
        public void setAmtAvailable(String amtAvailable) {
            this.amtAvailable = amtAvailable;
        }

        public Builder copy(PaintInventory paintInventory) {
            this.colorId = paintInventory.colorId;
            this.transHistory = paintInventory.transHistory;
            this.amtAvailable = paintInventory.amtAvailable;
            return this;
        }
        public PaintInventory build(){return new PaintInventory(this);}
    }
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        PaintInventory paintInventory = (PaintInventory) obj;
        return Objects.equals(colorId, paintInventory.colorId)&& Objects.equals(transHistory, paintInventory.transHistory)&& Objects.equals(amtAvailable, paintInventory.amtAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, transHistory, amtAvailable);
    }

    @Override
    public String toString() {
        return "PaintInventory{" +
                "colorId='" + colorId + '\'' +
                ", transHistory='" + transHistory + '\'' +
                ", amtAvailable='" + amtAvailable + '\'' +
                '}';
    }
}
