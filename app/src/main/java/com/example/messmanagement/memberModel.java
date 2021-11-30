package com.example.messmanagement;

public class memberModel {
    String name,amount,debt,totalMeal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public memberModel(String name, String amount, String debt, String totalMeal) {
        this.name = name;
        this.amount = amount;
        this.debt = debt;
        this.totalMeal = totalMeal;
    }

    public memberModel() {

    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }

    public String getTotalMeal() {
        return totalMeal;
    }

    public void setTotalMeal(String totalMeal) {
        this.totalMeal = totalMeal;
    }
}
