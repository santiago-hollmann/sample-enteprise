package com.shollmann.enterprise.app.model;

import java.util.Comparator;

public class CrewComparator {

    public static Comparator<CrewMember> BY_NAME = new Comparator<CrewMember>() {
        @Override
        public int compare(CrewMember m1, CrewMember m2) {
            return m1.getName().compareTo(m2.getName());
        }
    };

    public static Comparator<CrewMember> BY_SKILLS_AND_NAME = new Comparator<CrewMember>() {
        @Override
        public int compare(CrewMember m1, CrewMember m2) {
            if (m1.getSkills() > m2.getSkills()) {
                return 1;
            } else if (m1.getSkills() == m2.getSkills()) {
                return m1.getName().compareTo(m2.getName());
            } else {
                return 0;
            }
        }
    };

}