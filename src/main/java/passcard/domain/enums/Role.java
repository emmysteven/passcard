package passcard.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Role {
    USER,
    ADMIN,
    SYSTEM
}
