package sample.decorator;

import sample.decorator.node.context.ObjectToken;

public class Sample2Token implements ObjectToken {
	
	private String commandName;
	
	public Sample2Token(String commandName) {
		this.commandName = commandName;
	}
	
	@Override
	public String getTokenName() {
		return commandName;
	}
	
	@Override
	public ObjectToken getThisObjectToken() {
		return this;
	}

}
