package CW_1_Computers;

/**
 * Created by okten29 on 11/28/18.
 */

public class Processor {

    int numberOfCores;
    int frequency;
    Country country;

    public Processor(int numberOfCores, int frequency, Country country) {
        this.numberOfCores = numberOfCores;
        this.frequency = frequency;
        this.country = country;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Processor processor = (Processor) o;

        if (numberOfCores != processor.numberOfCores) return false;
        if (frequency != processor.frequency) return false;
        return country == processor.country;
    }

    @Override
    public int hashCode() {
        int result = numberOfCores;
        result = 31 * result + frequency;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "numberOfCores=" + numberOfCores +
                ", frequency=" + frequency +
                ", country=" + country +
                '}';
    }
}

