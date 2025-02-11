package com.vmware.talentboost.springbootfinaltask.repository;

import com.vmware.talentboost.springbootfinaltask.data.Image;
import com.vmware.talentboost.springbootfinaltask.data.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {
    // Tags findOneByName(String name);
}
