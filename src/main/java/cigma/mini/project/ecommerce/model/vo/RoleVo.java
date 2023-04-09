package cigma.mini.project.ecommerce.model.vo;

import cigma.mini.project.ecommerce.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo {

    private Long id;
    private String role;

    public static RoleVo toVo(Role role) {
        if (role == null || role.getId() == null) return null;

        RoleVo roleVo = new RoleVo();
        roleVo.setId(role.getId());
        roleVo.setRole(role.getRole());
        return roleVo;
    }

    public static Role toBo(RoleVo roleVo) {
        if (roleVo == null || roleVo.getId() == null) return null;

        Role role = new Role();
        role.setId(roleVo.getId());
        role.setRole(roleVo.getRole());
        return role;
    }

    public static List<RoleVo> toListVo(List<Role> roles) {
        if (CollectionUtils.isEmpty(roles)) return Collections.emptyList();

        List<RoleVo> roleVos = new ArrayList<>();
        roles.forEach(el -> roleVos.add(toVo(el)));
        return roleVos;
    }

    public static List<Role> toListBo(List<RoleVo> roleVos) {
        if (CollectionUtils.isEmpty(roleVos)) return Collections.emptyList();

        List<Role> roles = new ArrayList<>();
        roleVos.forEach(el -> roles.add(toBo(el)));
        return roles;
    }
}
