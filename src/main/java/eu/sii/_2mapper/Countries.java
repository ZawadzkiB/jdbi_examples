package eu.sii._2mapper;

import java.util.Objects;

public class Countries {

  private String countryId;
  private String countryName;
  private int regionId;

  public Countries(
          String countryId,
          String countryName,
          int regionId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Countries countries = (Countries) o;
    return regionId == countries.regionId &&
            Objects.equals(countryId, countries.countryId) &&
            Objects.equals(countryName, countries.countryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryId, countryName, regionId);
  }
}
