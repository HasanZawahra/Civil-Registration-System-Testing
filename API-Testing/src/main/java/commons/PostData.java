package commons;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PostData {

    String FirstName;
    String LastName;
    String ID;
    String Age;
    String Mobile;

    public PostData(String firstName, String lastName, String id, String age, String mobile) {
        this.ID = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
        this.Mobile = mobile;
    }

}
