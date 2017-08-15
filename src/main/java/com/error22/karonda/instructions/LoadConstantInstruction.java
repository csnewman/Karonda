package com.error22.karonda.instructions;

import com.error22.karonda.NotImplementedException;
import com.error22.karonda.ir.PrimitiveObject;
import com.error22.karonda.ir.PrimitiveType;
import com.error22.karonda.vm.StackFrame;

public class LoadConstantInstruction implements IInstruction {
	private PrimitiveType type;
	private Object value;

	public LoadConstantInstruction(PrimitiveType type, Object value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		switch (type) {
		case Void:
			stackFrame.push(new PrimitiveObject(type, null));
			break;
		case Byte:
		case Boolean:
		case Char:
		case Short:
		case Int:
			stackFrame.push(new PrimitiveObject(PrimitiveType.Int, ((Number) value).intValue()));
			break;
		case Long:
			stackFrame.push(new PrimitiveObject(PrimitiveType.Long, ((Number) value).longValue()));
			break;
		case Float:
			stackFrame.push(new PrimitiveObject(PrimitiveType.Float, ((Number) value).floatValue()));
			break;
		case Double:
			stackFrame.push(new PrimitiveObject(PrimitiveType.Double, ((Number) value).doubleValue()));
			break;
		default:
			throw new NotImplementedException();
		}
	}
}
