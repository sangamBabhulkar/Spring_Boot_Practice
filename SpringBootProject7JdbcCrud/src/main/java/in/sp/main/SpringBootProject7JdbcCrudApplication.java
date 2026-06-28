package in.sp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import in.sp.dao.UserDao;
import in.sp.entity.User;

@SpringBootApplication
@ComponentScan("in.sp")
public class SpringBootProject7JdbcCrudApplication implements CommandLineRunner{

	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject7JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		//------------insertion-------------------------
		//User user1 = new User("sangam","sangam@gamil.com","male","pune");
//		User user2 = new User("amit","amit@gmail.com","male","pune");
//		boolean status = userDao.insertUser(user2);
//		if(status)
//		{
//			System.out.println("user inserted successfully");
//		}
//		else 
//		{
//			System.out.println("user not inserted successfullly");
//		}
		
		//-------updation-------------
		User user = new User("sangam","sangam@gamil.com","male","delhi");
		boolean status = userDao.updateUser(user);
		if(status)
		{
			System.out.println("updation successfully");
		}
		else
		{
			System.out.println("updation failed");
		}
	}

}
