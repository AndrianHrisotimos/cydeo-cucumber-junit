package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    public WikiSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //(id = "searchInput")
    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    public WebElement searchButton;

    @FindBy(id = "firstHeading")
    public WebElement mainHeader;
}
