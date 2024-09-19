package com.epam.java.basics.module_18_sets.task_2_project_skills;

import java.util.EnumSet;
import java.util.Set;

public class Member {
    private final String name;
    private final Level level;
    private final Set<Skill> skills;

    public Member(String name, Level level, Skill... skills) {
        this.name = name;
        this.level = level;
        EnumSet<Skill> memberSkills = EnumSet.noneOf(Skill.class);
        for (Skill skill : skills) {
            memberSkills.add(skill);
        }
        this.skills = memberSkills;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}
