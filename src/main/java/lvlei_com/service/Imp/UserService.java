package lvlei_com.service.Imp;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lvlei_com.dao.IUserDao;
import lvlei_com.po.User;
import lvlei_com.service.IUserService;
@Service(value="UserService")
public class UserService implements IUserService{
     @Resource
     IUserDao UserDao;
	@Override
	public boolean register(User u) {
		boolean a = UserDao.addUser(u);
		return a;
	}
	@Override
	public User getUser(User u) {
		return  UserDao.getUserByU(u);
	}
}

