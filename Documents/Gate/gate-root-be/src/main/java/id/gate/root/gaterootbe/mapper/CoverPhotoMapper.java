package id.gate.root.gaterootbe.mapper;

import id.gate.root.gaterootbe.data.dto.request.RequestCoverPhotoDTO;
import id.gate.root.gaterootbe.data.model.CoverPhoto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CoverPhotoMapper implements BaseMapper<CoverPhoto, RequestCoverPhotoDTO>{

    @Override
    public CoverPhoto reverse(RequestCoverPhotoDTO source) {

        CoverPhoto result = new CoverPhoto();

        result.setUserId(source.getUserId());
        result.setCreatedAt(new Date());
        result.setIsApply(true);
        result.setStatus(1);
        result.setUpdateAt(new Date());
        result.setUrl(source.getUrl());

        return result;
    }
}
