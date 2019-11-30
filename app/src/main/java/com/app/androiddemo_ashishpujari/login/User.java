package com.app.androiddemo_ashishpujari.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class User {

    public class Datum {

        @SerializedName("token_type")
        @Expose
        private String tokenType;
        @SerializedName("refresh_token")
        @Expose
        private String refreshToken;
        @SerializedName("expires_in")
        @Expose
        private String expiresIn;
        @SerializedName("scope")
        @Expose
        private String scope;
        @SerializedName("isAllowed")
        @Expose
        private Boolean isAllowed;
        @SerializedName("isFirstLoginStatus")
        @Expose
        private Boolean isFirstLoginStatus;
        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("mobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("isOtpVerifiedStatus")
        @Expose
        private Boolean isOtpVerifiedStatus;
        @SerializedName("userType")
        @Expose
        private String userType;
        @SerializedName("profilePicUrl")
        @Expose
        private String profilePicUrl;
        @SerializedName("roles")
        @Expose
        private List<String> roles = null;
        @SerializedName("appLanguagePref")
        @Expose
        private String appLanguagePref;
        @SerializedName("access_token")
        @Expose
        private String accessToken;

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public Boolean getIsAllowed() {
            return isAllowed;
        }

        public void setIsAllowed(Boolean isAllowed) {
            this.isAllowed = isAllowed;
        }

        public Boolean getIsFirstLoginStatus() {
            return isFirstLoginStatus;
        }

        public void setIsFirstLoginStatus(Boolean isFirstLoginStatus) {
            this.isFirstLoginStatus = isFirstLoginStatus;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public Boolean getIsOtpVerifiedStatus() {
            return isOtpVerifiedStatus;
        }

        public void setIsOtpVerifiedStatus(Boolean isOtpVerifiedStatus) {
            this.isOtpVerifiedStatus = isOtpVerifiedStatus;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getProfilePicUrl() {
            return profilePicUrl;
        }

        public void setProfilePicUrl(String profilePicUrl) {
            this.profilePicUrl = profilePicUrl;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public String getAppLanguagePref() {
            return appLanguagePref;
        }

        public void setAppLanguagePref(String appLanguagePref) {
            this.appLanguagePref = appLanguagePref;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

    }

    public class UserModel {

        @SerializedName("status")
        @Expose
        private Boolean status;
        @SerializedName("statusCode")
        @Expose
        private Integer statusCode;
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

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
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

    }
}
