package com.codebele.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KidsModle {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("base_path")
    @Expose
    private String basePath;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    public class Category {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("status")
        @Expose
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
}
