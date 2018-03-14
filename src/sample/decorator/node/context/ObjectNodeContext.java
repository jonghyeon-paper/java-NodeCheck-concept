package sample.decorator.node.context;

import java.util.Collection;
import java.util.Iterator;

public class ObjectNodeContext implements NodeContext {
	
	private Iterator<? extends ObjectToken> objectContext;
	private String currentToken;
	
	private Integer contextIndex; 
	private Integer contextIndentationLevel;
	
	public ObjectNodeContext(Collection<? extends ObjectToken> objectContext) {
		this.objectContext = objectContext.iterator();
		nextToken();
		contextIndentationLevel = 0;
	}
	
	@Override
	public String currentToken() {
		return currentToken;
	}
	
	@Override
	public void nextToken() {
		if (objectContext.hasNext()) {
			currentToken = objectContext.next().getTokenName();
			
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