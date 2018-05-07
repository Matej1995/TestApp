package cz.sandy.synetechtest.transactionlisting;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
@StringDef
public @interface TransactionType
{
	String KIDS = "kids";
	String GAS = "gas";
	String HOUSE = "house";
	String BANK = "bank";
}
