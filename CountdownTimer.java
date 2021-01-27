import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class CountdownTimer extends TimerTask implements Runnable {
	
    private Timer timer;

    private int seconds;
    private int secondsLeft;

    private Consumer<CountdownTimer> everySecond;
    private Runnable beforeTimer;
    private Runnable afterTimer;
    
	public CountdownTimer(int seconds, Runnable beforeTimer, Runnable afterTimer, Consumer<CountdownTimer> everySecond) {
		this.seconds = seconds;
        this.secondsLeft = seconds;

        this.beforeTimer = beforeTimer;
        this.afterTimer = afterTimer;
        this.everySecond = everySecond;
    }
	
	@Override
	public void run() {
		if (secondsLeft < 1) {
			afterTimer.run();

			if (timer != null) timer.cancel();
			return;
		}

		if (secondsLeft == seconds)
			beforeTimer.run();

		everySecond.accept(this);

		secondsLeft--;
	}
	
    public int getTotalSeconds() {
        return seconds;
    }
    
    public int getSecondsLeft() {
        return secondsLeft;
    }
    
    public void scheduleTimer() {
        this.timer = new Timer();
        timer.scheduleAtFixedRate(this, 1000, 1000);
    }
}
