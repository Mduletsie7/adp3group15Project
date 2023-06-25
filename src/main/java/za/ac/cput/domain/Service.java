/*
 * Author: Mdumisi Kelvin Letsie
 * Student No: 220120137
 * Subject: Applications development practice 3
 * */

package za.ac.cput.domain;

import java.util.Objects;

public class Service {
    private String serviceName;
    private String serviceId;
    public Service() {}

    // Add private constructor

    private Service(Service.Builder builder) {
        this.serviceName = builder.serviceName;
        this.serviceId = builder.serviceId;

    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public static class Builder {
        private String serviceName;
        private String serviceId;

        // SETTERS
        public Service.Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Service.Builder setServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Service.Builder copy(Service service) {
            this.serviceName = service.serviceName;
            this.serviceId = service.serviceId;

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
        return Objects.equals(serviceName, service.serviceName) && Objects.equals(serviceId, service.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, serviceId);
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }
}
