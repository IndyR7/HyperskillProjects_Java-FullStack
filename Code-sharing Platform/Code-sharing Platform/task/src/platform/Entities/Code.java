package platform.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="code")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "initial_time")
    private long initialTime;

    @Column(name = "time_left")
    private long timeLeft;

    @Column(name = "initial_views")
    private long initialViews;

    @Column(name="views_left")
    private long viewsLeft;

    @Column(name = "secret")
    private boolean secret;
}