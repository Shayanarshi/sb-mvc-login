package in.ashokit.service;

import in.ashokit.model.Login;
import in.ashokit.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public  boolean authenticate(String username, String password){

        Login login = repository.findById(username).orElse(null);
        if (login !=null){
            if (login.getPassword().equals(password))
                return  true;
            else
                return false;
        }
        return false;

    }
}
