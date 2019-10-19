package id.gate.root.gaterootbe.mapper;

import id.gate.root.gaterootbe.data.dto.request.RequestEducationDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseEducationDTO;
import id.gate.root.gaterootbe.data.model.Education;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EducationMapper implements BaseMapper<Education, RequestEducationDTO>{

    @Override
    public Education reverse(RequestEducationDTO source) {

        Education result = new Education();
        result.setActivies(source.getActivies());
        result.setCreatedAt(new Date());
        result.setDegree(source.getDegree());
        result.setDescription(source.getDescription());
        result.setEndYear(source.getEndYear());
        result.setFieldOfStudy(source.getFieldOfStudy());
        result.setGrade(source.getGrade());
        result.setSchool(source.getSchool());
        result.setStartYear(source.getStartYear());
        result.setStatus(1);
        result.setUpdateAt(new Date());

        return result;
    }

    public ResponseEducationDTO conver(Education source){

        ResponseEducationDTO result = new ResponseEducationDTO();
        result.setId(source.getId());
        result.setActivies(source.getActivies());
        result.setCreatedAt(source.getCreatedAt());
        result.setDegree(source.getDegree());
        result.setDescription(source.getDescription());
        result.setEndYear(source.getEndYear());
        result.setFieldOfStudy(source.getFieldOfStudy());
        result.setGrade(source.getGrade());
        result.setSchool(source.getSchool());
        result.setStartYear(source.getStartYear());
        result.setStatus(source.getStatus());
        result.setUpdateAt(source.getUpdateAt());
        result.setDeleteAt(source.getDeleteAt());

        return result;

    }
}
