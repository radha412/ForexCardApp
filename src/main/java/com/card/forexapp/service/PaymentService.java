//package com.card.forexapp.service;
//
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//import com.card.forexapp.entity.TransactionDetails;
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//
//@Service
//public class PaymentService {
//	private static final String KEY = "rzp_test_sGsxqvKY8AVB27";
//	private static final String KEY_SECRET = "iVmdefYLCwKWpE4TsoXqHf9C";
//	private static final String CURRENCY = "INR";
//
//	public TransactionDetails createTransaction(Integer amount) throws RazorpayException {
//		TransactionDetails transactionDetails = null;
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("amount", (amount * 100));// SMALLEST AMOUNT OF A CURRENCY FOR 1 RUPEES IT CONSIDERS 100 PAISE;
//		jsonObject.put("currency", CURRENCY);
//
//		RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);
//		Order order = razorpayClient.orders.create(jsonObject);
//		JSONObject request = new JSONObject(String.valueOf(order));
//		transactionDetails = this.prepareTransactionDetails(order);
//
//		return transactionDetails;
//	}
//
//	private TransactionDetails prepareTransactionDetails(Order order) {
//		String orderId = order.get("id");
//		String currency = order.get("currency");
//		Integer money = order.get("amount");
//
//		TransactionDetails transactiondetails = new TransactionDetails(orderId, currency, money);
//		return transactiondetails;
//	}
//
//}
