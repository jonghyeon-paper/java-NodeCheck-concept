package sample.decorator.node.context;

import java.util.StringTokenizer;

/**
 * 노드 컨텍스트.
 * 노드에서 사용되는 컨텍스트를 저장 관리한다.
 * 
 * @author jonghyeon
 * @version 1.0
 * @since 2017.11.10.
 *
 */
public class StringNodeContext implements NodeContext {
	
	private StringTokenizer tokenizer;
	private String currentToken;
	
	private Integer contextIndex; 
	private Integer contextIndentationLevel;
	
	public StringNodeContext(String text) {
		tokenizer = new StringTokenizer(text);
		nextToken();
		contextIndentationLevel = 0;
	}
	
	@Override
	public String currentToken() {
		return currentToken;
	}
	
	@Override
	public void nextToken() {
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
			if (contextIndex == null) {
				contextIndex = 0;
				
			} else {
				contextIndex++;
			}
			
		} else {
			currentToken = null;
		}
	}
	
	@Override
	public void skipToken(String token) {
		if (!token.equals(currentToken)) {
			throw new NodeContextException("Warning: " + token + " is expected, but " + currentToken + " is found.");
		}
		nextToken();
	}
	
	@Override
	public Integer getContextIndex() {
		return contextIndex;
	}
	
	@Override
	public Integer getContextIndentationLevel() {
		return contextIndentationLevel;
	}
	
	@Override
	public void increaseContextIndentationLevel() {
		contextIndentationLevel += 1;
	}
	
	@Override
	public void reduceContextIndentationLevel() {
		if (contextIndentationLevel > 0) {
			contextIndentationLevel -= 1;
		} else {
			throw new NodeContextException("Warning: Current contextIndentationLevel is 0. Cannot reduce contextIndentationLevel.");
		}
	}
}
