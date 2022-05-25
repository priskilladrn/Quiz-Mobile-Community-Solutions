package com.example.insorma_2440110356;

public class Transaction {
    Integer transactionId, userId, productId;
    String transactionDate, productName, quantity, totalPrice;

    public Transaction(Integer _transactionId, Integer _userId, Integer _productId ,String _quantity, String _transactionDate, String _productName, String _totalPrice){
        transactionId = _transactionId;
        userId = _userId;
        productId = _productId;
        quantity = _quantity;
        transactionDate = _transactionDate;
        productName = _productName;
        totalPrice = _totalPrice;
    }
}
