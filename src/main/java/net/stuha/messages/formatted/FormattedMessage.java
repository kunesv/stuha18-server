package net.stuha.messages.formatted;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.stuha.messages.MessageReplyTo;
import net.stuha.messages.awards.AwardType;

import java.util.List;

public class FormattedMessage {

    private List<TextNode> textNodes;

    private List<AwardType> awards;

    public FormattedMessage() {
        // Needed for Jackson
    }

    public FormattedMessage(String rough, List<MessageReplyTo> messageReplyTos) {
        textNodes = FormattedTextParser.parseText(rough, messageReplyTos);
    }

    public List<TextNode> getTextNodes() {
        return textNodes;
    }

    public void setTextNodes(List<TextNode> textNodes) {
        this.textNodes = textNodes;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Unable to serialize JSON.", e);
        }
    }

    public List<AwardType> getAwards() {
        return awards;
    }

    public void setAwards(List<AwardType> awards) {
        this.awards = awards;
    }
}