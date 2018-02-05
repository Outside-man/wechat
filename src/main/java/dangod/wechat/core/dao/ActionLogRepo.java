package dangod.wechat.core.dao;

import dangod.wechat.core.model.po.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionLogRepo extends JpaRepository<ActionLog, Integer> {
}
