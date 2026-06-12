package com.example.NicaBus.services;
import com.example.NicaBus.entity.Role;
import com.example.NicaBus.entity.Usuario;
import com.example.NicaBus.repository.RoleRepository;
import com.example.NicaBus.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario register(Usuario usuario){

        if(usuarioRepository.existsByCorreo(usuario.getCorreo())){
            throw new RuntimeException("El correo ya existe");
        }

        usuario.setPasswordHash(
                passwordEncoder.encode(usuario.getPasswordHash())
        );

        Role rol = roleRepository.findByNombre("USER")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setSaldo(BigDecimal.ZERO);

        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }

    public String login(String correo,String password){

        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if(!passwordEncoder.matches(password,usuario.getPasswordHash())){
            throw new RuntimeException("Contraseña incorrecta");
        }

        return "Login exitoso";
    }

}