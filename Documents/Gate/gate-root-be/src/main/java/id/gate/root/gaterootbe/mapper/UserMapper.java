package id.gate.root.gaterootbe.mapper;

import id.gate.root.gaterootbe.data.dto.request.RequestUserDTO;
import id.gate.root.gaterootbe.data.dto.response.ResponseUserDTO;
import id.gate.root.gaterootbe.data.model.User;
import id.gate.root.gaterootbe.util.AlphaNumeric;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserMapper implements BaseMapper<User, RequestUserDTO>{


    @Override
    public User reverse(RequestUserDTO source) {

        User user = new User();
        user.setFirstName(source.getFirstName());
        user.setBirthDate(new Date());
        user.setDescription(source.getDescription());
        user.setGender(source.getGender());
        user.setLastName(source.getLastName());
        user.setPhoneNumber(source.getPhoneNumber());
        user.setUsername(source.getFirstName()+ "-"+AlphaNumeric.randomAlphaNumeric(6));
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());

        user.setStatus(1);
        user.setCreatedAt(new Date());
        user.setUpdateAt(new Date());

        return user;
    }


    public ResponseUserDTO convert(User source) {
        ResponseUserDTO result = new ResponseUserDTO();
        result.setId(source.getId());
        result.setBirthDate(source.getBirthDate());
        result.setDescription(source.getDescription());
        result.setFirstName(source.getFirstName());
        result.setGender(source.getGender());
        result.setLastName(source.getLastName());
        result.setPhoneNumber(source.getPhoneNumber());
        result.setAchievements(null);
        return result;
    }
}
