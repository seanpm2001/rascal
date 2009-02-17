package org.meta_environment.rascal.interpreter.errors;

import org.meta_environment.rascal.ast.AbstractAST;

public class ClosureInvocationError extends Error {
	private static final long serialVersionUID = 570911223306604481L;
	 
	
	public ClosureInvocationError(String message, AbstractAST node) {
		super("ClosureInvocationError", message, node);
	}

}
