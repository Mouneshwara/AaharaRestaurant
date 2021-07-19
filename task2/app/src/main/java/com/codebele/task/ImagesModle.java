package com.codebele.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImagesModle {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("home_page")
    @Expose
    private List<HomePage> homePage = null;
    @SerializedName("base_path")
    @Expose
    private String basePath;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HomePage> getHomePage() {
        return homePage;
    }

    public void setHomePage(List<HomePage> homePage) {
        this.homePage = homePage;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    public class FavDetail {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("item_id")
        @Expose
        private String itemId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("favourite_status")
        @Expose
        private String favouriteStatus;
        @SerializedName("date")
        @Expose
        private String date;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFavouriteStatus() {
            return favouriteStatus;
        }

        public void setFavouriteStatus(String favouriteStatus) {
            this.favouriteStatus = favouriteStatus;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }
    public class HomePage {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("sub_cat_id")
        @Expose
        private String subCatId;
        @SerializedName("post_type")
        @Expose
        private String postType;
        @SerializedName("item_condition_id")
        @Expose
        private String itemConditionId;
        @SerializedName("color_id")
        @Expose
        private String colorId;
        @SerializedName("size_id")
        @Expose
        private String sizeId;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("brest")
        @Expose
        private String brest;
        @SerializedName("waist")
        @Expose
        private String waist;
        @SerializedName("tight")
        @Expose
        private String tight;
        @SerializedName("sales_rental")
        @Expose
        private String salesRental;
        @SerializedName("city_id")
        @Expose
        private String cityId;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("note")
        @Expose
        private String note;
        @SerializedName("cover_image")
        @Expose
        private String coverImage;
        @SerializedName("posting_status")
        @Expose
        private String postingStatus;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("delete_status")
        @Expose
        private String deleteStatus;
        @SerializedName("admin_commission")
        @Expose
        private String adminCommission;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("item_date")
        @Expose
        private String itemDate;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("sub_category_name")
        @Expose
        private String subCategoryName;
        @SerializedName("city_name")
        @Expose
        private String cityName;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("profile_pic")
        @Expose
        private String profilePic;
        @SerializedName("item_condition")
        @Expose
        private String itemCondition;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("product_images")
        @Expose
        private List<ProductImage> productImages = null;
        @SerializedName("fav_details")
        @Expose
        private List<FavDetail> favDetails = null;
        @SerializedName("width")
        @Expose
        private Integer width;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getSubCatId() {
            return subCatId;
        }

        public void setSubCatId(String subCatId) {
            this.subCatId = subCatId;
        }

        public String getPostType() {
            return postType;
        }

        public void setPostType(String postType) {
            this.postType = postType;
        }

        public String getItemConditionId() {
            return itemConditionId;
        }

        public void setItemConditionId(String itemConditionId) {
            this.itemConditionId = itemConditionId;
        }

        public String getColorId() {
            return colorId;
        }

        public void setColorId(String colorId) {
            this.colorId = colorId;
        }

        public String getSizeId() {
            return sizeId;
        }

        public void setSizeId(String sizeId) {
            this.sizeId = sizeId;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getBrest() {
            return brest;
        }

        public void setBrest(String brest) {
            this.brest = brest;
        }

        public String getWaist() {
            return waist;
        }

        public void setWaist(String waist) {
            this.waist = waist;
        }

        public String getTight() {
            return tight;
        }

        public void setTight(String tight) {
            this.tight = tight;
        }

        public String getSalesRental() {
            return salesRental;
        }

        public void setSalesRental(String salesRental) {
            this.salesRental = salesRental;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public String getPostingStatus() {
            return postingStatus;
        }

        public void setPostingStatus(String postingStatus) {
            this.postingStatus = postingStatus;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDeleteStatus() {
            return deleteStatus;
        }

        public void setDeleteStatus(String deleteStatus) {
            this.deleteStatus = deleteStatus;
        }

        public String getAdminCommission() {
            return adminCommission;
        }

        public void setAdminCommission(String adminCommission) {
            this.adminCommission = adminCommission;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getItemDate() {
            return itemDate;
        }

        public void setItemDate(String itemDate) {
            this.itemDate = itemDate;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getProfilePic() {
            return profilePic;
        }

        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        public String getItemCondition() {
            return itemCondition;
        }

        public void setItemCondition(String itemCondition) {
            this.itemCondition = itemCondition;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<ProductImage> getProductImages() {
            return productImages;
        }

        public void setProductImages(List<ProductImage> productImages) {
            this.productImages = productImages;
        }

        public List<FavDetail> getFavDetails() {
            return favDetails;
        }

        public void setFavDetails(List<FavDetail> favDetails) {
            this.favDetails = favDetails;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

    }
    public class ProductImage {

        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("image_id")
        @Expose
        private String imageId;
        @SerializedName("images")
        @Expose
        private String images;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

    }
}
