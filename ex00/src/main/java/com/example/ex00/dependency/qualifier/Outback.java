package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("outback")
public class Outback implements Restaurant {

	@Override
	public boolean sidebar() {
		return true;
	}

}
