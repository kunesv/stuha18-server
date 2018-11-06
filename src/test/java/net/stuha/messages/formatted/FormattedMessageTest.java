package net.stuha.messages.formatted;

import net.stuha.messages.MessageReplyTo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FormattedMessageTest {

    /**
     * ReplyTos
     * (@User Name) in the rough text of the message should match the value in Key of messageReplyTo objects.
     */
    @Test
    public void textProcessing() {
        String rough = "Ahoj @Test User, my friend.\n\rHave you seen http://seznam.cz? What do you think about this, @Test User(1)?";

        List<MessageReplyTo> messageReplyTos = new ArrayList<>();

        MessageReplyTo messageReply = new MessageReplyTo();
        messageReply.setReplyToId("111111-1111-1111-1111-111111111111");
        messageReply.setKey("@Test User");
        messageReply.setCaptionFromFormatted("{\"textNodes\":[{\"type\":\"PLAIN_TEXT\",\"text\":\"Hi \"},{\"type\":\"REPLY_TO\",\"replyToId\":\"33333333-3333-3333-3333-333333333333\",\"iconPath\":\"2_1\",\"caption\":\"Something very interresting Here ...\"},{\"type\":\"PLAIN_TEXT\",\"text\":\", how are you Today?\"}]}");
        messageReplyTos.add(messageReply);

        MessageReplyTo messageReply2 = new MessageReplyTo();
        messageReply2.setReplyToId("222222-2222-2222-2222-222222222222");
        messageReply2.setKey("@Test User(1)");
        messageReplyTos.add(messageReply2);

        FormattedMessage formattedMessage = new FormattedMessage(rough, messageReplyTos);

        Assert.assertTrue(formattedMessage.getTextNodes().size() == 10);
    }

    /**
     * Space between two nodes (link or replyTo) should be ignored.
     */
    @Test
    public void spaceInside() {
        String roughWithBlankStringInside = "http://seznam.cz http://seznam.cz";
        FormattedMessage formattedMessage = new FormattedMessage(roughWithBlankStringInside, new ArrayList<>());

        Assert.assertTrue(formattedMessage.getTextNodes().size() == 2);
    }
}