package dangod.wechat.core.dao;

import dangod.wechat.core.model.po.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepo extends JpaRepository<Action, Integer> {
}
