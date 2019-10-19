package id.gate.root.gaterootbe.service.impl;

import id.gate.root.gaterootbe.dao.*;
import id.gate.root.gaterootbe.data.dto.request.RequestUserDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseAchievementDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseEducationDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseExperienceDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseUserDTO;
import id.gate.root.gaterootbe.data.json.*;
import id.gate.root.gaterootbe.data.model.*;
import id.gate.root.gaterootbe.mapper.AchievementMapper;
import id.gate.root.gaterootbe.mapper.EducationMapper;
import id.gate.root.gaterootbe.mapper.ExperienceMapper;
import id.gate.root.gaterootbe.mapper.UserMapper;
import id.gate.root.gaterootbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AchievementDAO achievementDAO;

    @Autowired
    private UserAchievementDAO userAchievementDAO;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Autowired
    private UserExperienceDAO userExperienceDAO;

    @Autowired
    private ExperienceDAO experienceDAO;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private UserEducationDAO userEducationDAO;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private EducationDAO educationDAO;

    @Override
    public ResponseEntity findAll() {
        List<User> users = userDAO.select();
        List<ResponseUserDTO> result = new ArrayList<>();
        for (User user: users) {

            //add achievement list
            List<ResponseAchievementDTO> achievementDTOS =  new ArrayList<>();
            List<UserAchievement> userAchievements = userAchievementDAO.findByUserId(user.getId());
            for(UserAchievement userAchievement: userAchievements){
                Achievement achievement = achievementDAO.get(userAchievement.getAchievementId());
                ResponseAchievementDTO responseAchievementDTO = achievementMapper.convert(achievement);
                achievementDTOS.add(responseAchievementDTO);
            }


            //add experience list
            List<ResponseExperienceDTO> responseExperienceDTOS = new ArrayList<>();
            List<UserExperience> userExperiences = userExperienceDAO.findByUserId(user.getId());
            for (UserExperience userExperience: userExperiences){
                Experience experience =  experienceDAO.get(userExperience.getExperienceId());

                ResponseExperienceDTO responseExperienceDTO = experienceMapper.convert(experience);

                responseExperienceDTOS.add(responseExperienceDTO);
            }

            //add educations list
            List<ResponseEducationDTO> responseEducationDTOS = new ArrayList<>();
            List<UserEducation> userEducations = userEducationDAO.findByUserId(user.getId());
            for(UserEducation userEducation: userEducations){

                Education education = educationDAO.get(userEducation.getEducationId());

                ResponseEducationDTO responseEducationDTO = educationMapper.conver(education);

                responseEducationDTOS.add(responseEducationDTO);
            }

            ResponseUserDTO response = userMapper.convert(user);
            response.setAchievements(achievementDTOS);
            response.setExperiences(responseExperienceDTOS);
            response.setEducations(responseEducationDTOS);
            result.add(response);
        }
        return ResponseEntity.ok(new ResponseData(users.size(),"user",result));
    }

    @Override
    public ResponseEntity save(RequestUserDTO requestUserDTO) {
        User user = userMapper.reverse(requestUserDTO);
        userDAO.save(user);
        return ResponseEntity.ok(new ResponseSave(user));
    }

    @Override
    public ResponseEntity update(RequestUserDTO requestUserDTO,Long id) {
        User user = userMapper.reverse(requestUserDTO);

        User cek = userDAO.get(id);

        if(cek==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("User not found"));
        }

        user.setId(id);
        user.setUpdateAt(new Date());

        userDAO.save(user);
        return ResponseEntity.ok(new ResponseUpdate(user));
    }

    @Override
    public ResponseEntity delete(Long id) {
        User user = userDAO.get(id);

        if(user==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("User not found"));
        }

        user.setStatus(0);
        user.setDeleteAt(new Date());

        userDAO.save(user);
        return ResponseEntity.ok(new ResponseDelete(user));
    }

    @Override
    public ResponseEntity findById(Long id) {
        User user = userDAO.get(id);
        List<ResponseAchievementDTO> achievementDTOS =  new ArrayList<>();
        List<UserAchievement> userAchievements = userAchievementDAO.findByUserId(user.getId());
        for(UserAchievement userAchievement: userAchievements){
            Achievement achievement = achievementDAO.get(userAchievement.getAchievementId());
            ResponseAchievementDTO responseAchievementDTO = achievementMapper.convert(achievement);
            achievementDTOS.add(responseAchievementDTO);
        }

        //add experience list
        List<ResponseExperienceDTO> responseExperienceDTOS = new ArrayList<>();
        List<UserExperience> userExperiences = userExperienceDAO.findByUserId(user.getId());
        for (UserExperience userExperience: userExperiences){
            Experience experience =  experienceDAO.get(userExperience.getExperienceId());

            ResponseExperienceDTO responseExperienceDTO = experienceMapper.convert(experience);

            responseExperienceDTOS.add(responseExperienceDTO);
        }

        //add educations list
        List<ResponseEducationDTO> responseEducationDTOS = new ArrayList<>();
        List<UserEducation> userEducations = userEducationDAO.findByUserId(user.getId());
        for(UserEducation userEducation: userEducations){

            Education education = educationDAO.get(userEducation.getEducationId());

            ResponseEducationDTO responseEducationDTO = educationMapper.conver(education);

            responseEducationDTOS.add(responseEducationDTO);
        }

        ResponseUserDTO response = userMapper.convert(user);

        response.setAchievements(achievementDTOS);
        response.setExperiences(responseExperienceDTOS);
        response.setEducations(responseEducationDTOS);

        if(user==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("User not found"));
        }
        return ResponseEntity.ok(new ResponseData(1,"user",response));
    }

    @Override
    public ResponseEntity findByUsername(String username) {
        User user = userDAO.findByUsername(username);
        List<ResponseAchievementDTO> achievementDTOS =  new ArrayList<>();
        List<UserAchievement> userAchievements = userAchievementDAO.findByUserId(user.getId());
        for(UserAchievement userAchievement: userAchievements){
            Achievement achievement = achievementDAO.get(userAchievement.getAchievementId());
            ResponseAchievementDTO responseAchievementDTO = achievementMapper.convert(achievement);
            achievementDTOS.add(responseAchievementDTO);
        }

        //add experience list
        List<ResponseExperienceDTO> responseExperienceDTOS = new ArrayList<>();
        List<UserExperience> userExperiences = userExperienceDAO.findByUserId(user.getId());
        for (UserExperience userExperience: userExperiences){
            Experience experience =  experienceDAO.get(userExperience.getExperienceId());

            ResponseExperienceDTO responseExperienceDTO = experienceMapper.convert(experience);

            responseExperienceDTOS.add(responseExperienceDTO);
        }

        //add educations list
        List<ResponseEducationDTO> responseEducationDTOS = new ArrayList<>();
        List<UserEducation> userEducations = userEducationDAO.findByUserId(user.getId());
        for(UserEducation userEducation: userEducations){

            Education education = educationDAO.get(userEducation.getEducationId());

            ResponseEducationDTO responseEducationDTO = educationMapper.conver(education);

            responseEducationDTOS.add(responseEducationDTO);
        }

        ResponseUserDTO response = userMapper.convert(user);

        response.setAchievements(achievementDTOS);
        response.setExperiences(responseExperienceDTOS);
        response.setEducations(responseEducationDTOS);

        if(user==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("User not found"));
        }
        return ResponseEntity.ok(new ResponseData(1,"user",response));
    }
}
