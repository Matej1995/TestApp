package cz.sandy.synetechtest.transactionlisting;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CustomerDetailEntity
{

	@SerializedName("customerId")
	private Integer customerId;

	@SerializedName("customerCode")
	private String customerCode;

	@SerializedName("customerName")
	private String customerName;

	@SerializedName("transactions")
	private List<TransactionEntity> transactions = null;


	public Integer getCustomerId()
	{
		return customerId;
	}


	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}


	public String getCustomerCode()
	{
		return customerCode;
	}


	public void setCustomerCode(String customerCode)
	{
		this.customerCode = customerCode;
	}


	public String getCustomerName()
	{
		return customerName;
	}


	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}


	public List<TransactionEntity> getTransactions()
	{
		return transactions;
	}


	public void setTransactions(List<TransactionEntity> transactions)
	{
		this.transactions = transactions;
	}


	@Override
	public String toString()
	{
		return "CustomerDetailEntity{" +
				"customerId=" + customerId +
				", customerCode='" + customerCode + '\'' +
				", customerName='" + customerName + '\'' +
				", transactions=" + transactions +
				'}';
	}
}
