import com.gmail.mordress.lab4.domain.Role;

public class RoleTester {

    public static void main(String[] args) {
        Role role = Role.getById(2);
        System.out.println(role);
    }

}
