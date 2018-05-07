package cz.sandy.synetechtest.transactionlisting;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import static java.lang.String.valueOf;


public class TransactionEntity implements Parcelable
{
	@SerializedName("id")
	private Integer id;

	@SerializedName("type")
	@TransactionType
	private String type;

	@SerializedName("description")
	private String description;

	@SerializedName("date")
	private String date;

	@SerializedName("amount")
	private double amount;


	public TransactionEntity()
	{
	}


	public TransactionEntity(Integer id, String type, String description, String date, double amount)
	{
		this.id = id;
		this.type = type;
		this.description = description;
		this.date = date;
		this.amount = amount;
	}


	protected TransactionEntity(Parcel in)
	{
		if(in.readByte() == 0)
		{
			id = null;
		}
		else
		{
			id = in.readInt();
		}
		type = in.readString();
		description = in.readString();
		date = in.readString();
		amount = in.readDouble();
	}


	public static final Creator<TransactionEntity> CREATOR = new Creator<TransactionEntity>()
	{
		@Override
		public TransactionEntity createFromParcel(Parcel in)
		{
			return new TransactionEntity(in);
		}


		@Override
		public TransactionEntity[] newArray(int size)
		{
			return new TransactionEntity[size];
		}
	};


	public String getPrettyAmount()
	{
		return "-" + valueOf(amount) + "$";
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	@TransactionType
	public String getType()
	{
		return type;
	}


	public void setType(@TransactionType String type)
	{
		this.type = type;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	public String getDate()
	{
		return date;
	}


	public void setDate(String date)
	{
		this.date = date;
	}


	public double getAmount()
	{
		return amount;
	}


	public void setAmount(double amount)
	{
		this.amount = amount;
	}


	@Override
	public String toString()
	{
		return "TransactionEntity{" +
				"id=" + id +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", date='" + date + '\'' +
				", amount=" + amount +
				'}';
	}


	@Override
	public int describeContents()
	{
		return 0;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		if(id == null)
		{
			dest.writeByte((byte) 0);
		}
		else
		{
			dest.writeByte((byte) 1);
			dest.writeInt(id);
		}
		dest.writeString(type);
		dest.writeString(description);
		dest.writeString(date);
		dest.writeDouble(amount);
	}
}
