package cz.sandy.synetechtest.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import cz.sandy.synetechtest.transactionlisting.TransactionType;

import static android.text.TextUtils.isEmpty;
import static cz.sandy.synetechtest.R.drawable.ic_bank;
import static cz.sandy.synetechtest.R.drawable.ic_gas;
import static cz.sandy.synetechtest.R.drawable.ic_home;
import static cz.sandy.synetechtest.R.drawable.ic_kids;
import static cz.sandy.synetechtest.transactionlisting.TransactionType.BANK;
import static cz.sandy.synetechtest.transactionlisting.TransactionType.GAS;
import static cz.sandy.synetechtest.transactionlisting.TransactionType.HOUSE;
import static cz.sandy.synetechtest.transactionlisting.TransactionType.KIDS;
import static timber.log.Timber.e;


public class BindingAdapters
{
	@BindingAdapter("setImageForType")
	public static void setImageForType(ImageView view, @TransactionType String type)
	{
		if(!isEmpty(type))
		{
			switch(type)
			{
				case KIDS:
					view.setImageResource(ic_kids);
					break;
				case BANK:
					view.setImageResource(ic_bank);
					break;
				case GAS:
					view.setImageResource(ic_gas);
					break;
				case HOUSE:
					view.setImageResource(ic_home);
					break;
				default:
					throw new RuntimeException("Bad type provided!");
			}
		}
		else
		{
			e("Empty or null url provided!");
		}
	}
}
