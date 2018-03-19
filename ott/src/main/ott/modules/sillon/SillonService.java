package main.ott.modules.sillon;

import main.ott.modules.base.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SillonService extends Service<SillonBo> {

    @Autowired
    protected SillonService(SessionFactory sessionFactory, SillonBoDtoMapper sillonBoDtoMapper) {
        super(SillonBo.class, sessionFactory);
    }

}
