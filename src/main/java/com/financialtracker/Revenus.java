package com.financialtracker;

public class Revenus {
    private String period;
    private Float salary;
    private Float helpers;
    private Float self_enterprise;
    private Float passive_income;
    private Float other;

    public Revenus() {
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Float getTotal() {
        return this.salary + this.helpers + this.self_enterprise + this.passive_income + this.other;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getHelpers() {
        return helpers;
    }

    public void setHelpers(Float helpers) {
        this.helpers = helpers;
    }

    public Float getSelf_enterprise() {
        return self_enterprise;
    }

    public void setSelf_enterprise(Float self_enterprise) {
        this.self_enterprise = self_enterprise;
    }

    public Float getPassive_income() {
        return passive_income;
    }

    public void setPassive_income(Float passive_income) {
        this.passive_income = passive_income;
    }

    public Float getOther() {
        return other;
    }

    public void setOther(Float other) {
        this.other = other;
    }
}
