package main.ott.modules.passage;

import main.ott.modules.base.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PassageService extends Service<PassageBo> {

    @Autowired
    protected PassageService(SessionFactory sessionFactory) {
        super(PassageBo.class, sessionFactory);
    }

}
