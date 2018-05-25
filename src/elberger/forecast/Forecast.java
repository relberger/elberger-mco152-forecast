package elberger.forecast;

public class Forecast
{
	private ForecastWeather weather;
	private ForecastMain main;
	private String dt_txt;
	
	public Forecast(String description, String icon, double temp_min, double temp_max)
	{
		weather = new ForecastWeather(description, icon);
		main = new ForecastMain(temp_min, temp_max);
	}

	public ForecastMain getMain()
	{
		return main;
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
