package id.gate.root.gaterootbe.dao;



import id.gate.root.gaterootbe.data.model.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfilePhotoDAO extends JpaRepository<ProfilePhoto,Long> {

    @Query("select u from ProfilePhoto u where u.status = 1 and id = ?1")
    ProfilePhoto get(Long id);

    @Query("select u from ProfilePhoto u where u.status = 1")
    List<ProfilePhoto> select();

    @Query("select u from ProfilePhoto u where u.status = 1 and u.userId = ?1 and u.isApply=true order by u.id desc")
    ProfilePhoto getApplyUserId(Long userId);

    @Query("select u from ProfilePhoto u where u.status = 1 and u.userId = ?1")
    List<ProfilePhoto> getByUserId(Long userId);

}
