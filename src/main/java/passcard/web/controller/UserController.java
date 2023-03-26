package passcard.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import passcard.application.Dto.request.LoginDto;
import passcard.application.Dto.response.AuthResponse;
import passcard.domain.entity.User;
import passcard.infrastructure.service.UserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Mono<User> register(@Valid @RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> authenticate(@RequestBody LoginDto loginDto) {
        return userService
                .authenticate(loginDto)
                .map(authResponse -> ResponseEntity.ok().body(authResponse))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }
}
