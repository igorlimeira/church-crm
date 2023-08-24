package br.com.joy.repositories;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.formsobjects.FaithfulRegistrationCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaithfulRepository extends JpaRepository<Faithful, Long> {
    @Query("SELECT new br.com.joy.entities.formsobjects.FaithfulRegistrationCount(u.createdDate, COUNT(u)) " +
            "FROM Faithful u " +
            "WHERE u.createdDate >= CURRENT_DATE - 30 " +
            "GROUP BY u.createdDate")
    List<FaithfulRegistrationCount> findLast30DaysRegistrations();


}
