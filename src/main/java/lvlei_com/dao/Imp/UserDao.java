package lvlei_com.dao.Imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lvlei_com.dao.IUserDao;
import lvlei_com.po.User;
@Service(value="UserDao")
public class UserDao implements IUserDao{
	@Resource
	org.mybatis.spring.SqlSessionTemplate sqlSession ;
	@Override
	public boolean addUser(User u) {
		int a=sqlSession.insert("lvlei_com.dao.IUserDao.addUser",u);
		if(a!=0){
			return true;
		}
		else{
		return false;
		}
	}
	@Override
	public User getUserByU(User u) {
		User a=sqlSession.selectOne("lvlei_com.dao.IUserDao.getUser",u);
		return a;
	}
}

