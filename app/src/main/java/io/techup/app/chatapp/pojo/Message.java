package io.techup.app.chatapp.pojo;

import java.util.Date;

/**
 * Created by ceosilvajr on 13/06/16.
 */
public class Message {

    private int id;

    private String message;

    private String senderName;

    private Date time;

    private String senderPhotoUrl;

    public Message(String message, String senderName, Date time, String senderPhotoUrl) {
        this.id = 0;
        this.message = message;
        this.senderName = senderName;
        this.time = time;
        this.senderPhotoUrl = senderPhotoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSenderPhotoUrl() {
        return senderPhotoUrl;
    }

    public void setSenderPhotoUrl(String senderPhotoUrl) {
        this.senderPhotoUrl = senderPhotoUrl;
    }
}
