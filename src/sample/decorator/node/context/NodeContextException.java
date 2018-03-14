package sample.decorator.node.context;

/**
 * 노드 컨텍스트 예외
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class NodeContextException extends RuntimeException {
	
	private static final long serialVersionUID = 5458536974918461538L;

	public NodeContextException(String message) {
		super(message);
	}
	
	public NodeContextException(String message, Exception e) {
		super(message, e);
	}
}
