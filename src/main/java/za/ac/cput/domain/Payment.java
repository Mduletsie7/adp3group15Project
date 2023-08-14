package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Payment {
    @Id
    private String paymentId;
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project projectId;
    private String paymentAmount;
    private String paymentDate;

    public Payment() {}

    public Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.projectId = builder.projectId;
        this.paymentAmount = builder.paymentAmount;
        this.paymentDate = builder.paymentDate;
    }

    public String getPaymentId() {return paymentId;}
    public Project getProjectId() {return projectId;}
    public String getPaymentAmount() {return paymentAmount;}
    public String getPaymentDate() {return paymentDate;}

    public static class Builder {
        private String paymentId;
        private Project projectId;
        private String paymentAmount;
        private String paymentDate;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setProjectId(Project projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder setPaymentAmount(String paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Payment.Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.projectId = payment.projectId;
            this.paymentAmount = payment.paymentAmount;
            this.paymentDate = payment.paymentDate;
            return this;
        }

        public Payment build() {return new Payment(this);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(paymentId, builder.paymentId) && Objects.equals(projectId, builder.projectId) && Objects.equals(paymentAmount, builder.paymentAmount) && Objects.equals(paymentDate, builder.paymentDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(paymentId, projectId, paymentAmount, paymentDate);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "paymentId='" + paymentId + '\'' +
                    ", projectId='" + projectId + '\'' +
                    ", paymentAmount='" + paymentAmount + '\'' +
                    ", paymentDate='" + paymentDate + '\'' +
                    '}';
        }
    }
}
