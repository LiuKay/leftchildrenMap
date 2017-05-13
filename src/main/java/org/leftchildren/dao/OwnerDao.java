package org.leftchildren.dao;

/**
 * Created by kay on 2017/5/1.
 */

import org.leftchildren.entity.Owner;

/**
 * Owner的增删查改
 */
public interface OwnerDao {
    int insertOwner(Owner owner);

    int deleteById(String ownerId);

    Owner queryById(String ownerId);

    int updateOwner(Owner owner);

}
