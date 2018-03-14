package sample.decorator.node.element;

import sample.decorator.node.Node;
import sample.decorator.node.attribute.ControlNodeType;
import sample.decorator.node.attribute.ProgramNodeType;
import sample.decorator.node.context.NodeContext;

/**
 * 커맨드 노드.
 * 커맨드 종류를 확인하고 분류한다.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class CommandNode extends Node {
	
	private Node commandNode;
	
	public CommandNode(NodeContext context) {
		this.parse(context);
	}
	
	private void parse(NodeContext context) {
		if (ControlNodeType.IF.getCommandName().equals(context.currentToken())) {
			commandNode = new IfControlNode(context);
		} else if (ControlNodeType.REPEAT.getCommandName().equals(context.currentToken())) {
			commandNode = new RepeatControlNode(context);
		} else if (ProgramNodeType.SUB.getProgramName().equals(context.currentToken())) {
			commandNode = new SubProgramNode(context);
		} else if (ProgramNodeType.THREAD.getProgramName().equals(context.currentToken())) {
			commandNode = new ThreadProgramdNode(context);
		} else {
			commandNode = new EntryCommandNode(context);
		}
	}
	
	@Override
	public Object toExpression() {
		return commandNode.toExpression();
	}
	
	@Override
	public String toStringExpression() {
		return commandNode.toStringExpression();
	}

}
