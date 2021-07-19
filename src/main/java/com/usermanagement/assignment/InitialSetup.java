package com.user.mngmnt;

import com.user.mngmnt.model.RoleNames;
import com.user.mngmnt.model.User;
import com.user.mngmnt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialSetup {

    @Autowired
    private UserService userService;
	
	@Value("${admin.user.name}")
    private String userName;
	
	@Value("${admin.password}")
    private String password;
	
	@Value("${admin.email.address}")
    private String emailAddress;

    @Value("${admin.first.name}")
    private String firstName;

    @Value("${admin.last.name}")
    private String lastName;
	
	@Value("${admin.dob}")
    private Date dob;



    @PostConstruct
    public void initIt() throws Exception {

        User dbUser = userService.findUserByEmail(emailAddress);

        if (dbUser == null) {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(emailAddress);
            user.setFirstName(firstName);
            user.setLastName(lastName);
			user.setRoleName(RoleNames.ADMIN.name());
            user.setDob(dob);
            userService.saveUser(user);
        }
        loadUsers();
    }



    private void loadUsers() {
        User user1 = new User("johndoe", "doe@123",
                "john@doe.com", "John","Doe", RoleNames.ADMIN.name(), 1960-02-11);
        userService.saveUser(user1);

        User user2 = new User("smithguard", "guard@123",
                "smith@gmail.com", "Smith","Guard", RoleNames.ADMIN.name(), 1962-03-12);
        userService.saveUser(user2);

        User user3 = new User("lannisterjammy", "jammy@123",
                "jammy@gmail.com", "123456", RoleNames.ADMIN.name(), 1963-04-13);
        userService.saveUser(user3);

        User user4 = new User("starkarya", "arya@123",
                "arya@gmail.com", "Stark","Arya", RoleNames.ADMIN.name(), 1964-05-14);
        userService.saveUser(user4);

        User user5 = new User("boltonramsay", "ramsay@123",
                "ramsay@gmail.com", "Boltan","Ramsay", RoleNames.ADMIN.name(), 1965-06-15);
        userService.saveUser(user5);

        User user6 = new User("clarkegibbins", "gibbins@123",
                "clarke@gmail.com", "Clarke","Gibbins", RoleNames.ADMIN.name(), 1966-07-16);
        userService.saveUser(user6);

        User user7 = new User("bobmarley", "marley@123",
                "Bob@doe.com", "Bob","Marley", RoleNames.ADMIN.name(), 1967-08-17);
        userService.saveUser(user7);

        User user8 = new User("octaviasmith", "smith@123",
                "octavia@gmail.com", "Octavia","Smith", RoleNames.ADMIN.name(), 1968-09-18);
        userService.saveUser(user8);

        User user9 = new User("kanewilliam", "william@123",
                "Kane@gmail.com", "Kane","William", RoleNames.ADMIN.name(), 1969-10-19);
        userService.saveUser(user9);

        User user10 = new User("jonsnow", "snow@123",
                "jonsnow@gmail.com", "William","Snow", RoleNames.ADMIN.name(), 1970-11-12);
        userService.saveUser(user10);
    }
}