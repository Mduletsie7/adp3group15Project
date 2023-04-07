package za.ac.cput.domain;

import java.util.Objects;

public class Service {
    private String serviceName;
    private String serviceNo;
    public Service() {}

    // Add private constructor

    private Service(Service.Builder builder) {
        this.serviceName = builder.serviceName;
        this.serviceNo = builder.serviceNo;

    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceId() {
        return serviceNo;
    }

    public static class Builder {
        private String serviceName;
        private String serviceNo;

        // SETTERS
        public Service.Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Service.Builder setServiceNo(String serviceNo) {
            this.serviceNo = serviceNo;
            return this;
        }

        public Service.Builder copy(Service service) {
            this.serviceName = service.serviceName;
            this.serviceNo = service.serviceNo;

            return this;
        }

        public Service build() {
            return new Service(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(serviceName, service.serviceName) && Objects.equals(serviceNo, service.serviceNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, serviceNo);
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceId='" + serviceNo + '\'' +
                '}';
    }
}
