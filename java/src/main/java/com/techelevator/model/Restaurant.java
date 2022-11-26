package com.techelevator.model;

import java.util.Arrays;
import java.util.Objects;

public class Restaurant {

    private Long restaurantId;
    private String restaurantName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private int rating;
    private String slogan;
    private String description;
    private String image;
    private String open;
    private String close;
    private String category;
    private String typeOfFood;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return getRating() == that.getRating() && getRestaurantId().equals(that.getRestaurantId()) && Objects.equals(getRestaurantName(), that.getRestaurantName()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(getSlogan(), that.getSlogan()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getImage(), that.getImage()) && Objects.equals(getOpen(), that.getOpen()) && Objects.equals(getClose(), that.getClose()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getTypeOfFood(), that.getTypeOfFood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRestaurantId(), getRestaurantName(), getPhoneNumber(), getEmail(), getAddress(), getCity(), getState(), getZipCode(), getRating(), getSlogan(), getDescription(), getImage(), getOpen(), getClose(), getCategory(), getTypeOfFood());
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", rating=" + rating +
                ", slogan='" + slogan + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                ", category='" + category + '\'' +
                ", typeOfFood='" + typeOfFood + '\'' +
                '}';
    }

}
