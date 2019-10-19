package id.gate.root.gaterootbe.mapper;

import id.gate.root.gaterootbe.data.dto.request.RequestExperienceDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseExperienceDTO;
import id.gate.root.gaterootbe.data.model.Experience;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExperienceMapper implements BaseMapper<Experience, RequestExperienceDTO>{

    @Override
    public Experience reverse(RequestExperienceDTO source) {

        Experience result = new Experience();
        result.setCompany(source.getCompany());
        result.setDescription(source.getDescription());
        result.setEndDate(source.getEndDate());
        result.setHeadline(source.getHeadline());
        result.setLocation(source.getLocation());
        result.setStartDate(source.getStartDate());
        result.setTitle(source.getTitle());
        result.setCreatedAt(new Date());
        result.setStatus(1);
        result.setUpdateAt(new Date());

        return result;
    }

    public ResponseExperienceDTO convert(Experience source){

        String pattern = "MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String startDate = simpleDateFormat.format(source.getStartDate());
        String endDate = simpleDateFormat.format(source.getEndDate());

        ResponseExperienceDTO result = new ResponseExperienceDTO();

        result.setCompany(source.getCompany());
        result.setDescription(source.getDescription());
        result.setEndDate(endDate);
        result.setHeadline(source.getHeadline());
        result.setLocation(source.getLocation());
        result.setStartDate(startDate);
        result.setTitle(source.getTitle());
        result.setCreatedAt(source.getCreatedAt());
        result.setStatus(source.getStatus());
        result.setUpdateAt(source.getUpdateAt());

        return result;
    }
}
