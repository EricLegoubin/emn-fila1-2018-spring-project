package main.ott.modules.course;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.passage.PassageDto;
import main.ott.modules.sillon.SillonDto;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of ={"id"})
public class CourseDto {

    /**
     * Id de la course.
     */
    private Long id;
    /**
     * Id du train relié à la course.
     */
    private String idTrain;
    /**
     * Les sillions de la course
      */
    private Set<SillonDto> sillons;
    /**
     * Les passages faits par la course.
     */
    private List<PassageDto> computedPassages;

    public CourseDto() {
    	super();
    }

    public CourseDto(Long id, String idTrain, Set<SillonDto> sillons, List<PassageDto> computedPassages) {
        super();
        this.id = id;
        this.idTrain = idTrain;
        this.sillons = sillons;
        this.computedPassages = computedPassages;
    }

}
