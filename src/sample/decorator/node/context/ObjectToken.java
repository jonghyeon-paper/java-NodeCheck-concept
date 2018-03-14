package sample.decorator.node.context;

/**
 * 노드 컨텍스트 오브젝트에서 사용할 오브젝트의 토큰
 * 
 * @author jonghyeon
 * @since 2017.11.27.
 */
public interface ObjectToken {
	
	/**
	 * 토큰의 이름
	 * @return
	 */
	String getTokenName();
	
	/**
	 * 현재 오브젝트 토큰
	 * @return
	 */
	ObjectToken getThisObjectToken();
}
