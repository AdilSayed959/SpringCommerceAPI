package com.ct.ConnectionTester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartup {

	@Autowired
	private CommerceToolsConnectionTester connectionTester;

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationStartup() {
		connectionTester.testConnection();
	}

}
