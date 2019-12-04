package com.gkyt.jwgk.domain.account.user;

import com.gkzx.shared.util.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSpecification implements Specification<User> {
    private String username;
    private String phone;
    private String roleId;
    private UserStatus status;
    private Date createdStartDate;
    private Date createdEndDate;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(username)){
            predicates.add(criteriaBuilder.equal(root.get("userName"), username));
        }
        if(!StringUtils.isEmpty(phone)){
            predicates.add(criteriaBuilder.equal(root.get("phone"),phone));
        }
        if (!org.springframework.util.StringUtils.isEmpty(roleId)) {
            predicates.add(criteriaBuilder.equal(root.joinList("userRoles").get("role").get("id"), roleId));
        }
        if (!org.springframework.util.StringUtils.isEmpty(status)) {
            predicates.add(criteriaBuilder.equal(root.get("status"), status));
        }
        if (createdStartDate != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdTime"), createdStartDate));
        }
        if (createdEndDate != null) {
            predicates.add(criteriaBuilder.lessThan(root.get("createdTime"), DateUtils.addDays(createdEndDate, 1)));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
