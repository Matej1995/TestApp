package cz.sandy.synetechtest.transactiondetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.MenuItem;

import com.tamaslosonczi.viewmodel.base.ViewModelBaseActivity;

import cz.sandy.synetechtest.databinding.ActivityTransactionDetailBinding;
import cz.sandy.synetechtest.transactionlisting.TransactionEntity;

import static android.R.id.home;
import static android.view.Gravity.END;
import static android.view.Window.FEATURE_CONTENT_TRANSITIONS;
import static cz.sandy.synetechtest.R.layout.activity_transaction_detail;


public class TransactionDetailActivity extends ViewModelBaseActivity<TransactionDetailView, TransactionDetailViewModel> implements TransactionDetailView
{

	public static final String EXTRA_ENTITY = "ENTITY";


	@NonNull
	public static Intent newIntent(@NonNull Context context, @NonNull TransactionEntity entity)
	{
		final Intent intent = new Intent(context, TransactionDetailActivity.class);
		intent.putExtra(EXTRA_ENTITY, entity);
		return intent;
	}


	private ActivityTransactionDetailBinding binding;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		getWindow().requestFeature(FEATURE_CONTENT_TRANSITIONS);
		getWindow().setExitTransition(null);
		getWindow().setEnterTransition(new Slide(END));

		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, activity_transaction_detail);
		binding.setView(this);
		binding.setViewModel(getViewModel());
		setModelView(this);

		parseArguments();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}


	private void parseArguments()
	{
		if(getIntent() != null && getIntent().getExtras() != null)
		{
			getViewModel().setEntity((TransactionEntity) getIntent().getParcelableExtra(EXTRA_ENTITY));

		}
		else
		{
			throw new RuntimeException("Arguments cannot be null -> use static method newIntent with params!");
		}
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId() == home)
		{
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@NonNull
	@Override
	public TransactionDetailViewModel createViewModel()
	{
		return new TransactionDetailViewModel();
	}
}
