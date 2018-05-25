package elberger.forecast;

import java.util.List;

public class ForecastMainList
{
	private double temp_min; 
	private double temp_max;
	private List<ForecastMain> main;

	public ForecastMainList(List<ForecastMain> main)
	{
		main = (List<ForecastMain>) new ForecastMain(temp_min, temp_max);
	}

	public List<ForecastMain> getMain()
	{
		return main;
	}
}
