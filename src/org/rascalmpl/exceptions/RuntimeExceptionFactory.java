/*******************************************************************************
 * Copyright (c) 2009-2013 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:

 *   * Jurgen J. Vinju - Jurgen.Vinju@cwi.nl - CWI
 *   * Jeroen van den Bos - Jeroen.van.den.Bos@cwi.nl (CWI)
 *   * Tijs van der Storm - Tijs.van.der.Storm@cwi.nl
 *   * Paul Klint - Paul.Klint@cwi.nl - CWI
 *   * Mark Hills - Mark.Hills@cwi.nl (CWI)
 *   * Arnold Lankamp - Arnold.Lankamp@cwi.nl
*******************************************************************************/
package org.rascalmpl.exceptions;

import java.io.IOException;
import java.net.URISyntaxException;

import org.rascalmpl.ast.AbstractAST;
import org.rascalmpl.interpreter.asserts.ImplementationError;

import io.usethesource.vallang.IInteger;
import io.usethesource.vallang.IList;
import io.usethesource.vallang.ISourceLocation;
import io.usethesource.vallang.IString;
import io.usethesource.vallang.IValue;
import io.usethesource.vallang.IValueFactory;
import io.usethesource.vallang.type.Type;
import io.usethesource.vallang.type.TypeFactory;
import io.usethesource.vallang.type.TypeStore;
import org.rascalmpl.values.ValueFactoryFactory;

/**
 * This class defines and implements all dynamic (run-time) exceptions that
 * can be thrown by the Rascal interpreter. It creates exceptions that can be
 * caught by Rascal code.
 * <br>
 * Static errors such as parse errors and type errors are something different.
 */
public class RuntimeExceptionFactory {
	private static TypeFactory TF = TypeFactory.getInstance();
	private static IValueFactory VF = ValueFactoryFactory.getValueFactory();
	public static final TypeStore TS = new TypeStore();
	public static final Type Exception = TF.abstractDataType(TS, "RuntimeException");
	
	public static final Type Ambiguity = TF.constructor(TS, Exception, "Ambiguity", TF.sourceLocationType(), "location", TF.stringType(), "nonterminal", TF.stringType(), "sentence");
 
    public static final Type ArithmeticException = TF.constructor(TS, Exception, "ArithmeticException", TF.stringType(), "message");
    /*Not in Exception.rsc*/public static final Type ArityMismatch = TF.constructor(TS, Exception, "ArityMismatch", TF.integerType(), "expectedArity", TF.integerType(), "gotArity");

	public static final Type AssertionFailed = TF.constructor(TS,Exception,"AssertionFailed");
	public static final Type LabeledAssertionFailed = TF.constructor(TS,Exception,"AssertionFailed", TF.stringType(), "label");
    
    public static final Type DateTimeParsingError = TF.constructor(TS, Exception, "DateTimeParsingError", TF.stringType(), "message");
    public static final Type DateTimePrintingError = TF.constructor(TS, Exception, "DateTimePrintingError", TF.stringType(), "message");

	public static final Type EmptyList = TF.constructor(TS,Exception,"EmptyList");
	public static final Type EmptyMap = TF.constructor(TS,Exception,"EmptyMap");
	public static final Type CallFailed = TF.constructor(TS, Exception, "CallFailed", TF.listType(TF.valueType()), "arguments");
	public static final Type EmptySet = TF.constructor(TS,Exception,"EmptySet");
	/*Not in Exception.rsc*/public static final Type Figure = TF.constructor(TS, Exception, "Figure", TF.stringType(), "message", TF.valueType(), "figure");

	public static final Type IllegalArgument = TF.constructor(TS,Exception,"IllegalArgument",TF.valueType(), "v", TF.stringType(), "message");
    /*Not in Exception.rsc*/public static final Type AnonymousIllegalArgument = TF.constructor(TS,Exception,"IllegalArgument");

