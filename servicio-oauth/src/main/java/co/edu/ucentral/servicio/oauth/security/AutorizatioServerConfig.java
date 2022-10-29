package co.edu.ucentral.servicio.oauth.security;

import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class AutorizatioServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager atenticationManager;

	@Autowired
	private InfoAdicionalToken infoAdicionalToken;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAthenticated()");
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory().withClient("AngularApp").secret(passwordEncoder.encode("1234567890")).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(3600)
				.refreshTokenValiditySeconds(3600);
		super.configure(clients);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnchancerChain = new TokenEnhancerChain();
		tokenEnchancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
		endpoints.authenticationManager(atenticationManager).tokenStore(TokenStore())
				.accessTokenConverter(accessTokenConverter())
				.tokenEnhancer(tokenEnchancerChain)
				;
		super.configure(endpoints);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(Base64.getEncoder().encodeToString("codigo_secreto_12345_PR".getBytes()));

		return tokenConverter;
	}

	@Bean
	public TokenStore TokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

}
