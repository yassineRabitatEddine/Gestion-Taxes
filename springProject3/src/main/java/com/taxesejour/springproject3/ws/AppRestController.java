package com.taxesejour.springproject3.ws;
import com.taxesejour.springproject3.security.entities.AppRole;
import com.taxesejour.springproject3.security.entities.AppUser;
import com.taxesejour.springproject3.security.service.AppService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AppRestController {
    private AppService appService;

    public AppRestController(AppService appService) {
        this.appService = appService;
    }
    @GetMapping("/users")
    private List<AppUser> listAll(){
        return appService.listAll();
    }

    @PostMapping("/users")
    public AppUser addNewAppUser(@RequestBody AppUser appUser) {
        return appService.addNewAppUser(appUser);
    }

    @PostMapping("/roles")
    public AppRole addNewRole(@RequestBody AppRole appRole) {
        return appService.addNewRole(appRole);
    }

    @PostMapping("/addRoleToUser/username/{username}/roleName/{roleName}")
    public void addRoleToUser(@PathVariable String username,@PathVariable String roleName) {
        appService.addRoleToUser(username, roleName);
    }

    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){

    }


}
