package main.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@javax.persistence.Entity
@Getter
@Setter
@Table(name = "sk_example_table")
@TypeDef(name = "json",typeClass = JsonType.class)
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Type(type = "json")
    @Column(name = "obj", columnDefinition = "json")
    private String jsonProperty;
}
