package com.saif.enrollmentdetails.services;

import com.saif.enrollmentdetails.dao.TraineeDao;
import com.saif.enrollmentdetails.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author saifuzzaman
 */
@Service
public class TraineeService {

    @Autowired
    private TraineeDao traineeDao;

    public void saveOrUpdate(Trainee trainee) {
        traineeDao.saveOrUpdate(trainee);
    }

    private Optional<Trainee> findById(int id) {
        return traineeDao.find(id);
    }

    public Trainee getOrCreate(int id) {
        return findById(id).orElse(new Trainee());
    }

    public boolean isExists(int id) {
        return traineeDao.isExists(id);
    }

    public void delete(int traineeId) {
        traineeDao.delete(traineeId);
    }

    public List<Trainee> findAll() {
        return traineeDao.findAll();
    }
}
