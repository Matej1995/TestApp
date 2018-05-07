package cz.sandy.synetechtest.transactiondetail;

import android.databinding.ObservableField;

import com.tamaslosonczi.viewmodel.AbstractViewModel;

import cz.sandy.synetechtest.transactionlisting.TransactionEntity;


public class TransactionDetailViewModel extends AbstractViewModel<TransactionDetailView>
{
	public ObservableField<TransactionEntity> entity = new ObservableField<>();


	public void setEntity(TransactionEntity entity)
	{
		this.entity.set(entity);
	}
}
