package sample.decorator.node;

/**
 * task 노드
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.08.
 *
 */
public interface NodeExpression {
	
	/**
	 * 현재 노드의 표현식.
	 * fxml과 느슨한 연결을 하기 위해 return형을 object로 선언.
	 * 
	 * @author jonghyeon
	 * @return
	 */
	Object toExpression();
	
	/**
	 * 현재 노드의 표현식.
	 * 노드의 string 표현식.
	 * 
	 * @author jonghyeon
	 * @return
	 */
	String toStringExpression();
}
