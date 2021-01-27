# CountdownTimer
CountdownTimer is a class that you can use anywhere in Java

How it works ?
  
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
  
Or

	public static void main(String... args) {
		CountdownTimer timer = new CountdownTimer(10, () -> before(), () -> after(), (t) -> System.out.println("Time every seconds = " + t.getSecondsLeft()));
		
		timer.scheduleTimer();
	}
	
	public static void before() {
		System.out.println("Before");
	}
	
	public static void after() {
		System.out.println("After");
	}

If you have any suggestion contact me on discord: inconito001#4582
You want to reward me ? paypal.me/inconito001
