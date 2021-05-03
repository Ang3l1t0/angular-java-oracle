package jpa.seleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scores")
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCORE_ID", unique = true, nullable = false)
    private Long scoreId;

    @Column(name = "DB_ID", unique = true, nullable = false)
    private String dbId;

    @Column(name = "SCORE")
    private String score;

    public Scores() {
        super();
    }

    public String getDbId() {
        return this.dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
