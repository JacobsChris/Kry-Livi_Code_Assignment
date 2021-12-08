package kry.persistence.domain;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "url", "siteName"})})

public class WebService {
    /*
    To make it so users only see services they add, add extra column with the user token in it + set up some amount of auth
    Then send a token with every request and only return rows that have matching token
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @URL(protocol = "", host = "")
    @NotNull
    @Column(name = "url", unique = true)
    private String url;

    @Column(name = "status")
    private Integer status;

    @NotBlank
    @NotNull
    @Column(name = "siteName", unique = true)
    private String siteName;

    @Column(name = "creation_time", nullable = false)
    private Instant creationTime;

    public WebService(Integer id, String url, String siteName, Integer status, Instant creationTime) {
        this.id = id;
        this.url = url;
        this.siteName = siteName;
        this.status = status;
        this.creationTime = creationTime;
    }

    public WebService() {}

    public Instant getCreationTime() {
        return creationTime;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
