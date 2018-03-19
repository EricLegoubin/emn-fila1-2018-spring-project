package main.ott.modules.sillon;

import main.ott.modules.base.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SillonService extends Service<SillonBo, SillonDto> {

    @Autowired
    public SillonService(SessionFactory sessionFactory, SillonBoDtoMapper sillonBoDtoMapper) {
        super(SillonBo.class, sessionFactory, sillonBoDtoMapper);
    }
    
}
