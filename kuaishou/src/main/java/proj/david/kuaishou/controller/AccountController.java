package proj.david.kuaishou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proj.david.kuaishou.service.AccountService;

import java.util.Map;

@RestController
@RequestMapping("/account803/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("game/user_info")
    public Map<String, Object> getUserInfo(@RequestParam("appId") String appId, @RequestParam("gameId") String gameId, @RequestParam("gameToken") String gameToken){
        return accountService.getAccountInfo(appId, gameId, gameToken);
    }
}
