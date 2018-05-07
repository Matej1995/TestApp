package cz.sandy.synetechtest.utility;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TimeUtility
{
	@NonNull
	private static final SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());


	@Nullable
	public static String getPrettyDate(@NonNull final String date)
	{
		try
		{
			final Date parsed = INPUT_DATE_FORMAT.parse(date);
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
			return outputFormat.format(parsed);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
