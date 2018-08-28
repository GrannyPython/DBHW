package streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Employee {
    String name;
    Integer salary;
    String companyName;
}
