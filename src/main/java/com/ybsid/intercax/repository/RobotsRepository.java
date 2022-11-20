package com.ybsid.intercax.repository;

import com.ybsid.intercax.entity.Robots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RobotsRepository extends JpaRepository<Robots,Integer> {

    @Query(nativeQuery = true , value = "select * from robot where state='designed' and deleted=FALSE")
    List<Robots> getDesigned();

    @Query(nativeQuery = true , value = "select count(*) from robot where state='designed' and deleted=FALSE")
    int getDesignedCount();

    @Query(nativeQuery = true , value = "select * from robot where state='tested' and deleted=FALSE")
    List<Robots> getTested();

    @Query(nativeQuery = true , value = "select count(*) from robot where state='tested' and deleted=FALSE")
    int getTestedCount();

    @Query(nativeQuery = true , value = "select * from robot where state='deployed' and deleted=FALSE")
    List<Robots> getDeployed();

    @Query(nativeQuery = true , value = "select count(*) from robot where state='deployed' and deleted=FALSE")
    int getDeployedCount();

    @Query(nativeQuery = true , value = "update robot set deleted = true where id=?")
    @Transactional
    @Modifying(clearAutomatically = true)
    void markDeletedDesigned(int id);

    @Query(nativeQuery = true,value="select * from robot where deleted=FALSE")
    List<Robots> getAllRobots();
}
