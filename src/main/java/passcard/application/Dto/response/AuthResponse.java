package passcard.application.Dto.response;

import lombok.*;

@Data
public class AuthResponse {

    private String accessToken;
//    private String refreshToken;
    private String tokenType;
    private Long expiryDuration;

    public AuthResponse(String accessToken, Long expiryDuration) {
        this.accessToken = accessToken;
//        this.refreshToken = refreshToken;
        this.expiryDuration = expiryDuration;
        tokenType = "Bearer ";
    }
}
