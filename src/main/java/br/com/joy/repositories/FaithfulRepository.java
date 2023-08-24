package br.com.joy.repositories;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.FaithfulDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FaithfulRepository extends JpaRepository<Faithful, Long> {

    List<Faithful> findAllByCountry(String country);

    List<Faithful> findAllByCountryAndOriginCity(String country, String city);

    List<FaithfulDTO> findAllByCreatedDate(LocalDateTime localDateTime);
}
