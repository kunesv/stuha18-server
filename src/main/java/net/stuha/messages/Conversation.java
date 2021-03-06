package net.stuha.messages;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Conversation {

    @Id
    private UUID id;

    private String title;

    private Boolean noJoin;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getNoJoin() {
        return noJoin;
    }

    public void setNoJoin(Boolean noJoin) {
        this.noJoin = noJoin;
    }
}
