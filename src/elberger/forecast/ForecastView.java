package elberger.forecast;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForecastView extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField userZip;
	private List <WeatherPanel> weatherPanels;
	
	public ForecastView()
	{
		setTitle("Weather");
		setSize(900, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel zipPanel = new JPanel();
		zipPanel.setLayout(new BoxLayout(zipPanel, BoxLayout.X_AXIS));
		
		JLabel enterZip = new JLabel("Enter zip code for weather in the next 24 hours: ");
		userZip = new JTextField();
		JButton search = new JButton("Search");
		
		search.addActionListener(e ->
		{
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("http://api.openweathermap.org")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			
			ForecastService service = retrofit.create(ForecastService.class);
			ForecastController controller = new ForecastController(this, service);
			controller.requestForecast();
			/*try
			{
				controller.zipValidation();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}*/ 
		});
		
		zipPanel.add(enterZip);
		zipPanel.add(userZip);
		zipPanel.add(search);
		panel.add(zipPanel, BorderLayout.NORTH);
		
		JPanel hourlyWeather = new JPanel();
		hourlyWeather.setLayout(new GridLayout(1,8));
		
		weatherPanels = new ArrayList<WeatherPanel>(); 
		
		for (int i = 0; i < 8; i++)
		{
			WeatherPanel weather = new WeatherPanel();
			weatherPanels.add(weather);
			hourlyWeather.add(weather);			
		}
		
		panel.add(hourlyWeather, BorderLayout.CENTER);
		
		add(panel);
	}

	public String getUserZip()
	{
		return userZip.getText();
	}

	public JTextField getUserZipField()
	{
		return userZip;
	}

	public List<WeatherPanel> getWeatherPanels()
	{
		return weatherPanels;
	}

	public static void main(String[] args)
	{
		new ForecastView().setVisible(true);
	}
}
