package sample.decorator.node.attribute;

public enum ProgramNodeType {
	SUB("Sub"),
	END_SUB("EndSub"),
	THREAD("Thread"),
	END_THREAD("EndThread");
	
	private String programName;
	
	private ProgramNodeType(String programName) {
		this.programName = programName;
	}
	
	public String getProgramName() {
		return programName;
	}
}
