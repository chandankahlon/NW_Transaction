package com.nwb.cust.service;

import com.nwb.cust.model.Transaction;
import com.nwb.cust.model.TransactionMode;
import com.nwb.cust.model.TransactionStatus;
import com.nwb.cust.model.TransactionType;
import com.nwb.cust.repo.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {

    private TransactionRepository repository;

    // Constructor
    public TransactionService() { 
        repository = new TransactionRepository();
    }
    
    public boolean addTransaction(Transaction t) {
        // Add transaction to the repository 
        repository.transactions.add(t);
        return true;
    }

    // Filter transactions by a specific date range
    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return TransactionFilters.getTransactionsByDateRange(repository.transactions, startDate, endDate);
    }

    // Filter transactions by exact amount
    public List<Transaction> getTransactionsByExactAmount(double amount) {
        return TransactionFilters.searchTransactionsByAmount(repository.transactions, amount);
    }

    // Filter transactions by minimum amount
    public List<Transaction> getTransactionsByMinAmount(double minAmount) {
        return TransactionFilters.getTransactionsByMinAmount(repository.transactions, minAmount);
    }

    // Filter transactions by maximum amount
    public List<Transaction> getTransactionsByMaxAmount(double maxAmount) {
        return TransactionFilters.getTransactionsByMaxAmount(repository.transactions, maxAmount);
    }

    // Filter transactions by transaction type
    public List<Transaction> getTransactionsByType(TransactionType type) {
        return TransactionFilters.getTransactionsByType(repository.transactions, type);
    }

    // Filter transactions by transaction status
    public List<Transaction> getTransactionsByStatus(TransactionStatus status) {
        return TransactionFilters.getTransactionsByStatus(repository.transactions, status);
    }

    // Filter transactions by transaction mode
    public List<Transaction> getTransactionsByMode(TransactionMode mode) {
        return TransactionFilters.getTransactionsByMode(repository.transactions, mode);
    }

    // Filter transactions by description (contains keywords)
    public List<Transaction> getTransactionsByDescription(String descriptionKeyword) {
        return TransactionFilters.searchTransactionsByDescription(repository.transactions, descriptionKeyword);
    }

    // Retrieve a specific transaction by its ID
    public Transaction getTransactionById(Long transactionId) {
        return TransactionFilters.getTransactionById(repository.transactions, transactionId);
    }

    // Filter transactions by sender account number
    public List<Transaction> getTransactionsBySenderAccount(String senderAccount) {
        return TransactionFilters.getTransactionsBySenderAccount(repository.transactions, senderAccount);
    }

    // Filter transactions by receiver account number
    public List<Transaction> getTransactionsByReceiverAccount(String receiverAccount) {
        return TransactionFilters.getTransactionsByReceiverAccount(repository.transactions, receiverAccount);
    } 

    // Filter transactions by currency type
    public List<Transaction> getTransactionsByCurrency(String currency) {
        return TransactionFilters.getTransactionsByCurrency(repository.transactions, currency);
    }

    public List<Transaction> getAllTransactions() {
        return repository.transactions;
    }
}
