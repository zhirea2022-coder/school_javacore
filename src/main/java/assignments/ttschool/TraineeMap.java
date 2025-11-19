package assignments.ttschool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {

    private Map<Trainee, String> traineeInfo;

    public TraineeMap() {
        traineeInfo = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeInfo.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        traineeInfo.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeInfo.replace(trainee, institute) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (traineeInfo.remove(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return traineeInfo.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (traineeInfo.containsKey(trainee)) {
            return traineeInfo.get(trainee);
        } else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(traineeInfo.keySet());
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeInfo.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return traineeInfo.containsValue(institute);
    }
}
