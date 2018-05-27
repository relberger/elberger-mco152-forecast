package elberger.forecast;

public class Forecast
{
	private String description;
	private String icon;
	private ForecastWeather[] weather;
	private ForecastMain main;
	private String dt_txt;

	public Forecast(String description, String icon, double temp_min, double temp_max)
	{
		this.description = description;
		this.icon = icon;
		for (int ii = 0; ii < weather.length; ii++)
		{
			weather[ii] = new ForecastWeather(this.description, this.icon);
		}
		main = new ForecastMain(temp_min, temp_max);
	}
		
	public String getDescription()
	{
		return description;
	}


	public String getIcon()
	{
		return icon;
	
	}	

	public ForecastWeather[] getWeather()
	{
		getDescription();
		getIcon();
		return weather;
	}
	
	public ForecastMain getMain()
	{
		return main;
	}

	public String getDt_txt()
	{
		return dt_txt;
	}
}
