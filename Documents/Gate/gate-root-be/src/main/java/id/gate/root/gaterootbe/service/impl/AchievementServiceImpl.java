package id.gate.root.gaterootbe.service.impl;

import id.gate.root.gaterootbe.dao.AchievementDAO;
import id.gate.root.gaterootbe.dao.UserAchievementDAO;
import id.gate.root.gaterootbe.data.dto.request.RequestAchievementDTO;
import id.gate.root.gaterootbe.data.json.*;
import id.gate.root.gaterootbe.data.model.Achievement;
import id.gate.root.gaterootbe.data.model.UserAchievement;
import id.gate.root.gaterootbe.mapper.AchievementMapper;
import id.gate.root.gaterootbe.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementDAO achievementDAO;

    @Autowired
    private AchievementMapper achievementMapper;

    @Autowired
    private UserAchievementDAO userAchievementDAO;

    @Override
    public ResponseEntity findAll() {
        List<Achievement> achievements = achievementDAO.select();
        return ResponseEntity.ok(new ResponseData(achievements.size(),"achievement",achievements));
    }

    @Override
    public ResponseEntity save(RequestAchievementDTO requestAchievementDTO) {
        Achievement achievement=achievementMapper.reverse(requestAchievementDTO);

        Achievement res = achievementDAO.save(achievement);

        UserAchievement userAchievement = new UserAchievement();
        userAchievement.setUserId(requestAchievementDTO.getUserId());
        userAchievement.setAchievementId(res.getId());
        userAchievementDAO.save(userAchievement);

        return ResponseEntity.ok(new ResponseSave(achievement));
    }

    @Override
    public ResponseEntity update(RequestAchievementDTO requestAchievementDTO, Long id) {
        Achievement achievement=achievementMapper.reverse(requestAchievementDTO);

        Achievement cek = achievementDAO.get(id);

        if(cek==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Achievement not found"));
        }

        achievement.setUpdateAt(new Date());
        achievement.setId(id);

        achievementDAO.save(achievement);


        return ResponseEntity.ok(new ResponseUpdate(achievement));
    }

    @Override
    public ResponseEntity delete(Long id) {
        Achievement achievement = achievementDAO.get(id);

        if(achievement==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Achievement not found"));
        }

        achievement.setDeleteAt(new Date());
        achievement.setStatus(0);

        achievementDAO.save(achievement);


        return ResponseEntity.ok(new ResponseDelete(achievement));
    }

    @Override
    public ResponseEntity findById(Long id) {
        Achievement achievement = achievementDAO.get(id);
        if(achievement==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("Achievement not found"));
        }
        return ResponseEntity.ok(new ResponseData(1,"achievement",achievement));
    }
}
