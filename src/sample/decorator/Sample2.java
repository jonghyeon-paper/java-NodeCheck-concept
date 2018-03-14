package sample.decorator;

import java.util.ArrayList;
import java.util.List;

import sample.decorator.node.context.ObjectNodeContext;
import sample.decorator.node.element.MainNode;

public class Sample2 {

	/**
	 * 테스트 - 리스트 테스트
	 * @param argus
	 */
	public static void main(String[] argus) {
		List<Sample2Token> testList = new ArrayList<>();
		testList.add(new Sample2Token("GlobalVariable"));
		testList.add(new Sample2Token("Sub"));
		testList.add(new Sample2Token("MoveJ"));
		testList.add(new Sample2Token("If"));
		testList.add(new Sample2Token("MoveSpiral"));
		testList.add(new Sample2Token("Else"));
		testList.add(new Sample2Token("MoveB"));
		testList.add(new Sample2Token("EndIf"));
		testList.add(new Sample2Token("MoveL"));
		testList.add(new Sample2Token("EndSub"));
		testList.add(new Sample2Token("Thread"));
		testList.add(new Sample2Token("MoveC"));
		testList.add(new Sample2Token("Repeat"));
		testList.add(new Sample2Token("MoveL"));
		testList.add(new Sample2Token("MoveJ"));
		testList.add(new Sample2Token("EndRepeat"));
		testList.add(new Sample2Token("EndThread"));
		
		ObjectNodeContext testContext = new ObjectNodeContext(testList);
		MainNode sampleMainNode = new MainNode(testContext);
		System.out.println(sampleMainNode.toStringExpression());
	}
}

