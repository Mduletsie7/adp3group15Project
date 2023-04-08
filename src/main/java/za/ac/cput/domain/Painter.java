package za.ac.cput.domain;

import java.util.Objects;

public class Painter {


    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String painterId;

    public Painter() {}

    // Add private constructor

    private Painter(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.painterId = builder.painterId;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPainterId() {
        return painterId;
    }

    public String getEmail()  {return email; }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String painterId;
        private  String email;
        private  String phoneNumber;
        private  String address;


        // SETTERS
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPainterId(String painterId) {
            this.painterId = painterId;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder copy(Painter painter) {
            this.firstName = painter.firstName;
            this.lastName = painter.lastName;
            this.painterId = painter.painterId;
            this.email = painter.email;
            this.phoneNumber = painter.phoneNumber;
            this.address = painter.address;
            return this;
        }

        public Painter build() {
            return new Painter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painter painter = (Painter) o;
        return Objects.equals(firstName, painter.firstName) && Objects.equals(lastName, painter.lastName) && Objects.equals(email, painter.email) && Objects.equals(phoneNumber, painter.phoneNumber) && Objects.equals(address, painter.address) && Objects.equals(painterId, painter.painterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, address, painterId);
    }

    @Override
    public String toString() {
        return "Painter{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", painterId='" + painterId + '\'' +
                '}';
    }
}


