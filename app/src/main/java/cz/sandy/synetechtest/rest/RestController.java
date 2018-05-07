package cz.sandy.synetechtest.rest;


import android.support.annotation.NonNull;

import cz.sandy.synetechtest.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


class RestController
{
	private static RestController instance;

	private SynetechApi api;


	private RestController()
	{
		api = buildRetrofit().create(SynetechApi.class);
	}


	@NonNull
	static RestController getInstance()
	{
		if(instance == null) instance = new RestController();
		return instance;
	}


	@NonNull
	SynetechApi getSynetechAPI()
	{
		return api;
	}


	private Retrofit buildRetrofit()
	{
		return new Retrofit.Builder()
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(createClient())
				.baseUrl(BuildConfig.API_URL)
				.build();
	}


	@NonNull
	private OkHttpClient createClient()
	{
		return new OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build();
	}


	@NonNull
	private HttpLoggingInterceptor getLoggingInterceptor()
	{
		return new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).setLevel(HttpLoggingInterceptor.Level.BODY);
	}

}
