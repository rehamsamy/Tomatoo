package com.tomatoo.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginModel {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("token")
    private String token;
    @SerializedName("user")
    private User user;
    @SerializedName("message")
    private String message;


    // Getters
    public Boolean getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public String getMessages() {
        return message;
    }


    // ------------ USER Class -------------
    public static class User implements Parcelable{
        @SerializedName("id")
        private Integer id;
        @SerializedName("username")
        private String username;
        @SerializedName("email")
        private String email;
        @SerializedName("Mobile")
        private String Mobile;
        @SerializedName("user_image")
        private String user_image;
        @SerializedName("BalanceAmount")
        private float BalanceAmount;
        @SerializedName("Country")
        private String Country;
        @SerializedName("City")
        private String City;
        @SerializedName("Address")
        private String Address;
        @SerializedName("building_no")
        private String building_no;
        @SerializedName("floor_no")
        private String floor_no;
        @SerializedName("apartment_no")
        private String apartment_no;
        @SerializedName("villa_no")
        private String villa_no;
        @SerializedName("other")
        private String other;

        protected User(Parcel in) {
            if (in.readByte() == 0) {
                id = null;
            } else {
                id = in.readInt();
            }
            username = in.readString();
            email = in.readString();
            Mobile = in.readString();
            user_image = in.readString();
            BalanceAmount = in.readFloat();
            Country = in.readString();
            City = in.readString();
            Address = in.readString();
            building_no = in.readString();
            floor_no = in.readString();
            apartment_no = in.readString();
            villa_no = in.readString();
            other = in.readString();
        }

        public static final Creator<User> CREATOR = new Creator<User>() {
            @Override
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };

        // Getter and Setters
        public Integer getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return Mobile;
        }

        public String getUser_image() {
            return user_image;
        }

        public float getBalanceAmount() {
            return BalanceAmount;
        }

        public String getCountry() {
            return Country;
        }

        public String getCity() {
            return City;
        }

        public String getAddress() {
            return Address;
        }

        public String getBuilding_no() {
            return building_no;
        }

        public String getFloor_no() {
            return floor_no;
        }

        public String getApartment_no() {
            return apartment_no;
        }

        public String getVilla_no() {
            return villa_no;
        }

        public String getOther() {
            return other;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (id == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(id);
            }
            dest.writeString(username);
            dest.writeString(email);
            dest.writeString(Mobile);
            dest.writeString(user_image);
            dest.writeFloat(BalanceAmount);
            dest.writeString(Country);
            dest.writeString(City);
            dest.writeString(Address);
            dest.writeString(building_no);
            dest.writeString(floor_no);
            dest.writeString(apartment_no);
            dest.writeString(villa_no);
            dest.writeString(other);
        }
    }
}
