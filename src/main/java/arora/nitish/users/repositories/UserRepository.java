package arora.nitish.users.repositories;

import org.springframework.data.repository.CrudRepository;

import arora.nitish.users.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
