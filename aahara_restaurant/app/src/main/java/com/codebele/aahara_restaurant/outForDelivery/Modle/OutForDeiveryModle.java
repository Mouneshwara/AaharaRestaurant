package com.codebele.aahara_restaurant.outForDelivery.Modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OutForDeiveryModle {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("sk_order_id")
        @Expose
        private String skOrderId;
        @SerializedName("restuarant_id")
        @Expose
        private String restuarantId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("order_status")
        @Expose
        private String orderStatus;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("item_name")
        @Expose
        private String itemName;
        @SerializedName("item_type")
        @Expose
        private String itemType;
        @SerializedName("actual_price")
        @Expose
        private String actualPrice;
        @SerializedName("payment_mode")
        @Expose
        private String paymentMode;
        @SerializedName("item")
        @Expose
        private List<Item> item = null;

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getSkOrderId() {
            return skOrderId;
        }

        public void setSkOrderId(String skOrderId) {
            this.skOrderId = skOrderId;
        }

        public String getRestuarantId() {
            return restuarantId;
        }

        public void setRestuarantId(String restuarantId) {
            this.restuarantId = restuarantId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getActualPrice() {
            return actualPrice;
        }

        public void setActualPrice(String actualPrice) {
            this.actualPrice = actualPrice;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }

    }
    public class Item {

        @SerializedName("item_name")
        @Expose
        private String itemName;
        @SerializedName("sk_items_id")
        @Expose
        private String skItemsId;
        @SerializedName("item_type")
        @Expose
        private String itemType;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getSkItemsId() {
            return skItemsId;
        }

        public void setSkItemsId(String skItemsId) {
            this.skItemsId = skItemsId;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

    }
}
