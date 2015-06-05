package com.s626.archery;

/**
 * Created by 626 on 03.06.2015.
 */
public class ArcherData {
    private String name = "";
    private String age = "";
    private String gender = "";
    private String bowType = "";
    private String shootDistance = "";
    private String numberOfArrows = "6";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBowType(String bowType) {
        this.bowType = bowType;
    }

    public String getBowType() {
        return bowType;
    }

    public void setShootDistance(String shootDistance) {
        this.shootDistance = shootDistance;
    }

    public String getShootDistance() {
        return shootDistance;
    }

    public void setNumberOfArrows(String numberOfArrows) {
        this.numberOfArrows = numberOfArrows;
    }

    public String getNumberOfArrows() {
        return numberOfArrows;
    }
}
