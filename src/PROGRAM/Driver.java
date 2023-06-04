package PROGRAM;

/**
 * Represents a driver entity.
 */
public class Driver extends BaseEntity {
    private String name;
    private String licenseNumber;

    /**
     * Constructs a Driver object with the specified ID, name, and license number.
     *
     * @param id            the ID of the driver
     * @param name          the name of the driver
     * @param licenseNumber the license number of the driver
     */
    public Driver(int id, String name, String licenseNumber) {
        super(id); // Set the ID inherited from BaseEntity
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    /**
     * Returns the name of the driver.
     *
     * @return the name of the driver
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the driver.
     *
     * @param name the name of the driver
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the license number of the driver.
     *
     * @return the license number of the driver
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the license number of the driver.
     *
     * @param licenseNumber the license number of the driver
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

}
