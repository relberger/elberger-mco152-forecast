package elberger.forecast;

import retrofit2.Call;
import retrofit2.http.GET;
//import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ForecastService
{
	@GET("http://api.openweathermap.org/data/2.5/forecast?")
	Call<ForecastFeedModel> addToUrl(@Query("zip") String zip, @Query("APPID") String apiKey);
}
