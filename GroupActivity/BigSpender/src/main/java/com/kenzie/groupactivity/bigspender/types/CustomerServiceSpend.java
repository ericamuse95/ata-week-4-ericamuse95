package com.kenzie.groupactivity.bigspender.types;

import compare.CustomerTotalSpendBySpend;

import java.util.List;
import java.util.Objects;

/**
 * Represents both a Customer and the details of one AWS service spend.
 */
public class CustomerServiceSpend implements Comparable <CustomerServiceSpend> {
    private Customer customer;
    private ServiceSpend serviceSpend;
    private long totalSpend;
    private List<ServiceSpend> serviceSpends;

    /**
     * Constructor taking a customer and a service spend.
     * @param customer the customer.
     * @param serviceSpend The service spend.
     */
    public CustomerServiceSpend(Customer customer, ServiceSpend serviceSpend) {
        this.customer = customer;
        this.serviceSpend = serviceSpend;
    }
    public CustomerServiceSpend(Customer customer, long totalSpend, List<ServiceSpend> serviceSpends){
        this.customer = customer;
        this.totalSpend = totalSpend;
        this.serviceSpends = serviceSpends;

    }

    public Customer getCustomer() {
        return customer;
    }

    public ServiceSpend getServiceSpend() {
        return serviceSpend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerServiceSpend that = (CustomerServiceSpend) o;
        return customer.equals(that.customer) && serviceSpend.equals(that.serviceSpend);
    }

    @Override
    public int compareTo(CustomerServiceSpend other){
        Customer customer = this.customer;
        int result = customer.compareTo(other.customer);
        if(result == 0) {
            ServiceType serviceName = this.serviceSpend.getServiceName();
            result = serviceName.compareTo(other.serviceSpend.getServiceName());
            if (result == 0) {
                Long random = this.serviceSpend.getSpend();
                result = random.compareTo(other.serviceSpend.getSpend());

            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "CustomerServiceSpend{" +
               "customer=" + customer +
               ", serviceSpend=" + serviceSpend +
               '}';
    }
}
