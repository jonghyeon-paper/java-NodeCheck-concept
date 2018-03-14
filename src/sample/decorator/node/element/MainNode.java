package sample.decorator.node.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sample.decorator.node.Node;
import sample.decorator.node.context.NodeContext;

/**
 * 메인 노드.
 * 태스크의 시작이 되는 노드이다.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class MainNode extends Node {
	
	private List<Node> commandList = new ArrayList<>();
	
	public MainNode(NodeContext context) {
		this.parse(context);
	}
	
	public void parse(NodeContext context) {
		while (true) {
			if (context.currentToken() == null) {
				// context end
				// 메인노드는 종료조건이 없다.
				// null이면 모든 context를 읽어들인 것이다.
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
