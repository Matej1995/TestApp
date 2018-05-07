package cz.sandy.synetechtest.transactionlisting;

import android.app.ActivityOptions;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Window;

import com.tamaslosonczi.viewmodel.base.ViewModelBaseActivity;

import cz.sandy.synetechtest.R;
import cz.sandy.synetechtest.databinding.ActivityTransactionListingBinding;
import cz.sandy.synetechtest.transactiondetail.TransactionDetailActivity;


public class TransactionListingActivity extends ViewModelBaseActivity<TransactionListingView, TransactionListingViewModel> implements TransactionListingView
{

	private ActivityTransactionListingBinding binding;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		getWindow().setExitTransition(null);

		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_transaction_listing);
		binding.setView(this);
		binding.setViewModel(getViewModel());
		binding.executePendingBindings();
		setModelView(this);
	}


	@NonNull
	@Override
	public TransactionListingViewModel createViewModel()
	{
		return new TransactionListingViewModel();
	}


	@Override
	public void openDetailActivity(@NonNull TransactionEntity entity)
	{
		startActivity(TransactionDetailActivity.newIntent(this, entity), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
	}


}