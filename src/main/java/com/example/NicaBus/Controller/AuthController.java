package com.example.NicaBus.Controller;
import com.example.NicaBus.entity.Usuario;
import com.example.NicaBus.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(authService.register(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String correo,
            @RequestParam String password) {

        return ResponseEntity.ok(authService.login(correo, password));
    }

}