package eu.sii._3sqlObject;

public class Countries {

  private String countryId;
  private String countryName;
  private int regionId;

  public Countries(String countryId, String countryName, int regionId) {
    this.countryId = countryId;
    this.countryName = countryName;
    this.regionId = regionId;
  }

  public String getCountryId() {
    return countryId;
  }

  public Countries setCountryId(String countryId) {
    this.countryId = countryId;
    return this;
  }

  public String getCountryName() {
    return countryName;
  }

  public Countries setCountryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

  public int getRegionId() {
    return regionId;
  }

  public Countries setRegionId(int regionId) {
    this.regionId = regionId;
    return this;
  }
}
