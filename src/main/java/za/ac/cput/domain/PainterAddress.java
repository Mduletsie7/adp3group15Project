package za.ac.cput.domain;

import java.util.Objects;

public class PainterAddress {
    private String painterAddressId;
    private String painterId;
    private String addressId;
    public PainterAddress() {}

    // Add private constructor

    private PainterAddress(PainterAddress.Builder builder) {
        this.painterAddressId = builder.painterAddressId;
        this.painterId = builder.painterId;
        this.addressId = builder.addressId;

    }

    public String getPainterAddressId() {
        return painterAddressId;
    }

    public String getPainterId() {
        return painterId;
    }
    public String addressId() {
        return addressId;
    }

    public static class Builder {
        private String painterAddressId;
        private String painterId;
        private String addressId;

        // SETTERS
        public PainterAddress.Builder setPainterAddressId(String painterAddressId) {
            this.painterAddressId = painterAddressId;
            return this;
        }

        public PainterAddress.Builder setPainterId(String painterId) {
            this.painterId = painterId;
            return this;
        }
        public PainterAddress.Builder setaddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public PainterAddress.Builder copy(PainterAddress painterAddress) {
            this.painterAddressId = painterAddress.painterAddressId;
            this.painterId = painterAddress.painterId;
            this.addressId = painterAddress.addressId;

            return this;
        }

        public PainterAddress build() {
            return new PainterAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PainterAddress that = (PainterAddress) o;
        return Objects.equals(painterAddressId, that.painterAddressId) && Objects.equals(painterId, that.painterId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(painterAddressId, painterId, addressId);
    }

    @Override
    public String toString() {
        return "PainterAddress{" +
                "painterAddressId='" + painterAddressId + '\'' +
                ", painterId='" + painterId + '\'' +
                ", addressId='" + addressId + '\'' +
                '}';
    }
}
