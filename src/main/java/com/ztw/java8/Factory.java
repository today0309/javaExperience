package com.ztw.java8;

import java.util.function.Supplier;

public interface Factory {

	static <T> T create(Supplier<T> supplier) {
		return supplier.get();
	}

}
