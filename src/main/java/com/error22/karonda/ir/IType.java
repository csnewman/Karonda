package com.error22.karonda.ir;

public interface IType {

	int[] getDefaultValue();

	int getSize();

	void validate(int[] value);

}
