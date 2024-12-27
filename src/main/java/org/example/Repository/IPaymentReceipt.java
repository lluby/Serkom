package org.example.Repository;

import org.example.Models.PaymentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentReceipt extends JpaRepository<PaymentReceipt, String> {

}
