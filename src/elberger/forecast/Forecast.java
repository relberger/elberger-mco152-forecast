package elberger.forecast;

public class Forecast
{
	private ForecastWeather weather;
	private ForecastMainList mainList;
	private ForecastMain main;
	private String dt_txt;
	
	public Forecast(String description, String icon, ForecastMainList mainList)
	{
		weather = new ForecastWeather(description, icon);
		this.mainList = mainList;
	}

	public ForecastMainList getMain()
	{
		return mainList;
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
