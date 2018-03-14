package sample.decorator.node.attribute;

public enum ControlNodeType {
	IF("If"),
	ELSE("Else"),
	END_IF("EndIf"),
	REPEAT("Repeat"),
	END_REPEAT("EndRepeat");
	
	private String commandName;
	
	private ControlNodeType(String commandName) {
		this.commandName = commandName;
	}
	
	public String getCommandName() {
		return commandName;
	}
}
