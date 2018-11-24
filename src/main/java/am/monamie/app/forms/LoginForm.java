package am.monamie.app.forms;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoginForm {
    private String login;
    private String password;
}