    //public static final Type IllegalChar = TF.constructor(TS, Exception, "IllegalCharacter", TF.integerType(), "character");
    //public static final Type IllegalIdentifier = TF.constructor(TS, Exception, "IllegalIdentifier", TF.stringType(), "name");
	
    
    /*Not in Exception.rsc*/public static final Type IllegalTypeArgument = TF.constructor(TS,Exception,"IllegalTypeArgument",TF.stringType(), "type", TF.stringType(), "message");
    public static final Type ImplodeError = TF.constructor(TS, Exception, "ImplodeError", TF.stringType(), "message");
    public static final Type IndexOutOfBounds = TF.constructor(TS, Exception, "IndexOutOfBounds", TF.integerType(), "index");
    
    public static final Type InvalidUseOfDate = TF.constructor(TS, Exception, "InvalidUseOfDate", TF.dateTimeType(), "msg");
    public static final Type InvalidUseOfDateTime = TF.constructor(TS, Exception, "InvalidUseOfDateTime", TF.dateTimeType(), "msg");
    public static final Type InvalidUseOfLocation = TF.constructor(TS, Exception, "InvalidUseOfLocation", TF.stringType(), "message");
    public static final Type InvalidUseOfTime = TF.constructor(TS, Exception, "InvalidUseOfTime", TF.dateTimeType(), "msg");
    public static final Type IO = TF.constructor(TS,Exception,"IO",TF.stringType(), "message");
    public static final Type Java = TF.constructor(TS, Exception, "Java", TF.stringType(), "class", TF.stringType(), "message");
    public static final Type JavaWithCause = TF.constructor(TS, Exception, "Java", TF.stringType(), "class", TF.stringType(), "message", Exception, "cause");
    public static final Type MalFormedURI = TF.constructor(TS, Exception, "MalFormedURI", TF.stringType(), "malFormedUri");
	public static final Type ModuleNotFound = TF.constructor(TS, Exception, "ModuleNotFound", TF.stringType(), "name");
	public static final Type MultipleKey = TF.constructor(TS, Exception, "MultipleKey", TF.valueType(), "key", TF.valueType(), "first", TF.valueType(), "second");
    // NoMainFunction
	public static final Type NoSuchAnnotation = TF.constructor(TS, Exception, "NoSuchAnnotation", TF.stringType(), "label");
    public static final Type NoSuchElement = TF.constructor(TS,Exception,"NoSuchElement",TF.valueType(), "v");
	public static final Type NoSuchField = TF.constructor(TS, Exception, "NoSuchField", TF.stringType(), "label");
    public static final Type NoSuchKey = TF.constructor(TS, Exception, "NoSuchKey", TF.valueType(), "key");

    // NotImplemented
	public static final Type ParseError = TF.constructor(TS, Exception, "ParseError", TF.sourceLocationType(), "location");

	public static final Type PathNotFound = TF.constructor(TS,Exception,"PathNotFound",TF.sourceLocationType(), "location");
    
	public static final Type PermissionDenied = TF.constructor(TS,Exception,"PermissionDenied",TF.stringType(), "message");
    public static final Type AnonymousPermissionDenied = TF.constructor(TS,Exception,"PermissionDenied");

	public static final Type RegExpSyntaxError = TF.constructor(TS, Exception, "RegExpSyntaxError", TF.stringType(), "message");
	
	public static final Type SchemeNotSupported = TF.constructor(TS, Exception, "SchemeNotSupported", TF.sourceLocationType(), "location");
	public static final Type NoParent = TF.constructor(TS, Exception, "NoParent", TF.sourceLocationType(), "noParentUri");
	public static final Type NameMismatch = TF.constructor(TS, Exception, "NameMismatch", TF.stringType(), "expectedName", TF.stringType(), "gotName");

	public static final Type Timeout = TF.constructor(TS, Exception, "Timeout");
	
    public static final Type StackOverflow = TF.constructor(TS, Exception, "StackOverflow");
    public static final Type UnavailableInformation = TF.constructor(TS,Exception, "UnavailableInformation");
	
	// The "official" exceptions that a Rascal program can catch (alphabetical order)
	
    // ambiguity
    
