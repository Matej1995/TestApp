package cz.sandy.synetechtest.transactionlisting;

import android.support.annotation.NonNull;

import cz.sandy.synetechtest.rest.ApiCallback;
import cz.sandy.synetechtest.rest.BaseLoader;
import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.Response;


class TransactionLoader extends BaseLoader
{

	void getTransactionList(@NonNull final ApiCallback<CustomerDetailEntity> apiCallback, @NonNull String id)
	{
		execute(provideApi().loadCustomerDetails(id), createTransactionListObserver(apiCallback));
	}


	@NonNull
	private DisposableSingleObserver<Response<CustomerDetailEntity>> createTransactionListObserver(@NonNull final ApiCallback<CustomerDetailEntity> apiCallback)
	{
		return new DisposableSingleObserver<Response<CustomerDetailEntity>>()
		{
			@Override
			public void onSuccess(Response<CustomerDetailEntity> response)
			{
				if(response.isSuccessful())
				{
					apiCallback.onSuccess(response.body());
				}
				else
				{
					apiCallback.onError(new Throwable(response.message()));
				}
			}


			@Override
			public void onError(Throwable e)
			{
				apiCallback.onError(e);
			}
		};
	}

}
