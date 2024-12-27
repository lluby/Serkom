package org.example.Models;

import lombok.Getter;
import java.sql.Date;

public class PaymentRecords {
    //atribut
    @Getter
    private final int id;
    private final int amount;
    private final Date date;

    //construct
    public PaymentRecords(int id, int amount, Date date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    //getter setter
    public int getTotalPrice() {
        return amount;
    }

    public Date getPaymentDate() {
        return date;
    }
}
