package id.gate.root.gaterootbe.service.impl;

import id.gate.root.gaterootbe.dao.ExperienceDAO;
import id.gate.root.gaterootbe.dao.UserExperienceDAO;
import id.gate.root.gaterootbe.data.dto.request.RequestExperienceDTO;
import id.gate.root.gaterootbe.data.json.*;
import id.gate.root.gaterootbe.data.model.Experience;
import id.gate.root.gaterootbe.data.model.UserExperience;
import id.gate.root.gaterootbe.mapper.ExperienceMapper;
import id.gate.root.gaterootbe.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceDAO experienceDAO;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private UserExperienceDAO userExperienceDAO;

    @Override
    public ResponseEntity findAll() {
        List<Experience> experiences = experienceDAO.select();
        return ResponseEntity.ok(new ResponseData(experiences.size(),"experience",experiences));
    }

    @Override
    public ResponseEntity save(RequestExperienceDTO requestExperienceDTO) {

        Experience experience=experienceMapper.reverse(requestExperienceDTO);

        Experience res = experienceDAO.save(experience);

        UserExperience userExperience = new UserExperience();
        userExperience.setUserId(requestExperienceDTO.getUserId());
        userExperience.setExperienceId(res.getId());
        userExperienceDAO.save(userExperience);

        return ResponseEntity.ok(new ResponseSave(experience));
    }


    @Override
    public ResponseEntity update(RequestExperienceDTO requestExperienceDTO, Long id) {

        Experience experience=experienceMapper.reverse(requestExperienceDTO);

        Experience cek = experienceDAO.get(id);

        if(cek==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Experience not found"));
        }

        experience.setUpdateAt(new Date());
        experience.setId(id);

        experienceDAO.save(experience);


        return ResponseEntity.ok(new ResponseUpdate(experience));
    }

    @Override
    public ResponseEntity delete(Long id) {
        Experience experience = experienceDAO.get(id);

        if(experience==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Achievement not found"));
        }

        experience.setDeleteAt(new Date());
        experience.setStatus(0);

        experienceDAO.save(experience);


        return ResponseEntity.ok(new ResponseDelete(experience ));
    }

    @Override
    public ResponseEntity findById(Long id) {
        Experience experience = experienceDAO.get(id);
        if(experience==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Experience not found"));
        }
        return ResponseEntity.ok(new ResponseData(1,"experience",experience));
    }
}
