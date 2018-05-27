package elberger.forecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	public void requestForecastFeed(int ii, Call <ForecastFeedModel> call, JLabel time, JLabel icon, JLabel desc,
									JLabel high, JLabel low)
	{
		call.enqueue(new Callback<ForecastFeedModel>()
				{
					@Override
					public void onResponse(Call <ForecastFeedModel> call, Response <ForecastFeedModel> response)
					{
						ForecastFeedModel feed = response.body();
						
						showForecast(ii, feed, time, icon, desc, high, low);
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
		requestForecastFeed(0, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime1(),
				view.getIcon1(),view.getDesc1(), view.getHigh1(), view.getLow1());
	}	
	public void requestForecast2()
	{
		requestForecastFeed(1, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime2(), 
				view.getIcon2(), view.getDesc2(), view.getHigh2(), view.getLow2());
	}	
	public void requestForecast3()
	{
		requestForecastFeed(2, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime3(),
				view.getIcon3(), view.getDesc3(), view.getHigh3(), view.getLow3());
	}	
	public void requestForecast4()
	{
		requestForecastFeed(3, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime4(),
				view.getIcon4(), view.getDesc4(), view.getHigh4(), view.getLow4());
	}	
	public void requestForecast5()
	{
		requestForecastFeed(4, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime5(), 
				view.getIcon5(), view.getDesc5(), view.getHigh5(), view.getLow5());
	}	
	public void requestForecast6()
	{
		requestForecastFeed(5, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime6(), 
				view.getIcon6(), view.getDesc6(), view.getHigh6(), view.getLow6());
	}	
	public void requestForecast7()
	{
		requestForecastFeed(6, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime7(),
				view.getIcon7(), view.getDesc7(), view.getHigh7(), view.getLow7());
	}	
	public void requestForecast8()
	{
		requestForecastFeed(7, service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065"), view.getTime8(),
				view.getIcon8(), view.getDesc8(), view.getHigh8(), view.getLow8());
	}
	
	void showForecast(int ii, ForecastFeedModel feed, JLabel time, JLabel icon, JLabel desc, JLabel high, JLabel low)
	{
		List<Forecast> info = feed.getList();
		
		String timeStamp = info.get(ii).getDt_txt();
		String timeStampSplit[] = timeStamp.split(" " , 2);
		String fullTime = timeStampSplit[1];
		String[] timeSplit = fullTime.split(":", 3); 
		if (Integer.parseInt(timeSplit[0]) == 12)
		{
			time.setText("12" + ":" + timeSplit[1] + " PM");						
		}
		else if (Integer.parseInt(timeSplit[0]) == 0)
		{
			time.setText("12" + ":" + timeSplit[1] + " AM");			
		}
		else if (Integer.parseInt(timeSplit[0]) < 12)
		{
			String hour = timeSplit[0];
			String[] hourSplit = hour.split("0", 2);
			time.setText(hourSplit[1] + ":" + timeSplit[1] + " AM");
		}
		else if (Integer.parseInt(timeSplit[0]) > 12)
		{
			int hour = Integer.parseInt(timeSplit[0]) - 12;
			timeSplit[0] = String.valueOf(hour);
			time.setText(timeSplit[0] + ":" + timeSplit[1] + " PM");
		}

		ForecastWeather weather[] = info.get(ii).getWeather();
		
		ImageIcon image = new ImageIcon("http://openweathermap.org/img/w/" + weather[0].getIcon() + ".png");
		icon.setIcon(image);
		
		desc.setText(weather[0].getDescription());
		
		high.setText("High: " + String.valueOf(info.get(ii).getMain().getTemp_max()) + "°F");
		
		low.setText("Low: " + String.valueOf(info.get(ii).getMain().getTemp_min()) + "°F");
	}
}
