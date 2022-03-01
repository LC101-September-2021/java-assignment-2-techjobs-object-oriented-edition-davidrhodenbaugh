package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job job1;
    Job job2;
    Job job3;

    @Before
    public void createJobs() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(job1.getId(), job2.getId(), 1);
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Yagadoo", new Employer("Chrome Dome Empire"), new Location("Maruhage"), new PositionType("Kaizoku"), new CoreCompetency("Plundering"));
        Job job5 = new Job("Yagadoo", new Employer("Chrome Dome Empire"), new Location("Maruhage"), new PositionType("Kaizoku"), new CoreCompetency("Plundering"));
        assertNotEquals(job4, job5);
    }

    @Test
    public void testJobsToStringNewLine() {
        Job job4 = new Job("Yagadoo", new Employer("Chrome Dome Empire"), new Location("Maruhage"), new PositionType("Kaizoku"), new CoreCompetency("Plundering"));
        //System.out.println(job4);
        assertEquals('\n', job4.toString().charAt(0));
        assertEquals('\n', job4.toString().charAt(job4.toString().length() -1));
    }

    @Test
    public void testJobsToStringEmptyField() {
        Job job4 = new Job("Yagadoo", new Employer(""), new Location("Maruhage"), new PositionType("Kaizoku"), new CoreCompetency("Plundering"));
        //System.out.println(job4);
        assertEquals("\n" + "ID: " + job4.getId() + "\n" + "Name: " + job4.getName() + "\n" + "Employer: " + "Data not available" + "\n" + "Location: " + job4.getLocation() + "\n" + "Position Type: " + job4.getPositionType() + "\n" + "Core Competency: " + job4.getCoreCompetency() + "\n", job4.toString());
    }

    @Test
    public void testJobsToStringFormat() {
        Job job4 = new Job("Yagadoo", new Employer("Chrome Dome Empire"), new Location("Maruhage"), new PositionType("Kaizoku"), new CoreCompetency("Plundering"));
        //System.out.println(job4);
        assertEquals("\n" + "ID: " + job4.getId() + "\n" + "Name: " + job4.getName() + "\n" + "Employer: " + job4.getEmployer() + "\n" + "Location: " + job4.getLocation() + "\n" + "Position Type: " + job4.getPositionType() + "\n" + "Core Competency: " + job4.getCoreCompetency() + "\n", job4.toString());
    }

    @Test
    public void testJobsToStringNoJobOMG() {
        Job job1 = new Job();
        //System.out.println(job1);
        assertEquals("OOPS! This job does not seem to exist.", job1.toString());
    }
}
