package elberger.forecast;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForecastView extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField userZip;
	private JLabel hourly1Time;
	private Image hourly1Icon;
	private JLabel hourly1Desc;
	private JLabel hourly1High;
	private JLabel hourly1Low;
	private JLabel hourly2Time;
	private Image hourly2Icon;
	private JLabel hourly2Desc;
	private JLabel hourly2High;
	private JLabel hourly2Low;
	private JLabel hourly3Time;
	private Image hourly3Icon;
	private JLabel hourly3Desc;
	private JLabel hourly3High;
	private JLabel hourly3Low;
	private JLabel hourly4Time;
	private Image hourly4Icon;
	private JLabel hourly4Desc;
	private JLabel hourly4High;
	private JLabel hourly4Low;
	private JLabel hourly5Time;
	private Image hourly5Icon;
	private JLabel hourly5Desc;
	private JLabel hourly5High;
	private JLabel hourly5Low;
	private JLabel hourly6Time;
	private Image hourly6Icon;
	private JLabel hourly6Desc;
	private JLabel hourly6High;
	private JLabel hourly6Low;
	private JLabel hourly7Time;
	private Image hourly7Icon;
	private JLabel hourly7Desc;
	private JLabel hourly7High;
	private JLabel hourly7Low;
	private JLabel hourly8Time;
	private Image hourly8Icon;
	private JLabel hourly8Desc;
	private JLabel hourly8High;
	private JLabel hourly8Low;
	
	public ForecastView()
	{
		setTitle("Weather");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel zipPanel = new JPanel();
		zipPanel.setLayout(new BoxLayout(zipPanel, BoxLayout.X_AXIS));
		
		JLabel enterZip = new JLabel("Enter zip code: ");
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
			controller.requestForecast1();
			controller.requestForecast2();
			controller.requestForecast3();
			controller.requestForecast4();
			controller.requestForecast5();
			controller.requestForecast6();
			controller.requestForecast7();
			controller.requestForecast8();
		});
		
		zipPanel.add(enterZip);
		zipPanel.add(userZip);
		zipPanel.add(search);
		panel.add(zipPanel, BorderLayout.NORTH);
		
		JPanel hourly1 = new JPanel();
		hourly1.setLayout(new BoxLayout(hourly1, BoxLayout.Y_AXIS));
		hourly1Time = new JLabel();
		hourly1Desc = new JLabel();
		hourly1High = new JLabel();
		hourly1Low = new JLabel();
		hourly1.add(hourly1Time);
		hourly1.add(hourly1Desc);
		hourly1.add(hourly1High);
		hourly1.add(hourly1Low);
		
		JPanel hourly2 = new JPanel();
		hourly2.setLayout(new BoxLayout(hourly2, BoxLayout.Y_AXIS));
		hourly2Time = new JLabel();
		hourly2Desc = new JLabel();
		hourly2High = new JLabel();
		hourly2Low = new JLabel();
		hourly2.add(hourly2Time);
		hourly2.add(hourly2Desc);
		hourly2.add(hourly2High);
		hourly2.add(hourly2Low);	
		
		JPanel hourly3 = new JPanel();
		hourly3.setLayout(new BoxLayout(hourly3, BoxLayout.Y_AXIS));	
		hourly3Time = new JLabel();
		hourly3Desc = new JLabel();
		hourly3High = new JLabel();
		hourly3Low = new JLabel();
		hourly3.add(hourly3Time);
		hourly3.add(hourly3Desc);
		hourly3.add(hourly3High);
		hourly3.add(hourly3Low);
		
		JPanel hourly4 = new JPanel();
		hourly4.setLayout(new BoxLayout(hourly4, BoxLayout.Y_AXIS));	
		hourly4Time = new JLabel();
		hourly4Desc = new JLabel();
		hourly4High = new JLabel();
		hourly4Low = new JLabel();
		hourly4.add(hourly4Time);
		hourly4.add(hourly4Desc);
		hourly4.add(hourly4High);
		hourly4.add(hourly4Low);
		
		JPanel hourly5 = new JPanel();
		hourly5.setLayout(new BoxLayout(hourly5, BoxLayout.Y_AXIS));	
		hourly5Time = new JLabel();
		hourly5Desc = new JLabel();
		hourly5High = new JLabel();
		hourly5Low = new JLabel();
		hourly5.add(hourly5Time);
		hourly5.add(hourly5Desc);
		hourly5.add(hourly5High);
		hourly5.add(hourly5Low);
		
		JPanel hourly6 = new JPanel();
		hourly6.setLayout(new BoxLayout(hourly6, BoxLayout.Y_AXIS));
		hourly6Time = new JLabel();
		hourly6Desc = new JLabel();
		hourly6High = new JLabel();
		hourly6Low = new JLabel();
		hourly6.add(hourly6Time);
		hourly6.add(hourly6Desc);
		hourly6.add(hourly6High);
		hourly6.add(hourly6Low);	

		JPanel hourly7 = new JPanel();
		hourly7.setLayout(new BoxLayout(hourly7, BoxLayout.Y_AXIS));	
		hourly7Time = new JLabel();
		hourly7Desc = new JLabel();
		hourly7High = new JLabel();
		hourly7Low = new JLabel();
		hourly7.add(hourly7Time);
		hourly7.add(hourly7Desc);
		hourly7.add(hourly7High);
		hourly7.add(hourly7Low);
		
		JPanel hourly8 = new JPanel();
		hourly8.setLayout(new BoxLayout(hourly8, BoxLayout.Y_AXIS));
		hourly8Time = new JLabel();
		hourly8Desc = new JLabel();
		hourly8High = new JLabel();
		hourly8Low = new JLabel();
		hourly8.add(hourly8Time);
		hourly8.add(hourly8Desc);
		hourly8.add(hourly8High);
		hourly8.add(hourly8Low);
		
		
		
		JPanel hourlyWeather = new JPanel();
		hourlyWeather.setLayout(new GridLayout(1,8));
		
		hourlyWeather.add(hourly1);
		hourlyWeather.add(hourly2);
		hourlyWeather.add(hourly3);
		hourlyWeather.add(hourly4);
		hourlyWeather.add(hourly5);
		hourlyWeather.add(hourly6);
		hourlyWeather.add(hourly7);
		hourlyWeather.add(hourly8);
		panel.add(hourlyWeather, BorderLayout.CENTER);
		
		add(panel);
	}

	public String getUserZip()
	{
		return userZip.getText();
	}

	public JLabel getHourly1Time()
	{
		return hourly1Time;
	}
	
	public Image getHourly1Icon()
	{
		return hourly1Icon;
	}

	public JLabel getHourly1Desc()
	{
		return hourly1Desc;
	}

	public JLabel getHourly1High()
	{
		return hourly1High;
	}

	public JLabel getHourly1Low()
	{
		return hourly1Low;
	}

	public JLabel getHourly2Time()
	{
		return hourly2Time;
	}

	public Image getHourly2Icon()
	{
		return hourly2Icon;
	}

	public JLabel getHourly2Desc()
	{
		return hourly2Desc;
	}

	public JLabel getHourly2High()
	{
		return hourly2High;
	}

	public JLabel getHourly2Low()
	{
		return hourly2Low;
	}

	public JLabel getHourly3Time()
	{
		return hourly3Time;
	}
	
	public Image getHourly3Icon()
	{
		return hourly3Icon;
	}

	public JLabel getHourly3Desc()
	{
		return hourly3Desc;
	}

	public JLabel getHourly3High()
	{
		return hourly3High;
	}

	public JLabel getHourly3Low()
	{
		return hourly3Low;
	}

	public JLabel getHourly4Time()
	{
		return hourly4Time;
	}

	public Image getHourly4Icon()
	{
		return hourly4Icon;
	}

	public JLabel getHourly4Desc()
	{
		return hourly4Desc;
	}

	public JLabel getHourly4High()
	{
		return hourly4High;
	}

	public JLabel getHourly4Low()
	{
		return hourly4Low;
	}

	public JLabel getHourly5Time()
	{
		return hourly5Time;
	}

	public Image getHourly5Icon()
	{
		return hourly5Icon;
	}

	public JLabel getHourly5Desc()
	{
		return hourly5Desc;
	}

	public JLabel getHourly5High()
	{
		return hourly5High;
	}

	public JLabel getHourly5Low()
	{
		return hourly5Low;
	}

	public JLabel getHourly6Time()
	{
		return hourly6Time;
	}

	public Image getHourly6Icon()
	{
		return hourly6Icon;
	}

	public JLabel getHourly6Desc()
	{
		return hourly6Desc;
	}

	public JLabel getHourly6High()
	{
		return hourly6High;
	}

	public JLabel getHourly6Low()
	{
		return hourly6Low;
	}

	public JLabel getHourly7Time()
	{
		return hourly7Time;
	}

	public Image getHourly7Icon()
	{
		return hourly7Icon;
	}

	public JLabel getHourly7Desc()
	{
		return hourly7Desc;
	}

	public JLabel getHourly7High()
	{
		return hourly7High;
	}

	public JLabel getHourly7Low()
	{
		return hourly7Low;
	}

	public JLabel getHourly8Time()
	{
		return hourly8Time;
	}

	public Image getHourly8Icon()
	{
		return hourly8Icon;
	}

	public JLabel getHourly8Desc()
	{
		return hourly8Desc;
	}

	public JLabel getHourly8High()
	{
		return hourly8High;
	}

	public JLabel getHourly8Low()
	{
		return hourly8Low;
	}

	public static void main(String[] args)
	{
		new ForecastView().setVisible(true);
	}
}
