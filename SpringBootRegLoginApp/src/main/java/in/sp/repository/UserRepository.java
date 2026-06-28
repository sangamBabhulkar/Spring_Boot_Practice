package in.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	
}
