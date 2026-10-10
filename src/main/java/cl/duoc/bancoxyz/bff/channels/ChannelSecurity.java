package cl.duoc.bancoxyz.bff.channels;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration(proxyBeanMethods=false)
public class ChannelSecurity {
 @Bean SecurityFilterChain security(HttpSecurity http) throws Exception {
  return http.csrf(AbstractHttpConfigurer::disable).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .authorizeHttpRequests(a->a.requestMatchers("/actuator/health").permitAll()
    .requestMatchers(HttpMethod.GET,"/api/atm/clientes/*").hasAuthority("SCOPE_atm.customers.read")
    .requestMatchers(HttpMethod.GET,"/api/atm/cuentas-modernas","/api/atm/cuentas-modernas/**").hasAuthority("SCOPE_atm.accounts.read")
    
    .requestMatchers(HttpMethod.POST,"/api/atm/pagos").hasAuthority("SCOPE_atm.payments.write")
    .requestMatchers(HttpMethod.GET,"/api/atm/pagos/*").hasAuthority("SCOPE_atm.payments.read")
    .requestMatchers(HttpMethod.GET,"/api/atm/cuentas/**").hasAuthority("SCOPE_atm.read")
    .requestMatchers(HttpMethod.GET,"/actuator/info").hasAuthority("SCOPE_atm.info")
    .anyRequest().denyAll()).oauth2ResourceServer(o->o.jwt(Customizer.withDefaults())).build();
 }
}
