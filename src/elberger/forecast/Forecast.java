package elberger.forecast;

import java.util.List;

public class Forecast
{
	private ForecastWeather weather;
	//private ForecastMainArray mainArray;
	private List<ForecastMain> main;
	private String dt_txt;
	
	public Forecast(String description, String icon, /*ForecastMainArray mainArray*/List<ForecastMain> main, double temp_min, double temp_max)
	{
		weather = new ForecastWeather(description, icon);
		this.main = main;
		main = (List<ForecastMain>) new ForecastMain(temp_min, temp_max);
	}

	public List<ForecastMain> getMain()
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
