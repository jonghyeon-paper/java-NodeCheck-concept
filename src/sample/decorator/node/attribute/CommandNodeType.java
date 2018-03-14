package sample.decorator.node.attribute;

/**
 * 엔트리 명령어
 * TODO 현재는 사용하지는 않지만 만약 명령어별로 정의가 필요하다면 여기에 정의하고 사용하기를 바란다.
 * 
 * @author jonghyeon
 * @since 2017.11.27.
 */
public enum CommandNodeType {
	MOVE_LINEAR("movel", "MoveLinear"),
	MOVE_JOINT("movej", "MoveJoint");
	
	private String commandName;
	
	private String displayName;
	
	private CommandNodeType(String commandName, String displayName) {
		this.commandName = commandName;
		this.displayName = displayName;
	}
	
	public String getCommandName() {
		return commandName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
