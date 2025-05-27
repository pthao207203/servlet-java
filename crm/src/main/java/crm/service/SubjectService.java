package crm.service;

import crm.model.Subject;
import crm.repository.SubjectRepository;

import java.util.List;

public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService() {
        this.subjectRepository = new SubjectRepository();
    }

    public boolean addSubject(Subject subject) throws Exception {
        return subjectRepository.addSubject(subject);
    }

    public boolean updateSubject(Subject subject) throws Exception {
        return subjectRepository.updateSubject(subject);
    }

    public boolean deleteSubjectById(int id) throws Exception {
        return subjectRepository.deleteSubjectById(id);
    }

    public List<Subject> getAllSubjects() throws Exception {
        return subjectRepository.getAllSubjects();
    }
}
