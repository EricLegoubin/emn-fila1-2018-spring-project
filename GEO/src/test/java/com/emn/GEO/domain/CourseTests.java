/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emn.GEO.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author eliot
 */

public class CourseTests {
    private Course course;
    
    @Before
    public void setUp(){
        Set<POI> pois = new HashSet<>();
        POI poi1 = new POI(new Long(1), true, "poi1");
        POI poi2 = new POI(new Long(2), false, "poi2");
        POI poi3 = new POI(new Long(3), false, "poi3");
        pois.add(poi1);
        pois.add(poi2);
        pois.add(poi3);
        Set<Sillon> sillons = new HashSet<>();
        Sillon sillon = new Sillon(new Long(1), pois);
        List<Passage> passages = new ArrayList<>();
        passages.add(new Passage(this.course, poi1, new Timestamp(2017, 12, 28, 14, 0, 0, 0)));
        passages.add(new Passage(this.course, poi2, new Timestamp(2017, 12, 28, 14, 10, 0, 0)));
        passages.add(new Passage(this.course, poi3, new Timestamp(2017, 12, 28, 14, 20, 0, 0)));
        sillons.add(sillon);
        this.course = new Course(new Long(1), new Long(1), sillons, passages);
    }
    
    @Test
    public void testAddPErturbation(){
        course.addPerturbationOnPassage(new Long(2), 5);
        Assert.assertEquals(new Timestamp(2017, 12, 28, 14, 0, 0, 0), course.getPassages().get(0).getTime());
        Assert.assertEquals(new Timestamp(2017, 12, 28, 14, 15, 0, 0), course.getPassages().get(1).getTime());
        Assert.assertEquals(new Timestamp(2017, 12, 28, 14, 25, 0, 0), course.getPassages().get(2).getTime());
    }
    
    @Test
    public void testCancelationOnPassage(){
        course.addCancelationOnPassage(new Long(2));
        Assert.assertEquals(new Timestamp(2017, 12, 28, 14, 0, 0, 0), course.getPassages().get(0).getTime());
        Assert.assertEquals(1, course.getPassages().size());
    }
}
