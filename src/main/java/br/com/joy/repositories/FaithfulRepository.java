package br.com.joy.repositories;

import br.com.joy.entities.Faithful;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaithfulRepository extends JpaRepository<Faithful, Long> {

    public List<Faithful> findAllByCountry(String country);
}
