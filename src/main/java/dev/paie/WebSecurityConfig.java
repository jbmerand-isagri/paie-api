package dev.paie;

import dev.paie.controleurs.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // désactive protection CSRF (non utilisé dans cadre web API)
        http.authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET, "/bulletins_salaire/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/bulletins_salaire/**").hasRole("USER")
                .anyRequest().hasRole("ADMIN")
                // accès à la console h2 sans authentification
                .and().headers().frameOptions().disable()
                .and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                // Gestion de la déconnexion
                // /POST /logout
                .logout()
                // en cas de succès un OK est envoyé (à la place d'une redirection vers /login)
                .logoutSuccessHandler((req, resp, auth) -> resp.setStatus(HttpStatus.OK.value()))
                // suppression du cookie d'authentification
                .deleteCookies(TOKEN_COOKIE);
    }
}
