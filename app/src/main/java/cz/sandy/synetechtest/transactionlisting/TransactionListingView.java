package cz.sandy.synetechtest.transactionlisting;


import android.support.annotation.NonNull;

import com.tamaslosonczi.viewmodel.IView;


public interface TransactionListingView extends IView
{
	void openDetailActivity(@NonNull TransactionEntity entity);
}