	public static Throw ambiguity(ISourceLocation loc, IString type, IString string) {
	    return new Throw(VF.constructor(Ambiguity, loc, type, string), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw ambiguity(ISourceLocation loc, IString type, IString string, AbstractAST ast, StackTrace trace) {
	  return new Throw(VF.constructor(Ambiguity, loc, type, string), ast, trace);
	}
	
	public static Throw callFailed(IList arguments, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(CallFailed, arguments), ast, trace);
	}
	
	// arihmeticException
	
	public static Throw arithmeticException(IString msg) {
        return new Throw(VF.constructor(ArithmeticException, msg), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw arithmeticException(String msg) {
        return new Throw(VF.constructor(ArithmeticException, VF.string(msg)), (AbstractAST)null, (StackTrace)null);
	}
	            
	public static Throw arithmeticException(String msg, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(ArithmeticException, VF.string(msg)), ast, trace);
	}
	
    // arityMisMatch -- not in Exception, specific for interpreter
    
    public static Throw arityMismatch(IInteger expected, IInteger got) {
        return new Throw(VF.constructor(ArityMismatch, expected, got), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw arityMismatch(int expected, int got) {
        return new Throw(VF.constructor(ArityMismatch, VF.integer(expected), VF.integer(got)), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw arityMismatch(IInteger expected, IInteger got, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(ArityMismatch, expected, got), ast, trace);
    }
    
    public static Throw arityMismatch(int expected, int got, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(ArityMismatch, VF.integer(expected), VF.integer(got)), ast, trace);
    }
    
    // assertionFailed
	
	public static Throw assertionFailed() {
        return new Throw(VF.constructor(AssertionFailed), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw assertionFailed(AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(AssertionFailed), ast, trace);
	}
	
	public static Throw assertionFailed(IString msg) {
        return new Throw(VF.constructor(LabeledAssertionFailed, msg), (AbstractAST)null, (StackTrace)null);
    }
	public static Throw assertionFailed(IString msg, AbstractAST ast, StackTrace trace) {
    	return new Throw(VF.constructor(LabeledAssertionFailed, msg), ast, trace);
    }
	
	// callFailed -- not in Exception, specific for interpreter
	
	public static Throw callFailed(ISourceLocation loc, IList arguments) {
        return new Throw(VF.constructor(CallFailed, loc, arguments), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw callFailed(ISourceLocation loc, IList arguments, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(CallFailed, loc, arguments), ast, trace);
    }
    
    // dateTimeParsingError
    
    public static Throw dateTimeParsingError(IString message) {
        return new Throw(VF.constructor(DateTimeParsingError, message), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw dateTimeParsingError(String message) {
        return new Throw(VF.constructor(DateTimeParsingError, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw dateTimeParsingError(IString message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(DateTimeParsingError, message), ast, trace);
    }
    
    public static Throw dateTimeParsingError(String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(DateTimeParsingError, VF.string(message)), ast, trace);
    }
    
    // dateTimePrintingError
    
    public static Throw dateTimePrintingError(IString message) {
        return new Throw(VF.constructor(DateTimePrintingError, message), (AbstractAST)null, (StackTrace)null);
    }

    public static Throw dateTimePrintingError(String message) {
        return new Throw(VF.constructor(DateTimePrintingError, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    } 
    
    public static Throw dateTimePrintingError(IString message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(DateTimePrintingError, message), ast, trace);
    }   

    public static Throw dateTimePrintingError(String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(DateTimePrintingError, VF.string(message)), ast, trace);
    } 
    
    // emptyList
	
	public static Throw emptyList() {
        return new Throw(VF.constructor(EmptyList), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw emptyList(AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(EmptyList), ast, trace);
	}
	
	// emptyMap
	
	public static Throw emptyMap() {
	    return new Throw(VF.constructor(EmptyMap), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw emptyMap(AbstractAST ast, StackTrace trace) {
	  return new Throw(VF.constructor(EmptyMap), ast, trace);
	}
	
	// emptySet
	
	public static Throw emptySet() {
        return new Throw(VF.constructor(EmptySet), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw emptySet(AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(EmptySet), ast, trace);
	}
	
	public static Throw figureException(IString message, IValue v) {
        return new Throw(VF.constructor(Figure, message, v), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw figureException(IString message, IValue v, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(Figure, message, v), ast, trace);
    }
    
    public static Throw figureException(String message, IValue v, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(Figure, VF.string(message), v), ast, trace);
    }
	
	// illegalArgument
	
	public static Throw illegalArgument() {
        return new Throw(VF.constructor(AnonymousIllegalArgument), (AbstractAST)null, (StackTrace)null); 
    }
	
	public static Throw illegalArgument(AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(AnonymousIllegalArgument), ast, trace);	
	}
	
	public static Throw illegalArgument(IValue v) {
        return new Throw(VF.constructor(IllegalArgument), (AbstractAST)null, (StackTrace)null);  
    }
	
	public static Throw illegalArgument(IValue v, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(IllegalArgument), ast, trace);	
	}
	
	public static Throw illegalArgument(IValue v, IString message) {
        return new Throw(VF.constructor(IllegalArgument, v, message), (AbstractAST)null, (StackTrace)null);   
    }
	
	public static Throw illegalArgument(IValue v, String message) {
        return new Throw(VF.constructor(IllegalArgument, v, VF.string(message)), (AbstractAST)null, (StackTrace)null);   
    }
	
	public static Throw illegalArgument(IValue v, IString message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(IllegalArgument, v, message), ast, trace);   
    }
	
	public static Throw illegalArgument(IValue v, String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(IllegalArgument, v, VF.string(message)), ast, trace);   
    }
	
	public static Throw illegalArgument(IValue v, AbstractAST ast, StackTrace trace, String message) {
		return new Throw(VF.constructor(IllegalArgument, v, VF.string(message)), ast, trace);	
	}
	
	// implodeError
	
	public static Throw implodeError(IString msg) {
        return new Throw(VF.constructor(ImplodeError, msg), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw implodeError(String msg) {
        return new Throw(VF.constructor(ImplodeError, VF.string(msg)), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw implodeError(IString msg, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(ImplodeError, msg), ast, trace);
    }
    
    public static Throw implodeError(String msg, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(ImplodeError, VF.string(msg)), ast, trace);
    }
	
	// indexOutOfBounds
	
	public static Throw indexOutOfBounds(IInteger i) {
        return new Throw(VF.constructor(IndexOutOfBounds, i), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw indexOutOfBounds(IInteger i, AbstractAST ast, StackTrace trace) {
    	return new Throw(VF.constructor(IndexOutOfBounds, i), ast, trace);
    }
	
	// invalidUseOfDate
	
	public static Throw invalidUseOfDate(IString message) {
	    return new Throw(VF.constructor(InvalidUseOfDate,message), (AbstractAST)null, (StackTrace)null);
	}

	public static Throw invalidUseOfDateException(String message) {
	    return new Throw(VF.constructor(InvalidUseOfDate, VF.string(message)), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw invalidUseOfDate(String message) {
        return new Throw(VF.constructor(InvalidUseOfDate, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    }

	public static Throw invalidUseOfDate(IString message, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(InvalidUseOfDate,message), ast, trace);
	}

	public static Throw invalidUseOfDateException(String message, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(InvalidUseOfDate, VF.string(message)), ast, trace);
	}
	public static Throw invalidUseOfDate(String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfDate, VF.string(message)), ast, trace);
    }

	// invalidUseOfDateTime
	
	public static Throw invalidUseOfDateTime(IString message) {
	    return new Throw(VF.constructor(InvalidUseOfDateTime, message), (AbstractAST)null, (StackTrace)null);
	}

	public static Throw invalidUseOfDateTimeException(String message) {
	    return new Throw(VF.constructor(InvalidUseOfDateTime, VF.string(message)), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw invalidUseOfDateTime(String message) {
        return new Throw(VF.constructor(InvalidUseOfDateTime, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    }

	public static Throw invalidUseOfDateTime(IString message, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(InvalidUseOfDateTime, message), ast, trace);
	}

	public static Throw invalidUseOfDateTimeException(String message, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(InvalidUseOfDateTime, VF.string(message)), ast, trace);
	}
	
	public static Throw invalidUseOfDateTime(String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfDateTime, VF.string(message)), ast, trace);
    }
	
	// invalidUseOfLocation
	
	public static Throw invalidUseOfLocation(IString msg) {
        return new Throw(VF.constructor(InvalidUseOfLocation, msg), (AbstractAST)null, (StackTrace)null);
    } 
    
    public static Throw invalidUseOfLocation(String msg) {
        return new Throw(VF.constructor(InvalidUseOfLocation, VF.string(msg)), (AbstractAST)null, (StackTrace)null);
    } 
    
    public static Throw invalidUseOfLocation(IString msg, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfLocation, msg), ast, trace);
    }   
    
    public static Throw invalidUseOfLocation(String msg, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfLocation, VF.string(msg)), ast, trace);
    }   
    
    // invalidUseOfTime
    
    public static Throw invalidUseOfTime(IString message) {
        return new Throw(VF.constructor(InvalidUseOfTime, message), (AbstractAST)null, (StackTrace)null);
    }

    public static Throw invalidUseOfTimeException(String message) {
        return new Throw(VF.constructor(InvalidUseOfTime, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    }
    
    public static Throw invalidUseOfTime(String message) {
        return new Throw(VF.constructor(InvalidUseOfTime, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    }

    public static Throw invalidUseOfTime(IString message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfTime, message), ast, trace);
    }

    public static Throw invalidUseOfTimeException(String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfTime, VF.string(message)), ast, trace);
    }
    
    public static Throw invalidUseOfTime(String message, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(InvalidUseOfTime, VF.string(message)), ast, trace);
    }
    
    // io
	
	public static Throw io(IString msg) {
        return new Throw(VF.constructor(IO, msg), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw io(String msg) {
        return new Throw(VF.constructor(IO, VF.string(msg)), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw io(IString msg, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(IO, msg), ast, trace);
	}
	
	// Java
	
	private static Throw javaException(String clazz, String message, IValue cause, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(Java, VF.string(clazz), VF.string(message), cause), ast, trace);
	}

	private static Throw javaException(String clazz, String message, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(Java, VF.string(clazz), VF.string(message)), ast, trace);
	}
	
	public static Throw javaException(Throwable targetException, AbstractAST ast, StackTrace rascalTrace) throws ImplementationError {
		try {
			String clazz = targetException.getClass().getSimpleName();
			String msg = targetException.getMessage();
			StackTrace trace = buildTrace(targetException, rascalTrace);
			Throwable cause = targetException.getCause();

			if (cause != null && cause != targetException) {
				Throw throwCause = cause instanceof Throw ? (Throw) cause : javaException(cause, ast, rascalTrace);
				return javaException(clazz, msg != null ? msg : "", throwCause.getException(), ast, trace);
			}
			else {
				return javaException(clazz, msg != null ? msg : "", ast, trace);
			}
		} catch (IOException e1) {
			throw new ImplementationError("Could not create stack trace", e1);
		}
	}
	
	 /*
     * Robust version of sourceLocation, to be called only from error situations to avoid nested
     * error traces.
     */
	private static ISourceLocation robustSourceLocation(String path, int offset, int length, int beginLine, int endLine, int beginCol, int endCol) {
	  if (path == null) {
	    path = "UNKNOWN_FILENAME";
	  }
	  if (!path.startsWith("/")) {
	    path = "/" + path;
	  }
	  ISourceLocation locRoot;
	  try {
	    locRoot = VF.sourceLocation("unknown", "", path);
	  } catch (URISyntaxException e) {
	    locRoot = VF.sourceLocation(path); // fall back, shouldn't happen.
	  }

	  if (offset < 0) 
	    offset = 0;
	  if (length < 0) 
	    length = 0;
	  if (beginLine < 0) 
	    beginLine = 0;
	  if (beginCol < 0) 
	    beginCol = 0;
	  if (endCol < 0) 
	    endCol = 0;
	  if (endLine < beginLine) 
	    endLine = beginLine;
	  if (endLine == beginLine && endCol < beginCol) 
	    endCol = beginCol;
	  return VF.sourceLocation(locRoot, offset, length, beginLine, endLine, beginCol, endCol);
	}

	private static StackTrace buildTrace(Throwable targetException, StackTrace rascalTrace) throws IOException {
		StackTraceElement[] stackTrace = targetException.getStackTrace();
		StackTrace newTrace = new StackTrace();
		for (StackTraceElement elem : stackTrace) {
			if (elem.getMethodName().equals("invoke")) {
				break;
			}
			newTrace.add(robustSourceLocation(elem.getFileName(), 0, 0, elem.getLineNumber(), elem.getLineNumber(), 0, 0), elem.getClassName() + "." + elem.getMethodName());
		}
		newTrace.addAll(rascalTrace);
		return newTrace.freeze();
	}
	
	// malformedURI

	public static Throw malformedURI(IString uri) {
	    return new Throw(VF.constructor(MalFormedURI, uri), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw malformedURI(String uri) {
	    return new Throw(VF.constructor(MalFormedURI, VF.string(uri)), (AbstractAST)null, (StackTrace)null);
    }

	public static Throw malformedURI(IString uri, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(MalFormedURI, uri), ast, trace);
	}

	public static Throw malformedURI(String uri, AbstractAST ast, StackTrace trace) {
	    return new Throw(VF.constructor(MalFormedURI, VF.string(uri)), ast, trace);
	}

	// moduleNotFound
	
	public static Throw moduleNotFound(IString module) {
        return new Throw(VF.constructor(ModuleNotFound, module), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw moduleNotFound(IString module, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(ModuleNotFound, module), ast, trace);
	}
	
	// multipleKey

    public static Throw MultipleKey(IValue v, IValue first, IValue second) {
        return new Throw(VF.constructor(MultipleKey, v, first, second), (AbstractAST)null, (StackTrace)null);
	}
	
    public static Throw MultipleKey(IValue v, IValue first, IValue second, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(MultipleKey, v, first, second), ast, trace);
	}
	
    // noParent
	
    public static Throw noParent(ISourceLocation loc) {
        return new Throw(VF.constructor(NoParent, loc), (AbstractAST)null, (StackTrace)null);
    }
	
    public static Throw noParent(ISourceLocation loc, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(NoParent, loc), ast, trace);
	}
	
	// noSuchAnnotation
	
	public static Throw noSuchAnnotation(IString label) {
        return new Throw(VF.constructor(NoSuchAnnotation, label), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw noSuchAnnotation(String label) {
        return new Throw(VF.constructor(NoSuchAnnotation, VF.string(label)), (AbstractAST)null, (StackTrace)null);
    }   

	public static Throw noSuchAnnotation(IString label, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(NoSuchAnnotation, label), ast, trace);
	}	
	
	public static Throw noSuchAnnotation(String label, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(NoSuchAnnotation, VF.string(label)), ast, trace);
    }
	
	// noSuchElement
	
	public static Throw noSuchElement(IValue v) {
        return new Throw(VF.constructor(NoSuchElement,v), (AbstractAST)null, (StackTrace)null);  
	}
	
    public static Throw noSuchElement(IValue v, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(NoSuchElement,v), ast, trace);  
	}
	
	// noSuchField
	
	public static Throw noSuchField(IString name) {
        return new Throw(VF.constructor(NoSuchField, name), (AbstractAST)null, (StackTrace)null);
    }
	
    public static Throw noSuchField(String name) {
        return new Throw(VF.constructor(NoSuchField,VF.string(name)), (AbstractAST)null, (StackTrace)null);
	}
	
    public static Throw noSuchField(IString name, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(NoSuchField, name), ast, trace);
    }
	
    public static Throw noSuchField(String name, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(NoSuchField, VF.string(name)), ast, trace);
	}
	
	// noSuchKey
	
	public static Throw noSuchKey(IValue v) {
        return new Throw(VF.constructor(NoSuchKey, v), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw noSuchKey(IValue v, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(NoSuchKey, v), ast, trace);
	}

	// parseError
	
	public static Throw parseError(ISourceLocation loc) {
        return new Throw(VF.constructor(ParseError, loc), (AbstractAST)null, (StackTrace)null);
    }   
	
	public static Throw parseError(ISourceLocation loc, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(ParseError, loc), ast, trace);
	}	
	
	// pathNotFound
	
	public static Throw pathNotFound(ISourceLocation loc) {
        return new Throw(VF.constructor(PathNotFound, loc), (AbstractAST)null, (StackTrace)null);
    }
	
	public static Throw pathNotFound(ISourceLocation loc, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(PathNotFound, loc), ast, trace);
	}
	
	// permissionDenied
    
    public static Throw permissionDenied() {
        return new Throw(VF.constructor(AnonymousPermissionDenied), (AbstractAST)null, (StackTrace)null);
    }
	
    public static Throw permissionDenied(AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(AnonymousPermissionDenied), ast, trace);
	}
	
    public static Throw permissionDenied(IString msg) {
        return new Throw(VF.constructor(PermissionDenied, msg), (AbstractAST)null, (StackTrace)null);
    }
	
    public static Throw permissionDenied(IString msg, AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(PermissionDenied, msg), ast, trace);
	}
	
	// regExpSyntaxError
	
	public static Throw regExpSyntaxError(String message) {
	    return new Throw(VF.constructor(RegExpSyntaxError, VF.string(message)), (AbstractAST)null, (StackTrace)null);
    }
	
	// schemeNotSupported
	
	public static Throw schemeNotSupported(ISourceLocation file) {
        return new Throw(VF.constructor(SchemeNotSupported, file), (AbstractAST)null, (StackTrace)null);
	}
	
	// stackOverflow
	
	public static Throw stackOverflow() {
        return new Throw(VF.constructor(StackOverflow), (AbstractAST)null, (StackTrace)null);
	}
	
	public static Throw stackOverflow(AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(StackOverflow), ast, trace);
    }
	
	// timeout
	
	public static Throw timeout(AbstractAST ast, StackTrace trace) {
        return new Throw(VF.constructor(Timeout), ast, trace);
	}
	
	// unavailableInformation
	
	public static Throw unavailableInformation(AbstractAST ast, StackTrace trace){
        return new Throw(VF.constructor(UnavailableInformation), ast, trace);   
	}
	
	// The status of the following exceptions is to be determined (alphabetical order)
	
	// illegalTypeArgument -- not in Exception, specific for interpreter?
	
	public static Throw illegalTypeArgument(IString type, IString message){
        return new Throw(VF.constructor(IllegalTypeArgument,type,message), (AbstractAST)null, (StackTrace)null);   
	}

	public static Throw illegalTypeArgument(IString type, AbstractAST ast, StackTrace trace, IString message){
        return new Throw(VF.constructor(IllegalTypeArgument,type,message), ast, trace);   
    }
	
	public static Throw illegalTypeArgument(String type, AbstractAST ast, StackTrace trace, String message){
		return new Throw(VF.constructor(IllegalTypeArgument,VF.string(type),VF.string(message)), ast, trace);	
	}
	
	public static Throw illegalTypeArgument(IString type){
        return new Throw(VF.constructor(IllegalTypeArgument,type, VF.string("")), (AbstractAST)null, (StackTrace)null);   
	}
	
	public static Throw illegalTypeArgument(IString type, AbstractAST ast, StackTrace trace){
        return new Throw(VF.constructor(IllegalTypeArgument,type, VF.string("")), ast, trace);   
	}

	public static Throw illegalTypeArgument(String type, AbstractAST ast, StackTrace trace){
		return new Throw(VF.constructor(IllegalTypeArgument,VF.string(type), VF.string("")), ast, trace);	
	}

	// nameMismatch -- not in Exception, specific for interpreter
	
	public static Throw nameMismatch(String expected, String got, AbstractAST ast, StackTrace trace) {
		return new Throw(VF.constructor(NameMismatch, VF.string(expected), VF.string(got)), ast, trace);
	}
	
	
	
	
	
	
	
	
	
	
}