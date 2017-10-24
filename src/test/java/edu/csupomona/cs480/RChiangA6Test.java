package edu.csupomona.cs480;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * This makes sure that the file contains at least one instance of the following:
 * name, image_url, url, coordinates, location, and display_phone.
 * @author Rachel Chiang
 */
public class RChiangA6Test {
   @Test
   public void testRCA6() {
      RChiangA6 a6 = new RChiangA6();
      Object[] fileLines = a6.getJsonLines();
      
      assertTrue(Arrays.asList(fileLines).contains("\"name\":"));
      assertTrue(Arrays.asList(fileLines).contains("\"image_url\":"));
      assertTrue(Arrays.asList(fileLines).contains("\"url\":"));
      assertTrue(Arrays.asList(fileLines).contains("\"coordinates\":"));
      assertTrue(Arrays.asList(fileLines).contains("\"location\":"));
      assertTrue(Arrays.asList(fileLines).contains("\"display_phone\":"));
   }
}
