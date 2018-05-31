package elberger.forecast;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitTest
{

	@Test
	void testRetrofit() throws IOException
	{
		//given
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.openweathermap.org")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		ForecastService service = retrofit.create(ForecastService.class);
		
		//when 
		Call<ForecastFeedModel> call = service.getWeatherByZip("07208");
		Response<ForecastFeedModel> response = call.execute();
		
		//then
		assertFalse(response.body().getList().isEmpty());
	}

}
