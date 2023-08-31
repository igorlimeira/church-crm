package br.com.joy.repositories;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.CountryDTO;
import br.com.joy.entities.dtos.FaithfulDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FaithfulRepository extends JpaRepository<Faithful, Long> {

    List<Faithful> findAllByCountry(String country);

    List<Faithful> findAllByCountryAndOriginCity(String country, String city);

    List<FaithfulDTO> findAllByCreatedDate(LocalDateTime localDateTime);


    @Query("SELECT new br.com.joy.entities.dtos.CountryDTO(f.country, COUNT(f.id)) FROM Faithful f GROUP BY f.country")
    List<CountryDTO> countByCountry();
}
