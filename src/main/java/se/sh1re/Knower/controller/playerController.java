package se.sh1re.Knower.controller;

import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import se.sh1re.Knower.Driver.Safari;
import se.sh1re.Knower.models.Player;
import se.sh1re.Knower.service.PlayerService;

import java.util.concurrent.TimeUnit;
@Controller
public class playerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private Player player;
    @Autowired
    private Safari safari;

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;




}
