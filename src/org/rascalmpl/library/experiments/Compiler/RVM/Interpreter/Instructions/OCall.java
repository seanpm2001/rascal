package org.rascalmpl.library.experiments.Compiler.RVM.Interpreter.Instructions;

import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.rascalmpl.library.experiments.Compiler.RVM.Interpreter.CodeBlock;
import org.rascalmpl.library.experiments.Compiler.RVM.ToJVM.BytecodeGenerator;

public class OCall extends Instruction {

	final String fuid;
	final int arity;
	ISourceLocation src;

	public OCall(CodeBlock ins, String fuid, int arity, ISourceLocation src) {
		super(ins, Opcode.OCALL);
		this.fuid = fuid;
		this.arity = arity;
		this.src = src;
	}

	public String toString() {
		return "OCALL " + fuid + ", " + arity + " [ " + codeblock.getOverloadedFunctionIndex(fuid) + " ]" + ", " + src;
	}

	public void generate() {
		codeblock.addCode2(opcode.getOpcode(), codeblock.getOverloadedFunctionIndex(fuid), arity);
		codeblock.addCode(codeblock.getConstantIndex(src));
	}

	public void generateByteCode(BytecodeGenerator codeEmittor, boolean debug) {
		if ( debug ) 
			codeEmittor.emitDebugCall(opcode.name());
		// TODO add source line.
		codeEmittor.emitOptimizedOcall(fuid,codeblock.getOverloadedFunctionIndex(fuid), arity, debug) ;
	}
}
