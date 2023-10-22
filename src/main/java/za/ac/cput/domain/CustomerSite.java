/*
CustomerSite.java
Entity for the customer site
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer_site")
public class CustomerSite {
    @Id
    private String siteId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customerId;

    private String type;

    private String street;

    private String city;

    private String province;

    private int postalCode;
    public CustomerSite() {}

    private CustomerSite(Builder builder) {
        this.siteId = builder.siteId;
        this.customerId = builder.customerId;
        this.type = builder.type;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
    }

    public String getSiteId() {
        return siteId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public static class Builder {
        private String siteId;
        private Customer customerId;

        private String type;

        private String street;

        private String city;

        private String province;

        private int postalCode;

        public Builder setSiteId(String siteId) {
            this.siteId = siteId;
            return this;
        }

        public Builder setCustomerId(Customer customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(CustomerSite customerSite) {
            this.siteId= customerSite.siteId;
            this.customerId = customerSite.customerId;
            this.type = customerSite.type;
            this.street= customerSite.street;
            this.city = customerSite.city;
            this.province = customerSite.province;
            this.postalCode = customerSite.postalCode;
            return this;
        }

        public CustomerSite build() {
            return new CustomerSite(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerSite that)) return false;
        return getPostalCode() == that.getPostalCode() && Objects.equals(getSiteId(), that.getSiteId()) && Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getType(), that.getType()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getProvince(), that.getProvince());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSiteId(), getCustomerId(), getType(), getStreet(), getCity(), getProvince(), getPostalCode());
    }

    @Override
    public String toString() {
        return "CustomerSite{" +
                "customerSiteId='" + siteId + '\'' +
                ", customerId=" + customerId +
                ", type='" + type + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
