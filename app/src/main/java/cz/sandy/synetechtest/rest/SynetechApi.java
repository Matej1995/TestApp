package cz.sandy.synetechtest.rest;

import android.support.annotation.NonNull;

import cz.sandy.synetechtest.transactionlisting.CustomerDetailEntity;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SynetechApi
{
	@GET("v1/customers/{customerId}")
	Single<Response<CustomerDetailEntity>> loadCustomerDetails(@NonNull @Path("customerId") String customerId);
}
