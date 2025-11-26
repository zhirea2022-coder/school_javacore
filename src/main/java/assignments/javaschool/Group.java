package assignments.javaschool;

import java.util.*;

public class Group {

    private String name;

    private String room;

    private List<Trainee> trainees = new ArrayList<>();

    public Group(String name, String room) throws TrainingException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        if (room != null && !room.isEmpty()) {
            this.room = room;
        } else throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room != null && !room.isEmpty()) {
            this.room = room;
        } else throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (Trainee t : trainees) {
            if (t.getFirstName().equals(firstName)) {
                return t;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee trainee : trainees) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparingInt(Trainee::getRating).reversed());
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        int max = Collections.max(trainees, Comparator.comparingInt(Trainee::getRating))
                .getRating();

        List<Trainee> traineesMaxRating = new ArrayList<>();
        for (Trainee t : trainees) {
            if (t.getRating() == max) {
                traineesMaxRating.add(t);
            }
        }

        return traineesMaxRating;
    }

    public boolean hasDuplicates() {
        Set<Trainee> traineeSet = new HashSet<>(trainees);
        return traineeSet.size() < trainees.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(room, group.room) && Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
