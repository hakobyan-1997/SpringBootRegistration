package am.monamie.app.forms;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
