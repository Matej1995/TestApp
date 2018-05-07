package cz.sandy.synetechtest.app;

import android.app.Application;

import static cz.sandy.synetechtest.BuildConfig.DEV;
import static timber.log.Timber.DebugTree;
import static timber.log.Timber.plant;


public class SynetechApp extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		if(DEV)
		{
			plant(new DebugTree());
		}
	}
}
