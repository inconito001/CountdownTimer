# CountdownTimer
CountdownTimer is a class that you can use anywhere in Java

How it works ?
  
  CountdownTimer timer = new CountdownTimer(delay, before, after, everyseconds);
  
  public static void main(String... args) {
		CountdownTimer timer = new CountdownTimer(10, new Runnable() {
			@Override
			public void run() {
				System.out.println("Before");
			}

		}, new Runnable() {
			@Override
			public void run() {
				System.out.println("After");
			}
		}, (t) -> System.out.println("Time every seconds = " + t.getSecondsLeft()));
		
		timer.scheduleTimer();
	}
  
  
