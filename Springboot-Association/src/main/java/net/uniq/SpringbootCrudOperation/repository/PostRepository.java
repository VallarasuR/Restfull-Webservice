package net.uniq.SpringbootCrudOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.uniq.SpringbootCrudOperation.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
