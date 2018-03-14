package sample.decorator;

import sample.decorator.node.context.NodeContext;
import sample.decorator.node.context.StringNodeContext;
import sample.decorator.node.element.MainNode;

public class Sample1 {

	/**
	 * 테스트 - 문자열 테스트
	 * @param argus
	 * @throws JsonProcessingException 
	 */
	public static void main(String[] argus) {
		NodeContext sampleContext = new StringNodeContext("GlobalVariable Sub MoveJ If MoveSpiral Else MoveB EndIf MoveL EndSub Thread MoveC Repeat MoveL MoveJ EndRepeat EndThread");
		MainNode sampleMainNode = new MainNode(sampleContext);
		System.out.println(sampleMainNode.toStringExpression());
	}

}
