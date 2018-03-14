package sample.decorator.node;

/**
 * task 노드
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.08.
 *
 */
public abstract class Node implements NodeExpression {
	
	private String nodeName;
	
	private Integer commandIndex;
	
	private Integer indentationLevel = 0;
	
	private StringBuilder prefix;
	private StringBuilder suffix;
	
	protected static final String NEWLINE = System.getProperty("line.separator");
	protected static final String INDENTATION = "    ";
	
	/**
	 * 현재 노드의 표현식.
	 * 여기서는 TreeItem<DRCommand>[] 을 리턴한다.
	 * 일반 커맨드는 하나의 노드값만 리턴하지만, 제어 커맨드의 경우 시작와 끝 두 개의 노드를 리턴하기 때문이다.
	 */
	@Override
	public abstract Object toExpression();
	
	/**
	 * 기본형 노드 표현식.
	 * 노드마다 고유한 표현식을 사용하는 경우라면 override해서 사용한다.
	 */
	@Override
	public String toStringExpression() {
		StringBuilder sb = new StringBuilder();
		if (prefix != null) {
			sb.append(getIndentationString()).append(prefix.toString()).append(NEWLINE);
		}
		sb.append(getIndentationString()).append("(" + commandIndex + ")").append(nodeName).append(NEWLINE);
		if (suffix != null) {
			sb.append(getIndentationString()).append(suffix.toString()).append(NEWLINE);
		}
		return sb.toString();
	}
	
	protected String getNodeName() {
		return nodeName;
	}
	
	protected void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public Integer getCommandIndex() {
		return commandIndex;
	}
	
	public void setCommandIndex(Integer commandIndex) {
		this.commandIndex = commandIndex;
	}
	
	public Integer getIndentationLevel() {
		return indentationLevel;
	}
	
	protected void setIndentationLevel(Integer indentationLevel) {
		this.indentationLevel = indentationLevel;
	}
	
	protected String getIndentationString() {
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < indentationLevel; index++) {
			sb.append(INDENTATION);
		}
		return sb.toString();
	}
	
	protected void setPrefix(String s) {
		if (prefix == null) {
			prefix = new StringBuilder();
		}
		prefix.append(s);
	}
	
	protected void setSuffix(String s) {
		if (suffix == null) {
			suffix = new StringBuilder();
		}
		suffix.append(s);
	}

}
