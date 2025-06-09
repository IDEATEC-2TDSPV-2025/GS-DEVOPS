package br.com.fiap.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busque o usuário no banco e retorne um objeto UserDetails
        // Exemplo fictício:
        // return new org.springframework.security.core.userdetails.User(
        //      "usuario", "senhaCriptografada", new ArrayList<>());
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
