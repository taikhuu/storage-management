package tai.com.khuu.storage.web.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@NamedQueries(value={@NamedQuery(name="authenticate",query="from user where userName=:username")})
@Entity(name="user")
public class User implements  UserDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid")
    private String uuid;
    @Column(nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "uuid"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "uuid"))
    private Set<Role> role;

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
}
