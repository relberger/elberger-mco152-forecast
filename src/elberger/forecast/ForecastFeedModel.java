package elberger.forecast;

import java.util.List;

public class ForecastFeedModel
{
	private List<Forecast> list;

	public ForecastFeedModel(List<Forecast> list)
	{
		this.list = list;
	}

	public List<Forecast> getList()
	{
		return list;
	}
}
