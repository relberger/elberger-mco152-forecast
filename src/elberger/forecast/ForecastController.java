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
	
	void showForecast(int ii, ForecastFeedModel feed, JLabel time, JLabel icon, JLabel desc, JLabel high, JLabel low) throws MalformedURLException
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
		
		URL iconUrl = new URL("http://openweathermap.org/img/w/" + weather[0].getIcon() + ".png");
		ImageIcon image = new ImageIcon(iconUrl);
		icon.setIcon(image);
		
		desc.setText(weather[0].getDescription());
		
		high.setText("High: " + String.valueOf(info.get(ii).getMain().getTemp_max()) + "°F");
		
		low.setText("Low: " + String.valueOf(info.get(ii).getMain().getTemp_min()) + "°F");
	}
	
	public void zipValidation() throws IOException
	{
		Call <ForecastFeedModel> call = service.addToUrl(view.getUserZip(), "c62a04efaf47575752e10468810ee065");
		Response<ForecastFeedModel> response = call.execute();
		
		if(response.errorBody() != null)
		{
			view.getUserZipField().setText("Please enter a valid zip code");
			clearAllFields();			
		}
	}

	private void clearAllFields()
	{
		view.getTime1().setText("");
		view.getIcon1().setIcon(null);
		view.getDesc1().setText("");
		view.getHigh1().setText("");
		view.getLow1().setText("");		
		
		view.getTime2().setText("");
		view.getIcon2().setIcon(null);
		view.getDesc2().setText("");
		view.getHigh2().setText("");
		view.getLow2().setText("");
		
		view.getTime3().setText("");
		view.getIcon3().setIcon(null);
		view.getDesc3().setText("");
		view.getHigh3().setText("");
		view.getLow3().setText("");
		
		view.getTime4().setText("");
		view.getIcon4().setIcon(null);
		view.getDesc4().setText("");
		view.getHigh4().setText("");
		view.getLow4().setText("");
		
		view.getTime5().setText("");
		view.getIcon5().setIcon(null);
		view.getDesc5().setText("");
		view.getHigh5().setText("");
		view.getLow5().setText("");

		view.getTime6().setText("");
		view.getIcon6().setIcon(null);
		view.getDesc6().setText("");
		view.getHigh6().setText("");
		view.getLow6().setText("");		

		view.getTime7().setText("");
		view.getIcon7().setIcon(null);
		view.getDesc7().setText("");
		view.getHigh7().setText("");
		view.getLow7().setText("");			

		view.getTime8().setText("");
		view.getIcon8().setIcon(null);
		view.getDesc8().setText("");
		view.getHigh8().setText("");
		view.getLow8().setText("");
	}
}
