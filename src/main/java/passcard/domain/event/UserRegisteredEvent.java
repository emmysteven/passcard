package passcard.domain.event;

import org.springframework.lang.NonNull;
import passcard.domain.entity.User;

public record UserRegisteredEvent(@NonNull User user) {
    public User getUser(User user) {
        return user;
    }
}
