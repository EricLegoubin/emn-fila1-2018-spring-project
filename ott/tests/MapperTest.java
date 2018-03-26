import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseBoDtoMapper;
import main.ott.modules.course.CourseDto;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.point.PointBo;
import main.ott.modules.sillon.SillonBo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class MapperTest {

    private CourseBoDtoMapper mapperCourse = new CourseBoDtoMapper();

    @Test
    void testMappingCourse() {
        Set<SillonBo> sillons = new HashSet<>();
        sillons.add(makeSillon(1));
        sillons.add(makeSillon(2));
        CourseBo courseBo = new CourseBo();
        courseBo.setIdTrain("1234");
        courseBo.setId(1234L);

        courseBo.setSillons(sillons);
        courseBo.setComputedPassages(passages());

        CourseDto courseDto = mapperCourse.bo2Dto(courseBo);
        Assert.assertNotNull(courseDto);
        Assert.assertFalse(courseDto.getSillons().isEmpty());
        Assert.assertFalse(courseDto.getComputedPassages().isEmpty());
    }

    private SillonBo makeSillon(int id) {
        SillonBo sillon = new SillonBo();
        sillon.setId((long) id);
        Set<PointBo> points = new HashSet<>();
        points.add(new PointBo("gare1", true));
        points.add(new PointBo("etape1", false));
        points.add(new PointBo("etape2", false));
        points.add(new PointBo("etape3", false));
        points.add(new PointBo("gare2", true));
        sillon.setPoints(points);
        return sillon;
    }

    private Set<PassageBo> passages() {
        Set<PassageBo> passages = new HashSet<>();
        passages.add(new PassageBo());
        return passages;
    }

    @Test
    void testMappingJson() {
        Set<SillonBo> sillons = new HashSet<>();
        sillons.add(makeSillon(1));
        sillons.add(makeSillon(2));
        CourseBo courseBo = new CourseBo();
        courseBo.setIdTrain("1234");
        courseBo.setId(1234L);

        courseBo.setSillons(sillons);
        courseBo.setComputedPassages(passages());
        ObjectMapper mapperJson = new ObjectMapper();
        String message = "";
        try {
            message = mapperJson.writeValueAsString(courseBo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}
