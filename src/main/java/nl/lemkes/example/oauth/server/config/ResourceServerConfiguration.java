package nl.lemkes.example.oauth.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author hans
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{
	private static final String RESOURCE_ID = "restservice";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources)
	{
		// @formatter:off
		resources.resourceId(RESOURCE_ID);
		// @formatter:on
	}

	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		// @formatter:off
		http.authorizeRequests().anyRequest().permitAll();
		// http.csrf().disable();
		// http.httpBasic().disable();``
		// @formatter:on
	}
}
