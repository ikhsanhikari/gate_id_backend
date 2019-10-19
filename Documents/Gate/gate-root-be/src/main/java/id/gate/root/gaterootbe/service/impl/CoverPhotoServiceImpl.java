package id.gate.root.gaterootbe.service.impl;

import id.gate.root.gaterootbe.dao.CoverPhotoDAO;
import id.gate.root.gaterootbe.data.dto.request.RequestCoverPhotoDTO;
import id.gate.root.gaterootbe.data.json.ResponseData;
import id.gate.root.gaterootbe.data.json.ResponseMessage;
import id.gate.root.gaterootbe.data.json.ResponseSave;
import id.gate.root.gaterootbe.data.model.CoverPhoto;
import id.gate.root.gaterootbe.mapper.CoverPhotoMapper;
import id.gate.root.gaterootbe.service.CoverPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverPhotoServiceImpl implements CoverPhotoService {

    @Autowired
    private CoverPhotoDAO coverPhotoDAO;

    @Autowired
    private CoverPhotoMapper coverPhotoMapper;


    @Override
    public ResponseEntity findAll() {
        List<CoverPhoto> coverPhotos = coverPhotoDAO.select();
        return ResponseEntity.ok(new ResponseData(coverPhotos.size(),"cover_photos",coverPhotos));
    }

    @Override
    public ResponseEntity save(RequestCoverPhotoDTO requestCoverPhotoDTO) {

        List<CoverPhoto> coverPhotos = coverPhotoDAO.getByUserId(requestCoverPhotoDTO.getUserId());
        for(CoverPhoto coverPhoto: coverPhotos){
            coverPhoto.setIsApply(false);
        }

        CoverPhoto coverPhoto = coverPhotoMapper.reverse(requestCoverPhotoDTO);
        coverPhotoDAO.save(coverPhoto);
        return ResponseEntity.ok(new ResponseSave(coverPhoto));
    }

    @Override
    public ResponseEntity update(RequestCoverPhotoDTO requestCoverPhotoDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity findById(Long id) {
        CoverPhoto coverPhoto = coverPhotoDAO.get(id);
        if(coverPhoto==null){
            return ResponseEntity.badRequest().body(new ResponseMessage("CoverPhoto not found"));
        }
        return ResponseEntity.ok(new ResponseData(1,"cover_photos",coverPhoto));
    }

    @Override
    public ResponseEntity findByUserIdApply(Long userId) {
        CoverPhoto coverPhoto = coverPhotoDAO.getApplyUserId(userId);
        return ResponseEntity.ok(new ResponseData(1,"cover_photos",coverPhoto));
    }
}
