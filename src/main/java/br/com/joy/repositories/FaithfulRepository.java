package br.com.joy.repositories;

import br.com.joy.entities.Faithful;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaithfulRepository extends JpaRepository<Faithful, Long> {
}
