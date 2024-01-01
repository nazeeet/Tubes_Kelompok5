
package Model;


public class User {
    private String id;
    private String Nama;
    private String Email;
    private String password;
    private String Role;

    public User(String id, String Nama, String Email, String password, String Role) {
        this.id = id;
        this.Nama = Nama;
        this.Email = Email;
        this.password = password;
        this.Role = Role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    
}
