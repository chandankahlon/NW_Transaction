package com.nwb.cust.model; 
import java.time.LocalDateTime;
 
public class Transaction {  
    private Long id; 
    private TransactionMode mode;
    private TransactionType type;
    private Double amount;
    private LocalDateTime date;
    private String description; 
    private TransactionStatus status;
    private String currency;

    public Transaction() {
        // Default constructor
    }
    

    public Transaction(Long id, String mode, String type, Double amount, LocalDateTime date,
                       String description, String status, String currency) { 
        this.id = id;
        try {
            this.mode =  TransactionMode.valueOf(mode.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TransactionMode: " + mode);
        } 
        try {
            this.type = TransactionType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TransactionType: " + type);
        }
        this.amount = amount;
        this.date = date != null ? date : LocalDateTime.now();  
        this.description = description;
        try {
            this.status = TransactionStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TransactionStatus: " + status);
        }
        this.currency = currency; 

        // Validation for transaction
        TransactionValidations validator = new TransactionValidations();
        validator.validateTransaction(this);
    } 

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public TransactionMode getMode() {
        return mode;
    }


    public void setMode(TransactionMode mode) {
        this.mode = mode;
    }


    public TransactionType getType() {
        return type;
    }


    public void setType(TransactionType type) {
        this.type = type;
    }


    public Double getAmount() {
        return amount;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public TransactionStatus getStatus() {
        return status;
    } 

    public void setStatus(TransactionStatus status) {
        this.status = status;
    } 

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", mode='" + mode + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

	public void completeTransaction() {
        this.status = TransactionStatus.SUCCESS;
    }

    public void failTransaction() {
        this.status = TransactionStatus.FAILED;
    }

    public void cancelTransaction() {
        this.status = TransactionStatus.CANCELLED;
    }

    public boolean isPending() {
        return this.status == TransactionStatus.PENDING;
    }

    public boolean isCompleted() {
        return this.status == TransactionStatus.SUCCESS;
    }

    public boolean isFailed() {
        return this.status == TransactionStatus.FAILED;
    }
    
    public boolean isCancelled() {
        return this.status == TransactionStatus.CANCELLED;
    }
}
