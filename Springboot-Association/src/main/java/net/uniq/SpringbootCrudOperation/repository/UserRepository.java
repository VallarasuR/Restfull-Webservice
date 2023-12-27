package net.uniq.SpringbootCrudOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.uniq.SpringbootCrudOperation.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
