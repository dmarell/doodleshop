/*
 * Created by Daniel Marell 14-02-22 11:40
 */
package se.caglabs.doodleshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doodle_message")
public class DoodleMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "createdat", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "message", nullable = false)
    private String message;

    public DoodleMessage() {
    }

    public DoodleMessage(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DoodleMessage{" +
                "id=" + id +
                ", created=" + created +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
