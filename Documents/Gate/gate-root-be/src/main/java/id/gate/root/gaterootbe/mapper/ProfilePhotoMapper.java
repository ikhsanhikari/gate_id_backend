package id.gate.root.gaterootbe.mapper;

import id.gate.root.gaterootbe.data.dto.request.RequestProfilePhotoDTO;
import id.gate.root.gaterootbe.data.model.ProfilePhoto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfilePhotoMapper implements BaseMapper<ProfilePhoto, RequestProfilePhotoDTO>{

    @Override
    public ProfilePhoto reverse(RequestProfilePhotoDTO source) {

        ProfilePhoto result = new ProfilePhoto();

        result.setUserId(source.getUserId());
        result.setCreatedAt(new Date());
        result.setIsApply(true);
        result.setStatus(1);
        result.setUpdateAt(new Date());
        result.setUrl(source.getUrl());

        return result;
    }
}
