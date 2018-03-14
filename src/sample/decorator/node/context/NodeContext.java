package sample.decorator.node.context;

/**
 * 노드 컨텍스트.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public interface NodeContext {
	
	/**
	 * 현재 토큰을 반환한다.
	 * @return
	 */
	String currentToken();
	
	/**
	 * 다음토큰으로 넘어간다.
	 */
	void nextToken();
	
	/**
	 * 전달받은 토큰이 현재 토큰이면 다음 토큰으로 넘어간다.
	 */
	void skipToken(String token);
	
	/**
	 * 현재 컨텍스트의 인덱스를 반환한다.
	 * @return
	 */
	public Integer getContextIndex();
	
	/**
	 * 현재 컨텍스트의 들여쓰기레벨을 반환한다.
	 * @return
	 */
	public Integer getContextIndentationLevel();
	
	/**
	 * 컨텍스트의 들여쓰기 레벨을 증가시킨다.
	 */
	public void increaseContextIndentationLevel();
	
	/**
	 * 컨텍스트의 들여쓰기 레벨을 감소시킨다.
	 */
	public void reduceContextIndentationLevel();
}
