public class AquariumFish {

    // Private variables
    private String species;
    private String commonName;
    private double maxTemp;
    private double minTemp;
    private String diet;

    // Constructor
    public AquariumFish(String diet, double minTemp, double maxTemp, String commonName, String species) {
        this.diet = diet;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.commonName = commonName;
        this.species = species;
    }

    // Getters and Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public double averageTemp() {
        return minTemp + maxTemp / 2;
    }

    // Overridden toString to let fish be printed
    @Override
    public String toString() {
        return "Species: " + species + "\n" +
                "Common Name: " + commonName + "\n" +
                "Minimum Temperature: " + minTemp + "\n" +
                "Maximum Temperature: " + maxTemp + "\n" +
                "Average Temperature: " + averageTemp() + "\n" +
                "Diet: " + diet;
    }
}
