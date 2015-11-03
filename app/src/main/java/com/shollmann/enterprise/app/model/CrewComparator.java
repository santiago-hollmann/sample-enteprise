package com.shollmann.enterprise.app.model;

import java.util.Comparator;

public class CrewComparator {

    public static Comparator<CrewMember> BY_SKILLS_AND_NAME = new Comparator<CrewMember>() {
        @Override
        public int compare(CrewMember m1, CrewMember m2) {
            if (m2.getSkills() == m1.getSkills()) {
                return m1.getName().compareToIgnoreCase(m2.getName());
            }
            return m2.getSkills() - m1.getSkills();
        }
    };

}