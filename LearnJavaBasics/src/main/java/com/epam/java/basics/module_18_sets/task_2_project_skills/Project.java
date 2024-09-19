package com.epam.java.basics.module_18_sets.task_2_project_skills;

import java.util.*;

public class Project {
    private final List<Role> roles;

    private static class Entry {
        private final Level level;
        private final Skill skill;

        public Entry(Level level, Skill skill) {
            this.level = level;
            this.skill = skill;
        }

        public Level getLevel() {
            return level;
        }

        public Skill getSkill() {
            return skill;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return level == entry.level && skill == entry.skill;
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, skill);
        }
    }

    public Project(Role... roles) {
        List<Role> projectRole = new ArrayList<>();
        for (Role role : roles) {
            projectRole.add(role);
        }
        this.roles = projectRole;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public int getConformity(Set<Member> team) {
        List<Entry> projectEntries = new ArrayList<>();
        for (Role role : roles) {
            for (Skill skill : role.getSkills()) {
                projectEntries.add(new Entry(role.getLevel(), skill));
            }
        }
        int originalSize = projectEntries.size();

        List<Entry> teamEntries = new ArrayList<>();
        for (Member member : team) {
            for (Skill skill : member.getSkills()) {
                teamEntries.add(new Entry(member.getLevel(), skill));
            }
        }

        List<Entry> unmatchedEntries = new ArrayList<>(projectEntries);
        for (Entry teamEntry : teamEntries) {
            unmatchedEntries.remove(teamEntry);
        }
        int remainingSize = unmatchedEntries.size();

        return ((originalSize - remainingSize) * 100) / originalSize;
    }
}
