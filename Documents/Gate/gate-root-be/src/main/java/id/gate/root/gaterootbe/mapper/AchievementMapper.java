package id.gate.root.gaterootbe.mapper;

import id.gate.root.gaterootbe.data.dto.request.RequestAchievementDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseAchievementDTO;
import id.gate.root.gaterootbe.data.model.Achievement;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AchievementMapper implements BaseMapper<Achievement, RequestAchievementDTO>{
    @Override
    public Achievement reverse(RequestAchievementDTO source) {

        Achievement result = new Achievement();

        result.setCourseName(source.getCourseName());
        result.setAssociatedWith(source.getAssociatedWith());
        result.setCreatedAt(new Date());
        result.setUpdateAt(new Date());
        result.setStatus(1);

        return result;
    }

    public ResponseAchievementDTO convert(Achievement source) {
        ResponseAchievementDTO result = new ResponseAchievementDTO();
        result.setCourseName(source.getCourseName());
        result.setAssociatedWith(source.getAssociatedWith());
        return result;
    }
}
