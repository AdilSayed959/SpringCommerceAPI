package com.ct.ConnectionTester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.project.Project;

@Component
public class CommerceToolsConnectionTester {
 
	@Autowired
	private ProjectApiRoot projectApiRoot;
 
	public void testConnection() {

		try {
			Project project = projectApiRoot.get().executeBlocking().getBody();
 
			System.out.println("Connection to Commercetools platfrom successfull - " + project.getKey());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
