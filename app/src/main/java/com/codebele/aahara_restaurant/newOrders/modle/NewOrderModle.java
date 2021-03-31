package com.codebele.aahara_restaurant.newOrders.modle;

public class NewOrderModle {
    String hotelName,address,amount,items,date;

    public NewOrderModle(String hotelName, String address, String amount, String items, String date) {
        this.hotelName = hotelName;
        this.address = address;
        this.amount = amount;
        this.items = items;
        this.date = date;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
