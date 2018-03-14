package sample.decorator.node.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sample.decorator.node.Node;
import sample.decorator.node.attribute.ProgramNodeType;
import sample.decorator.node.context.NodeContext;
import sample.decorator.node.context.NodeContextException;

/**
 * 쓰레드 프로그램 노드
 * 최상위에서 사용되는 프로그램 노드다.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class ThreadProgramdNode extends Node {

	private List<Node> commandList = new ArrayList<>();
	
	public ThreadProgramdNode(NodeContext context) {
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
				throw new NodeContextException("Missing keyword 'EndThread'");
			} else if (ProgramNodeType.END_THREAD.getProgramName().equals(context.currentToken())) {
				// Thread program exit
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
