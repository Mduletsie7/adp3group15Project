/**
 * ConsultantAddress.java
 * This is the ConsultantAddress POJO
 * @author Lerato Moshabi - 220076073
 * 07 March 2023
 */

package za.ac.cput.domain;

import java.util.Objects;

public class ConsultantAddress {
    private Consultant consultantId;
    private Address addressId;

    public ConsultantAddress() {}


    public ConsultantAddress(ConsultantAddress.Builder builder) {
        this.consultantId = builder.consultantId;
        this.addressId = builder.addressId;
    }

    public Consultant getConsultantId()  {
        return consultantId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public static class Builder{
        private Consultant consultantId;
        private Address addressId;

        public Builder setConsultantId(Consultant consultantId) {
            this.consultantId = consultantId;
            return this;
        }

        public Builder setAddressId(Address addressId) {
            this.addressId = addressId;
            return this;
        }

        public ConsultantAddress.Builder copy(ConsultantAddress consultantAddress) {
            this.consultantId = consultantId;
            this.addressId = addressId;
            return this;
        }

        public ConsultantAddress build() {
            return new ConsultantAddress(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ConsultantAddress consultantAddress = (ConsultantAddress) o;
            return Objects.equals(consultantId, consultantAddress.consultantId) && Objects.equals(addressId, consultantAddress.addressId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(consultantId,addressId);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "consultantId=" + consultantId +
                    ", addressId=" + addressId +
                    '}';
        }
    }
}
