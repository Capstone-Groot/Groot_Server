package com.groot.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    private String type;

    @Column
    private LocalDateTime createdDate;

    @Column
    private String filePath;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_flower_writer"))
    private User writer;

    public Flower(String type, String filePath, User writer) {
        this.createdDate = LocalDateTime.now();
        this.type = type;
        this.filePath = filePath;
        this.writer = writer;
    }

    public boolean isWriter(String userId) {
        return this.writer.isSameUser(userId);
    }

    public JSONObject getJson(){
        JSONObject entity = new JSONObject();
        entity.put("id", id);
        entity.put("createdDate", createdDate);
        entity.put("type", type);
        entity.put("filePath", filePath);

        return entity;
    }

}
