package assignments.ttschool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {

    private String name;

    private int year;

    private Set<Group> groups = new HashSet<>();

    public School(String name, int year) throws TrainingException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group g : groups) {
            if (g.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        if (!groups.removeIf(g -> g.getName().equals(name))) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year && Objects.equals(name, school.name) && Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
