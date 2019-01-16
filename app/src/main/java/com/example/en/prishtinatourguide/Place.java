package com.example.en.prishtinatourguide;

/**
 * This class represents a place to be visited, an attraction, for visitors touring the city of Prishtina.
 */
public class Place {
    //Fields:

    //Save the name of the place
    private String mName;
    //Save geo coordinate location of the place
    private double mLatitude = NO_LAT_OR_LON;
    private double mLongitude = NO_LAT_OR_LON;
    //We can use 0.0 since no place in Prishtina, capital of Kosovo, has these coordinates.
    //Kosovo having latitude and longitude coordinates: 42.667542, 21.166191.
    private static final double NO_LAT_OR_LON = 0.0;
    //Picture of an attraction
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    //A constant to help with lists that doesn't contain any image, a reference value.
    private static final int NO_IMAGE_PROVIDED = -1;
    //Save a phone contact number
    private String mPhoneNumber = NO_SUCH_DETAIL_PROVIDED;
    //Save working hours
    private String mWorkingHours = NO_SUCH_DETAIL_PROVIDED;
    //A constant to help with lists that doesn't contain any, phone number or working hours, a reference value.
    private static final String NO_SUCH_DETAIL_PROVIDED = "";

    //Constructors:

    /**
     * Create a new {@link Place} object with the name and geo location
     *
     * @param nameOfPlace
     * @param latitude
     * @param longitude
     * @param workingHours
     */
    public Place(String nameOfPlace, double latitude, double longitude, String workingHours) {
        this.mName = nameOfPlace;
        this.mLongitude = longitude;
        this.mLatitude = latitude;
        this.mWorkingHours = workingHours;
    }

    /**
     * Create a new {@link Place} object with the name, image and geo location
     *
     * @param nameOfPlace
     * @param imageResource
     * @param latitude
     * @param longitude
     */
    public Place(String nameOfPlace, int imageResource, double latitude, double longitude) {
        this.mName = nameOfPlace;
        this.mLongitude = longitude;
        this.mLatitude = latitude;
        this.mImageResourceID = imageResource;
    }

    /**
     * Create a new {@link Place} object with the name, image, phone number, working hours and geo location.
     *
     * @param nameOfPlace
     * @param phoneNumber
     * @param workingHours
     * @param latitude
     * @param longitude
     */
    public Place(String nameOfPlace,String phoneNumber, String workingHours, double latitude, double longitude) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mName = nameOfPlace;
        this.mPhoneNumber = phoneNumber;
        this.mWorkingHours = workingHours;
    }


    //Methods:

    /**
     * Set the name of the place
     *
     * @param mName
     */
    public void setName(String mName) {
        this.mName = mName;
    }

    /**
     * Get the name of the place
     *
     * @return
     */
    public String getName() {
        return mName;
    }

    /**
     * Set location of the place
     *
     * @param latitude  Enter a double for the latitude
     * @param longitude Enter a double for longitude
     */
    public void setLocation(double latitude, double longitude) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }

    /**
     * Get location of the place
     *
     * @return
     */
    public String getLocation() {
        return "Geo location: " + this.mLatitude + ", " + this.mLongitude;
    }

    /**
     * Check whether there is a location set for this place.
     *
     * @return
     */
    public boolean hasLocation() {
        if (this.mLatitude == NO_LAT_OR_LON) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Set an image resource ID
     *
     * @param imageResourceID
     */
    public void setImageResourceID(int imageResourceID) {
        this.mImageResourceID = imageResourceID;
    }

    /**
     * Get the image resource ID
     *
     * @return
     */
    public int getImageResourceID() {
        return mImageResourceID;
    }

    /**
     * Returns whether or not there is an image for this location
     *
     * @return Returns true if a word has an associated image. Returns false otherwise
     */
    public boolean hasImage() {
        if (mImageResourceID == NO_IMAGE_PROVIDED) {
            return false;
        } else {
            return true;
        }
//        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    /**
     * Set a phone number for the place
     *
     * @param phoneNumber Enter the phone number here.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    /**
     * Returns the phone contact number for a place.
     *
     * @return
     */
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * Returns true if there is a phone number associated with the place.
     * @return
     */
    public boolean hasPhoneNumber() {
        if (this.mPhoneNumber == NO_SUCH_DETAIL_PROVIDED) {
            return false;
        } else {
            return true;
        }
    }

    public void setWorkingHours(String workingHours) {
        this.mWorkingHours = workingHours;
    }

    public String getWorkingHours() {
        return this.mWorkingHours;
    }

    public boolean hasWorkingHours() {
        if (this.mWorkingHours == NO_SUCH_DETAIL_PROVIDED) {
            return false;
        } else {
            return true;
        }
    }
}
