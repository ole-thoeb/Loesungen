class CallEg {
	public void methodA() throws ArithmeticException {
		try {
			methodB();
			} 
		catch (ArithmeticException oops) {
			oops.printStackTrace();
		}
	}
	
	public void methodB() throws ArithmeticException {
		try {
			methodC();
			} 
		catch (ArithmeticException oops) {
			oops.printStackTrace();
		}
	}
	
	public void methodC() throws ArithmeticException { 

		try {
			int a = 4/0;
			} 
		catch (ArithmeticException oops) {
			oops.printStackTrace();
		}
	}
}