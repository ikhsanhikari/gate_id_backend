package id.gate.root.gaterootbe.service.impl;

import id.gate.root.gaterootbe.dao.ProfilePhotoDAO;
import id.gate.root.gaterootbe.data.dto.request.RequestProfilePhotoDTO;
import id.gate.root.gaterootbe.data.json.ResponseData;
import id.gate.root.gaterootbe.data.json.ResponseSave;
import id.gate.root.gaterootbe.data.model.ProfilePhoto;
import id.gate.root.gaterootbe.mapper.ProfilePhotoMapper;
import id.gate.root.gaterootbe.service.ProfilePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilePhotoServiceImpl implements ProfilePhotoService {

    @Autowired
    private ProfilePhotoDAO profilePhotoDAO;

    @Autowired
    private ProfilePhotoMapper profilePhotoMapper;

    @Override
    public ResponseEntity findAll() {
        return null;
    }

    @Override
    public ResponseEntity save(RequestProfilePhotoDTO requestProfilePhotoDTO) {
        List<ProfilePhoto> profilePhotos = profilePhotoDAO.getByUserId(requestProfilePhotoDTO.getUserId());
        for(ProfilePhoto profilePhoto: profilePhotos){
            profilePhoto.setIsApply(false);
        }

        ProfilePhoto profilePhoto = profilePhotoMapper.reverse(requestProfilePhotoDTO);
        profilePhotoDAO.save(profilePhoto);
        return ResponseEntity.ok(new ResponseSave(profilePhoto));
    }

    @Override
    public ResponseEntity update(RequestProfilePhotoDTO requestProfilePhotoDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity findByUserIdApply(Long userId) {
        ProfilePhoto profilePhoto = profilePhotoDAO.getApplyUserId(userId);
        return ResponseEntity.ok(new ResponseData(1,"profile_photos",profilePhoto));
    }
}
