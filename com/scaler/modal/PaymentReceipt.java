package com.scaler.modal;

import com.scaler.modal.enums.PaymentMode;
import com.scaler.modal.enums.PaymentStatus;

public class PaymentReceipt {
	
	private long PaymentReceiptId;
	private int amount;
	private PaymentMode paymentMode;
	private com.scaler.modal.enums.PaymentStatus PaymentStatus;
	
	
	public long getPaymentReceiptId() {
		return PaymentReceiptId;
	}
	public int getAmount() {
		return amount;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public PaymentStatus getPaymentStatus() {
		return PaymentStatus;
	}
	
	public void setPaymentReceiptId(long paymentReceiptId) {
		PaymentReceiptId = paymentReceiptId;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	
	@Override
	public String toString() {
		return "PaymentReceipt [PaymentReceiptId=" + PaymentReceiptId + ", amount=" + amount + ", paymentMode="
				+ paymentMode + ", PaymentStatus=" + PaymentStatus + "]";
	}
	
	
	
}
