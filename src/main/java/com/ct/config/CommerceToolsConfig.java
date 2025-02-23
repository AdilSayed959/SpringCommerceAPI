package com.ct.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;

import io.vrap.rmf.base.client.oauth2.ClientCredentials;

@Configuration
public class CommerceToolsConfig {

	@Value("${ctp.projectKey}")
	private String projectKey;

	@Value("${ctp.clientId}")
	private String clientId;

	@Value("${ctp.clientSecret}")
	private String clientSecret;

	@Value("${ctp.authUrl}")
	private String authUrl;

	@Value("${ctp.apiUrl}")
	private String apiUrl;

	@Bean
	public ProjectApiRoot createApiClient() {

		ClientCredentials clientCredentials = ClientCredentials.of()
												.withClientId(clientId)
												.withClientSecret(clientSecret)
												.build();

		return ApiRootBuilder.of()
				.defaultClient(clientCredentials, authUrl, apiUrl)
				.build(projectKey);
	}
}
