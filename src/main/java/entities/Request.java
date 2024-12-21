package entities;

import entities.enums.RequestStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Request {
    @Id
    @GeneratedValue
    public UUID id;

    @NotNull
    public String message;

    @NotNull
    public RequestStatus status;

    //User sender;
    //User reciever;

    public Request() {}

    public Request(String message) {
        this.message = message;
        this.status = RequestStatus.OPEN;
    }
}
