package main.ott.modules.point;

import main.ott.modules.base.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PointService extends Service<PointBo, PointDto> {

    @Autowired
    public PointService(SessionFactory sessionFactory, PointBoDtoMapper pointBoDtoMapper) {
        super(PointBo.class, sessionFactory, pointBoDtoMapper);
    }

}
