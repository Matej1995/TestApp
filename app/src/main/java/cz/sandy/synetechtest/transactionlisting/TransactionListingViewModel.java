package cz.sandy.synetechtest.transactionlisting;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.tamaslosonczi.viewmodel.AbstractViewModel;

import cz.sandy.synetechtest.rest.ApiCallback;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

import static cz.sandy.synetechtest.BR.entity;
import static cz.sandy.synetechtest.BR.listener;
import static cz.sandy.synetechtest.R.layout.item_transaction;
import static timber.log.Timber.e;


public class TransactionListingViewModel extends AbstractViewModel<TransactionListingView> implements ApiCallback<CustomerDetailEntity>, OnTransactionItemClickListener
{

	private static final String CUSTOMER_ID = "3";

	@NonNull
	private final TransactionLoader loader = new TransactionLoader();

	public final ObservableList<TransactionEntity> transactions = new ObservableArrayList<>();
	public final ItemBinding<TransactionEntity> transactionItemBinding = createTransactionItemBinding();


	@Override
	public void onBindView(@NonNull TransactionListingView view)
	{
		super.onBindView(view);
		loader.getTransactionList(this, CUSTOMER_ID);
	}


	@Override
	public void onSuccess(CustomerDetailEntity detailEntity)
	{
		transactions.addAll(detailEntity.getTransactions());
	}


	@Override
	public void onError(Throwable e)
	{
		e(e);
	}


	@Override
	public void onTransactionClick(@NonNull TransactionEntity entity)
	{
		getView().openDetailActivity(entity);
	}


	@Override
	public void onDestroy()
	{
		super.onDestroy();
		loader.dispose();
	}


	@NonNull
	private ItemBinding<TransactionEntity> createTransactionItemBinding()
	{
		return ItemBinding.<TransactionEntity>of(entity, item_transaction).bindExtra(listener, this);
	}
}
