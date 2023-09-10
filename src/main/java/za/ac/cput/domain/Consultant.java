/**
 * Consultant.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 07 March 2023
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Consultant {
    @Id
    private String consultantId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

    public Consultant() {}

    // Add private constructor

    private Consultant(Consultant.Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.consultantId = builder.consultantId;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getConsultantId() {
        return consultantId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail()  {return email; }
    public String getAddress() {
        return address;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String consultantId;
        private String phoneNumber;
        private String email;
        private String address;


        // SETTERS
        public Consultant.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Consultant.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Consultant.Builder setConsultantId(String consultantId) {
            this.consultantId = consultantId;
            return this;
        }

        public Consultant.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Consultant.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Consultant.Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Consultant.Builder copy(Consultant consultant) {
            this.firstName = consultant.firstName;
            this.lastName = consultant.lastName;
            this.consultantId = consultant.consultantId;
            this.email = consultant.email;
            this.phoneNumber = consultant.phoneNumber;
            this.address = consultant.address;
            return this;
        }

        public Consultant build() {
            return new Consultant(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant consultant = (Consultant) o;
        return Objects.equals(firstName, consultant.firstName) && Objects.equals(lastName, consultant.lastName) && Objects.equals(email, consultant.email) && Objects.equals(phoneNumber, consultant.phoneNumber) && Objects.equals(address, consultant.address) && Objects.equals(consultantId, consultant.consultantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, address, consultantId);
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", consultantId='" + consultantId + '\'' +
                '}';
    }
}
