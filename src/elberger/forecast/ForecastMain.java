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
	
	public double getTemp_min()
	{
		return temp_min;
	}
	
	public double getTemp_max()
	{
		return temp_max;
	}
}
