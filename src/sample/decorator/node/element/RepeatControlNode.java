package sample.decorator.node.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sample.decorator.node.Node;
import sample.decorator.node.attribute.ControlNodeType;
import sample.decorator.node.context.NodeContext;
import sample.decorator.node.context.NodeContextException;

/**
 * 반복 커맨드 노드.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class RepeatControlNode extends Node {
	
	private List<Node> commandList = new ArrayList<>();
	
	public RepeatControlNode(NodeContext context) {
		this.parse(context);
	}
	
	private void parse(NodeContext context) {
		/*
		 * 자신의 정보를 자신이 처리하지 않고 엔트리 노드로 대신한다.
		super.setNodeName(context.currentToken());
		super.setIndentationLevel(context.getContextIndentationLevel());
		context.skipToken(super.getNodeName());
		*/
		commandList.add(new EntryCommandNode(context));
		context.increaseContextIndentationLevel();
		
		while (true) {
			if (context.currentToken() == null) {
				throw new NodeContextException("Missing command 'EndRepeat'");
			} else if (ControlNodeType.END_REPEAT.getCommandName().equals(context.currentToken())) {
				// Repeat command exit
				/*
				 * 종료 노드를 스킵하지 않고 엔트리 노드로 대신한다.
				context.skipToken(context.currentToken());
				*/
				context.reduceContextIndentationLevel();
				commandList.add(new EntryCommandNode(context));
				break;
			} else {
				commandList.add(new CommandNode(context));
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object toExpression() {
		List<Object> resultCommandList = new ArrayList<>();
		if (!commandList.isEmpty()) {
			for (Node item : commandList) {
				resultCommandList.addAll((Collection<? extends Object>) item.toExpression());
			}
		}
		return resultCommandList;
	}
	
	@Override
	public String toStringExpression() {
		StringBuilder sb = new StringBuilder();
		for (Node item : commandList) {
			sb.append(item.toStringExpression());
		}
		return sb.toString();
	}

}
