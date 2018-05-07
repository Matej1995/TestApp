package cz.sandy.synetechtest.rest;

public interface ApiCallback<T>
{
	void onSuccess(T object);
	void onError(Throwable e);
}
