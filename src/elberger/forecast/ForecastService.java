package elberger.forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastService
{
	//String apiKey = "c62a04efaf47575752e10468810ee065";
	
	@GET("http://api.openweathermap.org/data/2.5/forecast?zip=90210&APPID=c62a04efaf47575752e10468810ee065")
	Call<ForecastFeedModel> useKey(@Query("APPID") );
}
