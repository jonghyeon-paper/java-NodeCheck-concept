package sample.decorator.node.element;

import java.util.ArrayList;
import java.util.List;

import sample.decorator.node.Node;
import sample.decorator.node.NodeException;
import sample.decorator.node.context.NodeContext;

/**
 * 엔트리 커맨드 노드.
 * 데이터를 가지고 있는 최하위 커맨드 노드이다.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class EntryCommandNode extends Node {
	
	private String commandName = null;
	
	public EntryCommandNode(NodeContext context) {
		this.parse(context);
	}
	
	private void parse(NodeContext context) {
		super.setNodeName(context.currentToken());
		super.setCommandIndex(context.getContextIndex());
		super.setIndentationLevel(context.getContextIndentationLevel());
		commandName = context.currentToken();
		context.skipToken(super.getNodeName());
	}
	
	@Override
	public Object toExpression() {
		// CommandObject generate
		Object command = null;
		// TODO Command instance assign to command variable
		//command = new ???
		if (command == null) {
			throw new NodeException("Warning: '" + super.getNodeName() + "' type is not found.");
		}
		
		// TODO ReturnData generate
		List<Object> resultCommandList = new ArrayList<>();
		resultCommandList.add(command);
		return resultCommandList;
	}

}
