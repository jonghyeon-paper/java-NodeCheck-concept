package sample.decorator.node;

/**
 * 노드 예외
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.15.
 *
 */
public class NodeException extends RuntimeException {

	private static final long serialVersionUID = -2314467861631705982L;
	
	public NodeException(String message) {
		super(message);
	}
	
	public NodeException(String message, Exception e) {
		super(message, e);
	}

}
