package com.example;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FundTransferServiceTest {

    @Test
    void SuccessfulTransfer() {
        FundTransferService service = new FundTransferService(new AccountService() {
            public boolean exists(String accountNumber) { return true; }
            public double getBalance(String accountNumber) { return "A123".equals(accountNumber) ? 200.0 : 0.0; }
            public boolean debit(String accountNumber, double amount) { return true; }
            public boolean credit(String accountNumber, double amount) { return true; }
        });

        String result = service.transfer("A123", "B456", 100);
        assertEquals("SUCCESS: Transfer completed", result);
    }

    @Test
    void InsufficientFunds() {
        FundTransferService service = new FundTransferService(new AccountService() {
            public boolean exists(String accountNumber) { return true;}
            public double getBalance(String accountNumber) { return "A123".equals(accountNumber) ? 200.0 : 0.0; }
            public boolean debit(String accountNumber, double amount) { return true; }
            public boolean credit(String accountNumber, double amount) { return true; }
        });

        String result = service.transfer("A123", "B456", 300);
        assertEquals("FAILURE: Insufficient funds", result);
    }

    @Test
    void InvalidAmount() {
        FundTransferService service = new FundTransferService(new AccountService() {
            public boolean exists(String accountNumber) { return true; }
            public double getBalance(String accountNumber) { return 200; }
            public boolean debit(String accountNumber, double amount) { return true; }
            public boolean credit(String accountNumber, double amount) { return true; }
        });

        String result = service.transfer("A123", "B456", -50);
        assertEquals("FAILURE: Invalid amount", result);
    }

    @Test
    void SameAccount() {
        FundTransferService service = new FundTransferService(new AccountService() {
            public boolean exists(String accountNumber) { return true; }
            public double getBalance(String accountNumber) { return 200; }
            public boolean debit(String accountNumber, double amount) { return true; }
            public boolean credit(String accountNumber, double amount) { return true; }
        });

        String result = service.transfer("A123", "A123", 50);
        assertEquals("FAILURE: Source and destination cannot be same", result);
    }

    @Test
    void DestinationNotFound() {
        FundTransferService service = new FundTransferService(new AccountService() {
            public boolean exists(String accountNumber) { return false;}
            public double getBalance(String accountNumber) { return 200; }
            public boolean debit(String accountNumber, double amount) { return true; }
            public boolean credit(String accountNumber, double amount) { return true; }
        });

        String result = service.transfer("A123", "C789", 50);
        assertEquals("FAILURE: Destination account not found", result);
    }

    @Test
    void TransactionError() {
        FundTransferService service = new FundTransferService(new AccountService() {
            public boolean exists(String accountNumber) { return true; }
            public double getBalance(String accountNumber) { return 200; }
            public boolean debit(String accountNumber, double amount) { return true; }
            public boolean credit(String accountNumber, double amount) { return false; }
        });

        String result = service.transfer("A123", "B456", 100);
        assertEquals("FAILURE: Transaction error", result);
    }
}
