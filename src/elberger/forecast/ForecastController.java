package elberger.forecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.awt.Image;
import java.util.List;

import javax.swing.JLabel;

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
	
	public void requestForecastFeed(int ii, Call <ForecastFeedModel> call, JLabel hourlyTime, Image hourlyIcon, JLabel hourlyDesc,
									JLabel hourlyHigh, JLabel hourlyLow)
	{
		call.enqueue(new Callback<ForecastFeedModel>()
				{
					@Override
					public void onResponse(Call <ForecastFeedModel> call, Response <ForecastFeedModel> response)
					{
						ForecastFeedModel feed = response.body();
						
						showForecast(ii, feed, hourlyTime, hourlyIcon, hourlyDesc, hourlyHigh, hourlyLow);
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
		requestForecastFeed(0, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly1Time(),
				view.getHourly1Icon(),view.getHourly1Desc(), view.getHourly1High(), view.getHourly1Low());
	}	
	public void requestForecast2()
	{
		requestForecastFeed(1, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly2Time(), 
				view.getHourly2Icon(), view.getHourly2Desc(), view.getHourly2High(), view.getHourly2Low());
	}	
	public void requestForecast3()
	{
		requestForecastFeed(2, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly3Time(),
				view.getHourly3Icon(), view.getHourly3Desc(), view.getHourly3High(), view.getHourly3Low());
	}	
	public void requestForecast4()
	{
		requestForecastFeed(3, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly4Time(),
				view.getHourly4Icon(), view.getHourly4Desc(), view.getHourly4High(), view.getHourly4Low());
	}	
	public void requestForecast5()
	{
		requestForecastFeed(4, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly5Time(), 
				view.getHourly5Icon(), view.getHourly5Desc(), view.getHourly5High(), view.getHourly5Low());
	}	
	public void requestForecast6()
	{
		requestForecastFeed(5, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly6Time(), 
				view.getHourly6Icon(), view.getHourly6Desc(), view.getHourly6High(), view.getHourly6Low());
	}	
	public void requestForecast7()
	{
		requestForecastFeed(6, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly7Time(),
				view.getHourly7Icon(), view.getHourly7Desc(), view.getHourly7High(), view.getHourly7Low());
	}	
	public void requestForecast8()
	{
		requestForecastFeed(7, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getHourly8Time(),
				view.getHourly8Icon(), view.getHourly8Desc(), view.getHourly8High(), view.getHourly8Low());
	}
	
	void showForecast(int ii, ForecastFeedModel feed, JLabel hourlyTime, Image hourlyIcon, JLabel hourlyDesc, JLabel hourlyHigh, JLabel hourlyLow)
	{
		List<Forecast> info = feed.getList();
		String fullTime = info.get(ii).getDt_txt();
		String fullTimeSplit[] = fullTime.split(" " , 2);
		String time = fullTimeSplit[1];
		String[] timeSplit = time.split(":", 3); 
		if (Integer.parseInt(timeSplit[0]) == 12)
		{
			hourlyTime.setText("12" + ":" + timeSplit[1] + " PM");						
		}
		else if (Integer.parseInt(timeSplit[0]) == 0)
		{
			hourlyTime.setText("12" + ":" + timeSplit[1] + " AM");			
		}
		else if (Integer.parseInt(timeSplit[0]) < 12)
		{
			String hour = timeSplit[0];
			String[] hourSplit = hour.split("0", 2);
			hourlyTime.setText(hourSplit[1] + ":" + timeSplit[1] + " AM");
		}
		else if (Integer.parseInt(timeSplit[0]) > 12)
		{
			int hour = Integer.parseInt(timeSplit[0]) - 12;
			timeSplit[0] = String.valueOf(hour);
			hourlyTime.setText(timeSplit[0] + ":" + timeSplit[1] + " PM");
		}

		//set icon
		
		hourlyDesc.setText(info.get(ii).getDescription());
		hourlyHigh.setText("High: " + String.valueOf(info.get(ii).getMain().getTemp_max()) + "°F");
		hourlyLow.setText("Low: " + String.valueOf(info.get(ii).getMain().getTemp_min()) + "°F");
	}
}
