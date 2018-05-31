package elberger.forecast;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForecastView extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField userZip;
	private JLabel time1;
	private JLabel icon1;
	private JLabel desc1;
	private JLabel high1;
	private JLabel low1;
	private JLabel time2;
	private JLabel icon2;
	private JLabel desc2;
	private JLabel high2;
	private JLabel low2;
	private JLabel time3;
	private JLabel icon3;
	private JLabel desc3;
	private JLabel high3;
	private JLabel low3;
	private JLabel time4;
	private JLabel icon4;
	private JLabel desc4;
	private JLabel high4;
	private JLabel low4;
	private JLabel time5;
	private JLabel icon5;
	private JLabel desc5;
	private JLabel high5;
	private JLabel low5;
	private JLabel time6;
	private JLabel icon6;
	private JLabel desc6;
	private JLabel high6;
	private JLabel low6;
	private JLabel time7;
	private JLabel icon7;
	private JLabel desc7;
	private JLabel high7;
	private JLabel low7;
	private JLabel time8;
	private JLabel icon8;
	private JLabel desc8;
	private JLabel high8;
	private JLabel low8;
	
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
			try
			{
				controller.zipValidation();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
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
		time1 = new JLabel();
		icon1 = new JLabel();
		desc1 = new JLabel();
		high1 = new JLabel();
		low1 = new JLabel();
		hourly1.add(time1);
		hourly1.add(icon1);
		hourly1.add(desc1);
		hourly1.add(high1);
		hourly1.add(low1);
		
		JPanel hourly2 = new JPanel();
		hourly2.setLayout(new BoxLayout(hourly2, BoxLayout.Y_AXIS));
		time2 = new JLabel();
		icon2 = new JLabel();
		desc2 = new JLabel();
		high2 = new JLabel();
		low2 = new JLabel();
		hourly2.add(time2);
		hourly2.add(icon2);
		hourly2.add(desc2);
		hourly2.add(high2);
		hourly2.add(low2);	
		
		JPanel hourly3 = new JPanel();
		hourly3.setLayout(new BoxLayout(hourly3, BoxLayout.Y_AXIS));	
		time3 = new JLabel();
		icon3 = new JLabel();
		desc3 = new JLabel();
		high3 = new JLabel();
		low3 = new JLabel();
		hourly3.add(time3);
		hourly3.add(icon3);
		hourly3.add(desc3);
		hourly3.add(high3);
		hourly3.add(low3);
		
		JPanel hourly4 = new JPanel();
		hourly4.setLayout(new BoxLayout(hourly4, BoxLayout.Y_AXIS));	
		time4 = new JLabel();
		icon4 = new JLabel();
		desc4 = new JLabel();
		high4 = new JLabel();
		low4 = new JLabel();
		hourly4.add(time4);
		hourly4.add(icon4);
		hourly4.add(desc4);
		hourly4.add(high4);
		hourly4.add(low4);
		
		JPanel hourly5 = new JPanel();
		hourly5.setLayout(new BoxLayout(hourly5, BoxLayout.Y_AXIS));	
		time5 = new JLabel();
		icon5 = new JLabel();
		desc5 = new JLabel();
		high5 = new JLabel();
		low5 = new JLabel();
		hourly5.add(time5);
		hourly5.add(icon5);
		hourly5.add(desc5);
		hourly5.add(high5);
		hourly5.add(low5);
		
		JPanel hourly6 = new JPanel();
		hourly6.setLayout(new BoxLayout(hourly6, BoxLayout.Y_AXIS));
		time6 = new JLabel();
		icon6 = new JLabel();
		desc6 = new JLabel();
		high6 = new JLabel();
		low6 = new JLabel();
		hourly6.add(time6);
		hourly6.add(icon6);
		hourly6.add(desc6);
		hourly6.add(high6);
		hourly6.add(low6);	

		JPanel hourly7 = new JPanel();
		hourly7.setLayout(new BoxLayout(hourly7, BoxLayout.Y_AXIS));	
		time7 = new JLabel();
		icon7 = new JLabel();
		desc7 = new JLabel();
		high7 = new JLabel();
		low7 = new JLabel();
		hourly7.add(time7);
		hourly7.add(icon7);
		hourly7.add(desc7);
		hourly7.add(high7);
		hourly7.add(low7);
		
		JPanel hourly8 = new JPanel();
		hourly8.setLayout(new BoxLayout(hourly8, BoxLayout.Y_AXIS));
		time8 = new JLabel();
		icon8 = new JLabel();
		desc8 = new JLabel();
		high8 = new JLabel();
		low8 = new JLabel();
		hourly8.add(time8);
		hourly8.add(icon8);
		hourly8.add(desc8);
		hourly8.add(high8);
		hourly8.add(low8);
		
		
		
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

	public JTextField getUserZipField()
	{
		return userZip;
	}
	
	public JLabel getTime1()
	{
		return time1;
	}
	
	public JLabel getIcon1()
	{
		return icon1;
	}

	public JLabel getDesc1()
	{
		return desc1;
	}

	public JLabel getHigh1()
	{
		return high1;
	}

	public JLabel getLow1()
	{
		return low1;
	}

	public JLabel getTime2()
	{
		return time2;
	}

	public JLabel getIcon2()
	{
		return icon2;
	}

	public JLabel getDesc2()
	{
		return desc2;
	}

	public JLabel getHigh2()
	{
		return high2;
	}

	public JLabel getLow2()
	{
		return low2;
	}

	public JLabel getTime3()
	{
		return time3;
	}
	
	public JLabel getIcon3()
	{
		return icon3;
	}

	public JLabel getDesc3()
	{
		return desc3;
	}

	public JLabel getHigh3()
	{
		return high3;
	}

	public JLabel getLow3()
	{
		return low3;
	}

	public JLabel getTime4()
	{
		return time4;
	}

	public JLabel getIcon4()
	{
		return icon4;
	}

	public JLabel getDesc4()
	{
		return desc4;
	}

	public JLabel getHigh4()
	{
		return high4;
	}

	public JLabel getLow4()
	{
		return low4;
	}

	public JLabel getTime5()
	{
		return time5;
	}

	public JLabel getIcon5()
	{
		return icon5;
	}

	public JLabel getDesc5()
	{
		return desc5;
	}

	public JLabel getHigh5()
	{
		return high5;
	}

	public JLabel getLow5()
	{
		return low5;
	}

	public JLabel getTime6()
	{
		return time6;
	}

	public JLabel getIcon6()
	{
		return icon6;
	}

	public JLabel getDesc6()
	{
		return desc6;
	}

	public JLabel getHigh6()
	{
		return high6;
	}

	public JLabel getLow6()
	{
		return low6;
	}

	public JLabel getTime7()
	{
		return time7;
	}

	public JLabel getIcon7()
	{
		return icon7;
	}

	public JLabel getDesc7()
	{
		return desc7;
	}

	public JLabel getHigh7()
	{
		return high7;
	}

	public JLabel getLow7()
	{
		return low7;
	}

	public JLabel getTime8()
	{
		return time8;
	}

	public JLabel getIcon8()
	{
		return icon8;
	}

	public JLabel getDesc8()
	{
		return desc8;
	}

	public JLabel getHigh8()
	{
		return high8;
	}

	public JLabel getLow8()
	{
		return low8;
	}

	public static void main(String[] args)
	{
		new ForecastView().setVisible(true);
	}
}
