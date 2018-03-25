package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseBoDtoMapper;
import main.ott.modules.course.CourseDto;
import main.ott.modules.course.CourseService;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.point.PointBo;
import main.ott.modules.sillon.SillonBo;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class mapperTest
{

    @Autowired
    CourseBoDtoMapper mapperCourse;



    @Test
    public void testMappingCourse(){
        Set sillons = new HashSet();
        sillons.add( makeSillon(1));
        sillons.add( makeSillon(2));
        CourseBo courseBo = new CourseBo();
        courseBo.setIdTrain("1234");
        courseBo.setId(new Long(1234));

        courseBo.setSillons(sillons);
        courseBo.setComputedPassages(passages());

        CourseDto courseDto = mapperCourse.bo2Dto(courseBo);
        Assert.notNull(courseDto);
        org.junit.Assert.assertFalse(courseDto.getSillons().isEmpty());
        org.junit.Assert.assertFalse(courseDto.getComputedPassages().isEmpty());
    }

    public SillonBo makeSillon(int id){
        SillonBo sillon = new SillonBo();
        sillon.setId(new Long(id));
        Set points = new HashSet();
        points.add(new PointBo("gare1",true));
        points.add(new PointBo("etape1",false));
        points.add(new PointBo("etape2",false));
        points.add(new PointBo("etape3",false));
        points.add(new PointBo("gare2",true));
        sillon.setPoints(points);
        return sillon;
    }
    public Set passages(){
        Set passages = new HashSet();
        passages.add (new PassageBo());
        return passages;
    }

    @Test
    public void testMappingJson(){
        Set sillons = new HashSet();
        sillons.add( makeSillon(1));
        sillons.add( makeSillon(2));
        CourseBo courseBo = new CourseBo();
        courseBo.setIdTrain("1234");
        courseBo.setId(new Long(1234));

        courseBo.setSillons(sillons);
        courseBo.setComputedPassages(passages());
        ObjectMapper mapperJson = new ObjectMapper();
        String message  = "";
        try {
            message = mapperJson.writeValueAsString(courseBo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }

}
