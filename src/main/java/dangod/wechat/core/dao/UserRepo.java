package dangod.wechat.core.dao;

import dangod.wechat.core.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
