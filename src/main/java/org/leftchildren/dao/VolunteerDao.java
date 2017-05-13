package org.leftchildren.dao;

import org.leftchildren.entity.Volunteer;

/**
 * Created by kay on 2017/5/1.
 */

/**
 * Volunteer的增删查改
 */
public interface VolunteerDao {

    int insertVolunteer(Volunteer volunteer);

    int deleteById(String volunteerId);

    Volunteer queryById(String volunteerId);

    int updateVolunteer(Volunteer volunteer);
}
