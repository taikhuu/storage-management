package tai.com.khuu.storage.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Role {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2",strategy="uuid2")
    private String uuid;
    @Column(name="rolename",nullable=false)
    private String roleName;
    @Column(name="role_description",nullable=false)
    private String roleDescription;
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleDescription() {
        return roleDescription;
    }
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

}
