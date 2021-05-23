package kodlamaio.hrms.core.utilites.results;

public class SuccessResult extends Result {

	public SuccessResult(String message) {
		super(true,message);
	}
	public SuccessResult() {
		super(true);
	}

}
