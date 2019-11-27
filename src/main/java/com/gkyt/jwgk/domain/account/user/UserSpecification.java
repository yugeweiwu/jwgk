package com.gkyt.jwgk.domain.account.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSpecification implements Specification<User> {
    private String username;
    private String phone;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isBlank(username)){
            predicates.add(criteriaBuilder.equal(root.get("userName"), username));
        }
        if(!StringUtils.isBlank(phone)){
            predicates.add(criteriaBuilder.equal(root.get("phone"),phone));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
