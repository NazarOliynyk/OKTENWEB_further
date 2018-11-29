package CW_1_Computers;

/**
 * Created by okten29 on 11/28/18.
 */
public class HardDrive {

    String model;
    Type type;
    int volume;
    Country country;

    public HardDrive(String model, Type type, int volume, Country country) {
        this.model = model;
        this.type = type;
        this.volume = volume;
        this.country = country;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

        HardDrive hardDrive = (HardDrive) o;

        if (volume != hardDrive.volume) return false;
        if (model != null ? !model.equals(hardDrive.model) : hardDrive.model != null) return false;
        if (type != hardDrive.type) return false;
        return country == hardDrive.country;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + volume;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HardDrive{" +
                "model='" + model + '\'' +
                ", type=" + type +
                ", volume=" + volume +
                ", country=" + country +
                '}';
    }
}
