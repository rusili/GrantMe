package nyc.c4q.rusili.grantme.network.pojo;

import com.google.gson.annotations.SerializedName;

public class JSONCourses {
    private String address1;
    private String borough;
    private String city;
    @SerializedName ("contact_firstname")
    private String contactFirstname;
    @SerializedName ("contact_lastname")
    private String contactLastname;
    @SerializedName ("cost_includes")
    private String costIncludes;
    @SerializedName ("cost_total")
    private String costTotal;
    @SerializedName ("course_name")
    private String courseName;
    private String coursedescription;
    @SerializedName ("delivery_method")
    private String deliveryMethod;
    private String duration;
    @SerializedName ("duration_unit")
    private String durationUnit;
    private String fax;
    @SerializedName ("financial_aid_services")
    private String financialAidServices;
    @SerializedName ("instructor_credentials")
    private String instructorCredentials;
    @SerializedName ("is_hra")
    private String isHra;
    @SerializedName ("is_sbs")
    private String isSbs;
    @SerializedName ("job_placement_services")
    private String jobPlacementServices;
    private String keywords;
    @SerializedName ("max_class_size")
    private String maxClassSize;
    private String neighborhood;
    private String numhours;
    @SerializedName ("organization_name")
    private String organizationName;
    private String phone1;
    private String prerequisites;
    private String schedule;
    private String state;
    private String website;
    @SerializedName ("zip_code")
    private String zipCode;

    public String getAddress1 () {
        return address1;
    }

    public String getBorough () {
        return borough;
    }

    public String getCity () {
        return city;
    }

    public String getContactFirstname () {
        return contactFirstname;
    }

    public String getContactLastname () {
        return contactLastname;
    }

    public String getCostIncludes () {
        return costIncludes;
    }

    public String getCostTotal () {
        return costTotal;
    }

    public String getCourseName () {
        return courseName;
    }

    public String getCoursedescription () {
        return coursedescription;
    }

    public String getDeliveryMethod () {
        return deliveryMethod;
    }

    public String getDuration () {
        return duration;
    }

    public String getDurationUnit () {
        return durationUnit;
    }

    public String getFax () {
        return fax;
    }

    public String getFinancialAidServices () {
        return financialAidServices;
    }

    public String getInstructorCredentials () {
        return instructorCredentials;
    }

    public String getIsHra () {
        return isHra;
    }

    public String getIsSbs () {
        return isSbs;
    }

    public String getJobPlacementServices () {
        return jobPlacementServices;
    }

    public String getKeywords () {
        return keywords;
    }

    public String getMaxClassSize () {
        return maxClassSize;
    }

    public String getNeighborhood () {
        return neighborhood;
    }

    public String getNumhours () {
        return numhours;
    }

    public String getOrganizationName () {
        return organizationName;
    }

    public String getPhone1 () {
        return phone1;
    }

    public String getPrerequisites () {
        return prerequisites;
    }

    public String getSchedule () {
        return schedule;
    }

    public String getState () {
        return state;
    }

    public String getWebsite () {
        return website;
    }

    public String getZipCode () {
        return zipCode;
    }
}
