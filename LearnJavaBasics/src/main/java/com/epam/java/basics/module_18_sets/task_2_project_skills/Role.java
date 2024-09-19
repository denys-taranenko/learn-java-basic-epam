package com.epam.java.basics.module_18_sets.task_2_project_skills;

import java.util.EnumSet;
import java.util.Set;

public class Role {
    private final Position position;
    private final Level level;
    private final Set<Skill> skills;

    public Role(Position position, Level level, Skill... skills) {
        this.position = position;
        this.level = level;
        EnumSet<Skill> roleSkills = EnumSet.noneOf(Skill.class);
        for (Skill skill : skills) {
            roleSkills.add(skill);
        }
        this.skills = roleSkills;
    }

    public Position getPosition() {
        return position;
    }

    public Level getLevel() {
        return level;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}
