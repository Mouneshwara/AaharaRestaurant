package com.codebele.aahara_restaurant.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModle {
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


        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("sk_restaurant_id")
        @Expose
        private String skRestaurantId;
        @SerializedName("restuarantId")
        @Expose
        private String restuarantId;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getSkRestaurantId() {
            return skRestaurantId;
        }

        public void setSkRestaurantId(String skRestaurantId) {
            this.skRestaurantId = skRestaurantId;
        }

        public String getRestuarantId() {
            return restuarantId;
        }

        public void setRestuarantId(String restuarantId) {
            this.restuarantId = restuarantId;
        }

    }
}
