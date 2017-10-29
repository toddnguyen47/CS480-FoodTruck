package edu.csupomona.cs480;

import org.junit.Test;
import edu.csupomona.cs480.ThoNguyenA6;
import org.junit.Assert;

/**
 * This makes sure that the file contains at least one instance of the following:
 * name, image_url, url, coordinates, location, and display_phone.
 * @author Allen Artoonian
 */
public class asartoonianA6Test {
   @Test
   public void testGetDisplayName() {
       asartoonianA6 person = new asartoonianA6("Josh", "Hayden");
       String displayName = person.getDisplayName();
       Assert.assertEquals("Hayden, Josh",person.getDisplayName());

   }
}
