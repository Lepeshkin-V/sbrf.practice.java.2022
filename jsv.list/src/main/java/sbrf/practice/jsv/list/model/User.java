package sbrf.practice.jsv.list.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Base {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    private UUID id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
