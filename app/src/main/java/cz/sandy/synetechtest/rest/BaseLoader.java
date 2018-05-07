package cz.sandy.synetechtest.rest;

import android.support.annotation.NonNull;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class BaseLoader
{

	private CompositeDisposable disposable;


	public BaseLoader()
	{
		this.disposable = new CompositeDisposable();
	}


	protected <T> void execute(@NonNull Single<T> single, @NonNull DisposableSingleObserver<T> observer)
	{
		single.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(observer);

		disposable.add(observer);
	}


	@NonNull
	protected SynetechApi provideApi()
	{
		return RestController.getInstance().getSynetechAPI();
	}


	public void dispose()
	{
		disposable.clear();
	}

}
