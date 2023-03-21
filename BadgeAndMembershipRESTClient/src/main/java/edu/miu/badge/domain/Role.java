package edu.miu.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.badge.enumeration.RoleType;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Role {
    private int id;
    private RoleType roleType;
}
