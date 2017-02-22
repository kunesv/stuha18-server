package net.stuha.messages;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {

    @Query("SELECT m FROM Message m where m.conversationId = :conversationId")
    List<Message> findByConversationId(@Param("conversationId") UUID conversationId);
}
