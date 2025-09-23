package learn;

public class StudentSummary {
    // 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.
    private String country;
    private String major;
    private double iq;

    public StudentSummary(String country, String major, double iq) {
        this.country = country;
        this.major = major;
        this.iq = iq;
    }

    public StudentSummary() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getIq() {
        return iq;
    }

    public void setIq(double iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "Country: " + country + " | Major: " + major + " | IQ: " + iq;
    }
}
