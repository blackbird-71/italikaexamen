package mx.italika.exam.italikaexam.repositories;

import mx.italika.exam.italikaexam.entites.PartnerEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface PartnerRepository extends CrudRepository<PartnerEntity, BigInteger> {

    Optional<PartnerEntity>findByClientId(String clientId);
}