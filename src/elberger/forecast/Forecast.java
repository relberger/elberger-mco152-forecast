package elberger.forecast;

public class Forecast
{
	private ForecastWeather weather;
	private ForecastMainArray mainArray;
	private String dt_txt;
	
	public Forecast(String description, String icon, ForecastMainArray mainArray)
	{
		weather = new ForecastWeather(description, icon);
		this.mainArray = mainArray;
	}

	public ForecastMainArray getMain()
	{
		return mainArray;
	}

	public ForecastWeather getWeather()
	{
		return weather;
	}

	public String getDt_txt()
	{
		return dt_txt;
	}
}
