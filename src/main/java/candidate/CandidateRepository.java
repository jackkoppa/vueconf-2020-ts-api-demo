package candidate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@RepositoryRestResource
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    <S extends Candidate> S save(S entity);
    List<Candidate> findByLastName(String lastName);
}