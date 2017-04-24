package com.seed.Model;

public class Expense {
    private int r_id;
    private double amount;
    private String descriptor;
    private String submitted;
    private String resolved;
    private int idAuthor;
    private int resolver;
    private String type;
    private String status;

    public Expense() {
    }

    public Expense( double amount, String descriptor, String submitted, String resolved, int idAuthor, int resolver, String type, String status) {
        super();
        this.amount = amount;
        this.descriptor = descriptor;
        this.submitted = submitted;
        this.resolved = resolved;
        this.idAuthor = idAuthor;
        this.resolver = resolver;
        this.type = type;
        this.status = status;
    }

    public Expense(int r_id, double amount, String descriptor, String submitted, String resolved, int idAuthor, int resolver, String type, String status) {
        super();
        this.r_id=r_id;
        this.amount = amount;
        this.descriptor = descriptor;
        this.submitted = submitted;
        this.resolved = resolved;
        this.idAuthor = idAuthor;
        this.resolver = resolver;
        this.type = type;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getSubmitted() {
        return submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public int getResolver() {
        return resolver;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (Double.compare(expense.amount, amount) != 0) return false;
        if (idAuthor != expense.idAuthor) return false;
        if (resolver != expense.resolver) return false;
        if (descriptor != null ? !descriptor.equals(expense.descriptor) : expense.descriptor != null) return false;
        if (!submitted.equals(expense.submitted)) return false;
        if (resolved != null ? !resolved.equals(expense.resolved) : expense.resolved != null) return false;
        if (type != null ? !type.equals(expense.type) : expense.type != null) return false;
        return status != null ? status.equals(expense.status) : expense.status == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (descriptor != null ? descriptor.hashCode() : 0);
        result = 31 * result + submitted.hashCode();
        result = 31 * result + (resolved != null ? resolved.hashCode() : 0);
        result = 31 * result + idAuthor;
        result = 31 * result + resolver;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                ", amount=" + amount +
                ", descriptor='" + descriptor + '\'' +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", idAuthor=" + idAuthor +
                ", resolver='" + resolver + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

