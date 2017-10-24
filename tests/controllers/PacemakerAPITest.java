package controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.PacemakerAPI;
import models.User;

import static models.Fixtures.users;
import static models.Fixtures.activities;
import static models.Fixtures.locations;

public class PacemakerAPITest
{
  private PacemakerAPI pacemaker;

  @Before
  public void setup()
  {
    pacemaker = new PacemakerAPI(null);
  }

  @After
  public void tearDown()
  {
    pacemaker = null;
  }
  
  @Test
  public void testUser()
  {
    User homer = new User ("homer", "simpson", "homer@simpson.com",  "secret");

    assertEquals (0, pacemaker.getUsers().size());
    pacemaker.createUser("homer", "simpson", "homer@simpson.com", "secret");
    assertEquals (1, pacemaker.getUsers().size());
    
    assertEquals (homer, pacemaker.getUserByEmail("homer@simpson.com"));
  }
  
}
