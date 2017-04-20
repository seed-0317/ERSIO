package com.seed.Model;

public class Expense {
    private String expenseID;
    private String amount;
    private String descriptor;
    private String submitted;
    private String resolved;
    private String idAuthor;
    private String resolver;
    private String type;
    private String status;

    public Expense (String expenseID, String amount, String descriptor, String submitted, String resolved, String idAuthor, String resolver, String type, String status){
        super();
        this.expenseID=expenseID;
        this.amount=amount;
        this.descriptor=descriptor;
        this.submitted=submitted;
        this.resolved=resolved;
        this.idAuthor=idAuthor;
        this.resolver=resolver;
        this.type=type;
        this.status=status;
    }

    public String getExpenseID() {
        return expenseID;
    }

    public String getAmount() {
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

    public String getIdAuthor() {
        return idAuthor;
    }

    public String getResolver() {
        return resolver;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public void setAmount(String amount) {
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

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (!expenseID.equals(expense.expenseID)) return false;
        if (!amount.equals(expense.amount)) return false;
        if (descriptor != null ? !descriptor.equals(expense.descriptor) : expense.descriptor != null) return false;
        if (submitted != null ? !submitted.equals(expense.submitted) : expense.submitted != null) return false;
        if (resolved != null ? !resolved.equals(expense.resolved) : expense.resolved != null) return false;
        if (idAuthor != null ? !idAuthor.equals(expense.idAuthor) : expense.idAuthor != null) return false;
        if (resolver != null ? !resolver.equals(expense.resolver) : expense.resolver != null) return false;
        if (type != null ? !type.equals(expense.type) : expense.type != null) return false;
        return status != null ? status.equals(expense.status) : expense.status == null;
    }

    @Override
    public int hashCode() {
        int result = expenseID.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + (descriptor != null ? descriptor.hashCode() : 0);
        result = 31 * result + (submitted != null ? submitted.hashCode() : 0);
        result = 31 * result + (resolved != null ? resolved.hashCode() : 0);
        result = 31 * result + (idAuthor != null ? idAuthor.hashCode() : 0);
        result = 31 * result + (resolver != null ? resolver.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseID='" + expenseID + '\'' +
                ", amount='" + amount + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", idAuthor='" + idAuthor + '\'' +
                ", resolver='" + resolver + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


