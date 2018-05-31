package elberger.forecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
						
						try
						{
							showForecast(ii, feed, time, icon, desc, high, low);
						} catch (MalformedURLException e)
						{
							e.printStackTrace();
						}
					}

					@Override
					public void onFailure(Call<ForecastFeedModel> call, Throwable t)
					{
						t.printStackTrace();						
					}
				});
	}
	
	public void requestForecast()
	{
		List<WeatherPanel> weatherPanel = view.getWeatherPanel();
				
		requestForecastFeed(0, service.getWeatherByZip(view.getUserZip()), weatherPanel.get(0).getTime(),
				weatherPanel.get(0).getIcon(), weatherPanel.get(0).getDesc(), weatherPanel.get(0).getHigh(),
				weatherPanel.get(0).getLow());
		requestForecastFeed(1, service.getWeatherByZip(view.getUserZip()), weatherPanel.get(1).getTime(),
				weatherPanel.get(1).getIcon(), weatherPanel.get(1).getDesc(), weatherPanel.get(1).getHigh(),
				weatherPanel.get(1).getLow());

	}	
	
	void showForecast(int ii, ForecastFeedModel feed, JLabel time, JLabel icon, JLabel desc, JLabel high, JLabel low) throws MalformedURLException
	{
		for(int ix = 0; ix < 8; ix++)
		{
			List<Forecast> info = feed.getList();
			
			String timeStamp = info.get(ii).getDt_txt();
			String timeStampSplit[] = timeStamp.split(" " , 2);
			String fullTime = timeStampSplit[1];
			String[] timeSplit = fullTime.split(":", 3); 
			int hour = Integer.parseInt(timeSplit[0]);
			if (hour == 12)
			{
				time.setText("12" + ":" + timeSplit[1] + " PM");						
			}
			else if (hour == 0)
			{
				time.setText("12" + ":" + timeSplit[1] + " AM");			
			}
			else if (hour < 12)
			{
				String hr = timeSplit[0];
				String[] hourSplit = hr.split("0", 2);
				time.setText(hourSplit[1] + ":" + timeSplit[1] + " AM");
			}
			else if (hour > 12)
			{
				int hr = Integer.parseInt(timeSplit[0]) - 12;
				timeSplit[0] = String.valueOf(hr);
				time.setText(timeSplit[0] + ":" + timeSplit[1] + " PM");
			}

			ForecastWeather weather[] = info.get(ii).getWeather();
			
			URL iconUrl = new URL("http://openweathermap.org/img/w/" + weather[0].getIcon() + ".png");
			ImageIcon image = new ImageIcon(iconUrl);
			icon.setIcon(image);
			
			desc.setText(weather[0].getDescription());
			
			high.setText("High: " + String.valueOf(info.get(ii).getMain().getTemp_max()) + "°F");
			
			low.setText("Low: " + String.valueOf(info.get(ii).getMain().getTemp_min()) + "°F");
		}
	}
	
	public void zipValidation() throws IOException
	{
		Call <ForecastFeedModel> call = service.getWeatherByZip(view.getUserZip());
		Response<ForecastFeedModel> response = call.execute();
		
		if(response.errorBody() != null)
		{
			view.getUserZipField().setText("Please enter a valid zip code");
			clearAllFields();			
		}
	}

	private void clearAllFields()
	{
		List<WeatherPanel> weatherPanel = view.getWeatherPanel();
		weatherPanel.clear();
	}
}
