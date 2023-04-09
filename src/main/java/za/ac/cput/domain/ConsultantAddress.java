/**
 * ConsultantAddress.java
 * This is the ConsultantAddress POJO
 * @author Lerato Moshabi - 220076073
 * 07 March 2023
 */

package za.ac.cput.domain;

import java.util.Objects;

public class ConsultantAddress {
    private String consultantAddressId;
    private String consultantId;
    private String addressId;
    public ConsultantAddress() {}

    // Add private constructor

    private ConsultantAddress(ConsultantAddress.Builder builder) {
        this.consultantAddressId = builder.consultantAddressId;
        this.consultantId = builder.consultantId;
        this.addressId = builder.addressId;

    }

    public String getConsultantAddressId() {
        return consultantAddressId;
    }

    public String getConsultantId() {
        return consultantId;
    }
    public String addressId() {
        return addressId;
    }

    public static class Builder {
        private String consultantAddressId;
        private String consultantId;
        private String addressId;

        // SETTERS
        public ConsultantAddress.Builder setConsultantAddressId(String consultantAddressId) {
            this.consultantAddressId = consultantAddressId;
            return this;
        }

        public ConsultantAddress.Builder setConsultantId(String consultantId) {
            this.consultantId = consultantId;
            return this;
        }
        public ConsultantAddress.Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public ConsultantAddress.Builder copy(ConsultantAddress consultantAddress) {
            this.consultantAddressId = consultantAddress.consultantAddressId;
            this.consultantId = consultantAddress.consultantId;
            this.addressId = consultantAddress.addressId;

            return this;
        }

        public ConsultantAddress build() {
            return new ConsultantAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultantAddress that = (ConsultantAddress) o;
        return Objects.equals(consultantAddressId, that.consultantAddressId) && Objects.equals(consultantId, that.consultantId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultantAddressId, consultantId, addressId);
    }

    @Override
    public String toString() {
        return "ConsultantAddress{" +
                "consultantAddressId='" + consultantAddressId + '\'' +
                ", consultantId='" + consultantId + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}
