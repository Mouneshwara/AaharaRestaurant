package com.codebele.aahara_restaurant.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashBoardModle {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<CountItems> data = null;

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

    public List<CountItems> getData() {
        return data;
    }

    public void setData(List<CountItems> data) {
        this.data = data;
    }

    public class CountItems {

        @SerializedName("countPickedup")
        @Expose
        private Integer countPickedup;
        @SerializedName("countCancelled")
        @Expose
        private Integer countCancelled;
        @SerializedName("countDelivered")
        @Expose
        private Integer countDelivered;

        public Integer getCountPickedup() {
            return countPickedup;
        }

        public void setCountPickedup(Integer countPickedup) {
            this.countPickedup = countPickedup;
        }

        public Integer getCountCancelled() {
            return countCancelled;
        }

        public void setCountCancelled(Integer countCancelled) {
            this.countCancelled = countCancelled;
        }

        public Integer getCountDelivered() {
            return countDelivered;
        }

        public void setCountDelivered(Integer countDelivered) {
            this.countDelivered = countDelivered;
        }
    }
}

