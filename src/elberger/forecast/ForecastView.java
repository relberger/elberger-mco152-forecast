package elberger.forecast;

import java.awt.*;
import javax.swing.*;

public class ForecastView extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField userZip;
	private Image hourly1Icon;
	private JLabel hourly1Desc;
	private JLabel hourly1High;
	private JLabel hourly1Low;
	private Image hourly2Icon;
	private JLabel hourly2Desc;
	private JLabel hourly2High;
	private JLabel hourly2Low;
	private Image hourly3Icon;
	private JLabel hourly3Desc;
	private JLabel hourly3High;
	private JLabel hourly3Low;
	private Image hourly4Icon;
	private JLabel hourly4Desc;
	private JLabel hourly4High;
	private JLabel hourly4Low;
	private Image hourly5Icon;
	private JLabel hourly5Desc;
	private JLabel hourly5High;
	private JLabel hourly5Low;
	private Image hourly6Icon;
	private JLabel hourly6Desc;
	private JLabel hourly6High;
	private JLabel hourly6Low;
	private Image hourly7Icon;
	private JLabel hourly7Desc;
	private JLabel hourly7High;
	private JLabel hourly7Low;
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
		
		zipPanel.add(enterZip);
		zipPanel.add(userZip);
		zipPanel.add(search);
		panel.add(zipPanel, BorderLayout.NORTH);
		
		JPanel hourly1 = new JPanel();
		hourly1.setLayout(new BoxLayout(hourly1, BoxLayout.Y_AXIS));	
		hourly1.add(hourly1Desc);
		hourly1.add(hourly1High);
		hourly1.add(hourly1Low);
		
		JPanel hourly2 = new JPanel();
		hourly2.setLayout(new BoxLayout(hourly2, BoxLayout.Y_AXIS));
		hourly1.add(hourly2Desc);
		hourly1.add(hourly2High);
		hourly1.add(hourly2Low);	
		
		JPanel hourly3 = new JPanel();
		hourly3.setLayout(new BoxLayout(hourly3, BoxLayout.Y_AXIS));	
		hourly1.add(hourly3Desc);
		hourly1.add(hourly3High);
		hourly1.add(hourly3Low);
		
		JPanel hourly4 = new JPanel();
		hourly4.setLayout(new BoxLayout(hourly4, BoxLayout.Y_AXIS));	
		hourly1.add(hourly4Desc);
		hourly1.add(hourly4High);
		hourly1.add(hourly4Low);
		
		JPanel hourly5 = new JPanel();
		hourly5.setLayout(new BoxLayout(hourly5, BoxLayout.Y_AXIS));	
		hourly1.add(hourly5Desc);
		hourly1.add(hourly5High);
		hourly1.add(hourly5Low);
		
		JPanel hourly6 = new JPanel();
		hourly6.setLayout(new BoxLayout(hourly6, BoxLayout.Y_AXIS));
		hourly1.add(hourly6Desc);
		hourly1.add(hourly6High);
		hourly1.add(hourly6Low);	

		JPanel hourly7 = new JPanel();
		hourly7.setLayout(new BoxLayout(hourly7, BoxLayout.Y_AXIS));	
		hourly1.add(hourly7Desc);
		hourly1.add(hourly7High);
		hourly1.add(hourly7Low);
		
		JPanel hourly8 = new JPanel();
		hourly8.setLayout(new BoxLayout(hourly8, BoxLayout.Y_AXIS));
		hourly1.add(hourly8Desc);
		hourly1.add(hourly8High);
		hourly1.add(hourly8Low);
		
		
		
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

	public JTextField getUserZip()
	{
		return userZip;
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