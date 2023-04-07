/**
 * Consultant.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 07 March 2023
 */

package za.ac.cput.domain;

import java.util.Objects;

public class Consultant {
    private String consultantId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

    public Consultant() {}

    public Consultant(Consultant.Builder builder) {
        this.consultantId = builder.consultantId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.address = builder.address;
    }

    // Getters
    public String getConsultantId() {
        return consultantId;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder{
        private String consultantId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String address;

        public Builder setConsultantId(String consultantId) {
            this.consultantId = consultantId;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Consultant.Builder copy(Consultant consultant) {
            this.consultantId = consultant.consultantId;
            this.firstName = consultant.firstName;
            this.lastName = consultant.lastName;
            this.phoneNumber = consultant.phoneNumber;
            this.email = consultant.email;
            this.address = consultant.address;
            return this;
        }

        public Consultant build() {
            return new Consultant(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Consultant consultant = (Consultant) o;
            return Objects.equals(firstName, consultant.firstName) && Objects.equals(lastName, consultant.lastName) && Objects.equals(phoneNumber, consultant.phoneNumber) && Objects.equals(email, consultant.email) && Objects.equals(address, consultant.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(consultantId, firstName, lastName, phoneNumber, email, address);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "consultantId='" + consultantId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber=" + phoneNumber +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
