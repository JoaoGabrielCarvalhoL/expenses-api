package br.com.carv.expenses.security;

import br.com.carv.expenses.model.User;
import br.com.carv.expenses.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationProviderImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        if(user.isPresent()) {
            if(passwordEncoder.matches(authentication.getCredentials().toString(), user.get().getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority(user.get().getRole()));
                return new UsernamePasswordAuthenticationToken(user.get().getUsername(), user.get().getPassword(), authorities);
            } else {
                throw new BadCredentialsException("Invalid username or password!");
            }
        } else {
            throw new BadCredentialsException("No user registered on database with this details.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
