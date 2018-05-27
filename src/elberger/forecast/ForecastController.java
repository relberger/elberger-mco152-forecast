package elberger.forecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.awt.Image;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class ForecastController
{
	private ForecastView view;
	private ForecastService service;
	
	public ForecastController(ForecastView view, ForecastService service)
	{
		super();
		this.view = view;
		this.service = service;
	}
	
	public void requestForecastFeed(Call <ForecastFeedModel> call, Image hourlyIcon, JLabel hourlyDesc,
									JLabel hourlyHigh, JLabel hourlyLow)
	{
		call.enqueue(new Callback<ForecastFeedModel>()
				{
					@Override
					public void onResponse(Call <ForecastFeedModel> call, Response <ForecastFeedModel> response)
					{
						ForecastFeedModel feed = response.body();
						
						showForecast(feed, hourlyIcon, hourlyDesc, hourlyHigh, hourlyLow);
					}

					@Override
					public void onFailure(Call<ForecastFeedModel> call, Throwable t)
					{
						t.printStackTrace();						
					}
				});
	}
	
	public void requestForecast1()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly1Icon(),
				view.getHourly1Desc(), view.getHourly1High(), view.getHourly1Low());
	}	
	public void requestForecast2()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly2Icon(),
				view.getHourly2Desc(), view.getHourly2High(), view.getHourly2Low());
	}	
	public void requestForecast3()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly3Icon(),
				view.getHourly3Desc(), view.getHourly3High(), view.getHourly3Low());
	}	
	public void requestForecast4()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly4Icon(),
				view.getHourly4Desc(), view.getHourly4High(), view.getHourly4Low());
	}	
	public void requestForecast5()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly5Icon(),
				view.getHourly5Desc(), view.getHourly5High(), view.getHourly5Low());
	}	
	public void requestForecast6()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly6Icon(),
				view.getHourly6Desc(), view.getHourly6High(), view.getHourly6Low());
	}	
	public void requestForecast7()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly7Icon(),
				view.getHourly7Desc(), view.getHourly7High(), view.getHourly7Low());
	}	
	public void requestForecast8()
	{
		requestForecastFeed(service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly8Icon(),
				view.getHourly8Desc(), view.getHourly8High(), view.getHourly8Low());
	}
	
	void showForecast(ForecastFeedModel feed, Image hourlyIcon, JLabel hourlyDesc, JLabel hourlyHigh, JLabel hourlyLow)
	{
		List<Forecast> info = feed.getList();
		//can't all be zero or use time to display...?
		//set icon
		info.get(0).getWeather();
		//hourlyDesc.setText(info.get(0).getWeather());
		//hourlyHigh.setText(String.valueOf(info.get(0).getMain().));
		//hourlyLow.setText(String.valueOf(info.get(0).getMain().getTemp_min()));
	}
}
