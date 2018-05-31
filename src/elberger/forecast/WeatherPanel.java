package elberger.forecast;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel time;
	private JLabel icon;
	private JLabel desc;
	private JLabel high;
	private JLabel low;
	
	public WeatherPanel()
	{
		JPanel hourly = new JPanel();
		hourly.setLayout(new BoxLayout(hourly, BoxLayout.Y_AXIS));
		time = new JLabel();
		icon = new JLabel();
		desc = new JLabel();
		high = new JLabel();
		low = new JLabel();
		hourly.add(time);
		hourly.add(icon);
		hourly.add(desc);
		hourly.add(high);
		hourly.add(low);
	}
	
	public JLabel getTime()
	{
		return time;
	}
	
	public JLabel getIcon()
	{
		return icon;
	}

	public JLabel getDesc()
	{
		return desc;
	}

	public JLabel getHigh()
	{
		return high;
	}

	public JLabel getLow()
	{
		return low;
	}
}
