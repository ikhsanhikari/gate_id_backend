package id.gate.root.gaterootbe.service.impl;

import id.gate.root.gaterootbe.dao.EducationDAO;
import id.gate.root.gaterootbe.dao.UserEducationDAO;
import id.gate.root.gaterootbe.data.dto.request.RequestEducationDTO;
import id.gate.root.gaterootbe.data.json.*;
import id.gate.root.gaterootbe.data.model.Education;
import id.gate.root.gaterootbe.data.model.UserEducation;
import id.gate.root.gaterootbe.mapper.EducationMapper;
import id.gate.root.gaterootbe.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationDAO educationDAO;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private UserEducationDAO userEducationDAO;


    @Override
    public ResponseEntity findAll() {
        List<Education> educations = educationDAO.select();
        return ResponseEntity.ok(new ResponseData(educations.size(),"educations",educations));
    }

    @Override
    public ResponseEntity save(RequestEducationDTO requestEducationDTO) {
        Education education=educationMapper.reverse(requestEducationDTO);

        Education res = educationDAO.save(education);

        UserEducation userEducation = new UserEducation();
        userEducation.setUserId(requestEducationDTO.getUserId());
        userEducation.setEducationId(res.getId());
        userEducationDAO.save(userEducation);

        return ResponseEntity.ok(new ResponseSave(education));
    }

    @Override
    public ResponseEntity update(RequestEducationDTO requestEducationDTO, Long id) {
        Education education=educationMapper.reverse(requestEducationDTO);

        Education cek = educationDAO.get(id);

        if(cek==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Education not found"));
        }

        education.setUpdateAt(new Date());
        education.setId(id);

        educationDAO.save(education);


        return ResponseEntity.ok(new ResponseUpdate(education));
    }

    @Override
    public ResponseEntity delete(Long id) {
        Education education = educationDAO.get(id);

        if(education==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Education not found"));
        }

        education.setDeleteAt(new Date());
        education.setStatus(0);

        educationDAO.save(education);


        return ResponseEntity.ok(new ResponseDelete(education ));
    }

    @Override
    public ResponseEntity findById(Long id) {
        Education education = educationDAO.get(id);
        if(education==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Education not found"));
        }
        return ResponseEntity.ok(new ResponseData(1,"education",education));
    }
}
