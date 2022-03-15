package utils;

import org.openqa.selenium.By;

public interface LocatorsInterface {
    String url_Interface="http://opencart.abstracta.us/index.php?route=common/home";
    By lSearchInput_Interface=By.cssSelector("input[name='search']");
    By lSearchButton_Interface =By.cssSelector("#search button");
}
