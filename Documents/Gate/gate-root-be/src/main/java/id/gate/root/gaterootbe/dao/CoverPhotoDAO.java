package id.gate.root.gaterootbe.dao;


import id.gate.root.gaterootbe.data.model.CoverPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoverPhotoDAO extends JpaRepository<CoverPhoto,Long> {

    @Query("select u from CoverPhoto u where u.status = 1 and id = ?1")
    CoverPhoto get(Long id);

    @Query("select u from CoverPhoto u where u.status = 1")
    List<CoverPhoto> select();

    @Query("select u from CoverPhoto u where u.status = 1 and u.userId = ?1 and u.isApply=true order by u.id desc")
    CoverPhoto getApplyUserId(Long userId);

    @Query("select u from CoverPhoto u where u.status = 1 and u.userId = ?1")
    List<CoverPhoto> getByUserId(Long userId);
}
