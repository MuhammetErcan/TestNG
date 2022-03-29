package gun12.pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindAllPO {

    public FindAllPO(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "input[name='search']")
    private WebElement searchText;

    @FindBy (css = "#search button")
    private WebElement searchButton;

    @FindBy(css = ".caption h4")
    List<WebElement>product;

    @FindBy(css = "ul.breadcrumb")
    private WebElement siteMap;



    @FindAll({
            @FindBy(css = "div[id='content'] h1"),
            @FindBy(css=".caption h4"),
            @FindBy(css = "div.caption p.price")
    })
    private List<WebElement> isimVeFiyat;

    @FindBys({
            @FindBy(xpath="(//div[@class='product-thumb'])[1]"),
            @FindBy(css = "h4")
    })
    WebElement findBys;

    public WebElement getFindBys() {
        return findBys;
    }


    public List<WebElement> getIsimVeFiyat() {
        return isimVeFiyat;
    }

    public List<WebElement> getProduct() {
        return product;
    }

    public WebElement getSiteMap() {
        return siteMap;
    }

    public WebElement getSearchText() {
        return searchText;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
