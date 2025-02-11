package com.vmware.talentboost.springbootfinaltask.repository;

import com.vmware.talentboost.springbootfinaltask.data.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findOneByUrl(String url);
    Optional<Image> findById(final int id);
    List<Image> findAll();
}
