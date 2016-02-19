import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.Color;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField setHour;
	private JTextField setMinute;
	private ClockLogic clockLogic;
	private JLabel lblSetHour;
	protected JLabel lblTime;
	private JLabel lblAlarmAt;
	private JLabel alarmMessage;
	
	//private JLabel setHour;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DigitalClockGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJohannasTid = new JLabel("JOHANNAS TIDSMASKIN");
		lblJohannasTid.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblJohannasTid.setBounds(114, 6, 236, 30);
		contentPane.add(lblJohannasTid);
		
		lblTime = new JLabel("");
		lblTime.setBounds(195, 48, 182, 45);
		contentPane.add(lblTime);
		
		setHour = new JTextField();
		setHour.setBounds(76, 105, 130, 26);
		contentPane.add(setHour);
	
		setHour.setColumns(10);
		
		JLabel lblSetHour = new JLabel("SET HOUR:");
		lblSetHour.setBounds(6, 110, 72, 16);
		contentPane.add(lblSetHour);
		
		JLabel lblSetMinute = new JLabel("SET MINUTE:");
		lblSetMinute.setBounds(218, 110, 87, 16);
		contentPane.add(lblSetMinute);
		
		setMinute = new JTextField();
		setMinute.setBounds(305, 105, 130, 26);
		contentPane.add(setMinute);
		setMinute.setColumns(10);
		
		
		JLabel lblAlarmAt = new JLabel("Alarm at:");
		lblAlarmAt.setBounds(114, 179, 226, 26);
		contentPane.add(lblAlarmAt);
		
		clockLogic = new ClockLogic(this);
	
		this.lblSetHour = lblSetHour;
		
		
		//RESET ALARM BUTTON
		JButton btnResetAlarm = new JButton("RESET ALARM");
		btnResetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.clearAlarm();
				lblAlarmAt.setText("  ");
				
				
			}
		});
		
		
		btnResetAlarm.setBounds(247, 149, 130, 29);
		contentPane.add(btnResetAlarm);
			
		
		
		//SET ALARM BUTTON
		JButton btnSetAlarm = new JButton("SET ALARM");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hourString = setHour.getText();
				int hour = Integer.parseInt(hourString);
				String minString = setMinute.getText();
				int minute = Integer.parseInt(minString);
				clockLogic.setAlarm(hour, minute);
				
				lblAlarmAt.setText("Alarm at:" + setHour.getText() + " : " + setMinute.getText());
			}
			});
			
				
		btnSetAlarm.setBounds(76, 149, 130, 29);
		contentPane.add(btnSetAlarm);
		
		JLabel alarmMessage = new JLabel("Message:");
		alarmMessage.setBounds(114, 217, 236, 16);
		contentPane.add(alarmMessage);
		this.alarmMessage = alarmMessage;
		
	}
		
			
			public void digitalClockGUI(){
				
			}
			public void setTimeOnLabel(String time){
				lblTime.setText(time);
			}
			public void setAlarmOnLabel(String alarmTime){
				lblAlarmAt.setText(alarmTime);
			}
			public void activeAlarm(boolean active){
				if(active){
					alarmMessage.setText("Message: WAKIE ");
				}else{
					alarmMessage.setText("Message: ");
				} 
			}
	}



				
