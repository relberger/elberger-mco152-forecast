package elberger.forecast;

public class ForecastMain
{
	private double temp_min;
	private double temp_max;
	
	public ForecastMain(double temp_min, double temp_max)
	{
		super();
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}
	
	public int getTemp_min()
	{
		double fahrTemp = temp_min * 1.8 - 459.67;
		return (int) Math.round(fahrTemp);
	}
	
	public int getTemp_max()
	{
		double fahrTemp = temp_max * 1.8 - 459.67;
		return (int) Math.round(fahrTemp);
	}
}
