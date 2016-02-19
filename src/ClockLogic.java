import java.text.DecimalFormat;
import java.util.Calendar;

//Klassen
    public class ClockLogic {
	private ClockLogic clockLogic;
	private int alarmHour;
	private int alarmMinute;
	private DigitalClockGUI digClockGUI;
	
//constructor 
	public ClockLogic(DigitalClockGUI digitalClockGUI){
		this.digClockGUI = digitalClockGUI;
		ClockThread ca = new ClockThread();
		ca.start();	
}
	
//metoder
	public void setAlarm(int hours, int minutes){
		this.alarmHour = hours;
		this.alarmMinute = minutes;
	}
	
	public void clearAlarm(){
		setAlarm(-1, -1);
		
		digClockGUI.activeAlarm(false);
		
	}
	
private class ClockThread extends Thread{
	public void run(){
		DecimalFormat df = new DecimalFormat("00");
		
		while(true){
			try {
				Thread.sleep(900);
			} catch (InterruptedException e){
				e.printStackTrace();
				return;
			}
			
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			
			String time = (df.format(hour) + " : " + df.format(min) + " : " + df.format(second));
			System.out.println(time);
			
			digClockGUI.setTimeOnLabel(time);
			
			if((hour == alarmHour && min == alarmMinute)){
				digClockGUI.activeAlarm(true);
				System.out.println("alarm!");
			}else{
				digClockGUI.activeAlarm(false);
				System.out.println("no alarm!");
			}
		
		}
	}
}
		
}


