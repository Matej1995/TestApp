package cz.sandy.synetechtest.transactionlisting;

import android.support.annotation.NonNull;


public interface OnTransactionItemClickListener
{
	void onTransactionClick(@NonNull final TransactionEntity entity);
}
