package com.test.nhs.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DashboardPage {

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //==============================  elements =============================================


    @FindBy(css = ".panel-heading") // if not working use //div[@class='panel-heading']//div[@class='row']
    List<WebElement> allCards;
    //font-size: 14px; same for image and text, but not numbers

    @FindBy(css = ".huge")
    List<WebElement> allCardsNumbers;

    @FindBy(xpath = "//div[@class='huge']/following-sibling::div")
    List<WebElement> allCardTitles;


    //==============================  methods =============================================

    public void cardSizeInfo(int indexOfTheCard) {
        WebElement card = allCards.get(indexOfTheCard);
        System.out.println("location: " + card.getLocation());
        System.out.println("size: " + card.getSize());
        Point location = card.getLocation();
        System.out.println("Location of X :" + location.getX() + "," + "Location of Y :" + location.getY());
    }

    public boolean cardsHaveSameY() {
        //set doesn't allow duplicates => if y from all elements is the same our set should have size 1
        Set<Integer> allY = new HashSet<Integer>();
        for (int i = 0; i < allCards.size(); i++) {
            WebElement card = allCards.get(i);
            //get the value of y for each element
            int y = card.getLocation().getY();
            //add the value of y to the hashset
            allY.add(y);
        }
        //if hashset size=1 => all elements have same y => elements are on the same horizontal line
        if (allY.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean cardsHaveSameDimensions() {
        Set<Integer> allHeight = new HashSet<Integer>();
        Set<Integer> allWidth = new HashSet<Integer>();
        for (int i = 0; i < allCards.size(); i++) {
            WebElement card = allCards.get(i);
            int height = card.getSize().getHeight();
            int width = card.getSize().getWidth();
            allHeight.add(height);
            allWidth.add(width);

            if (allHeight.size() == 1 && allWidth.size() == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer numberOfCards(){
        return allCards .size();
    }

    public List<String> getCardNumbersText() {
        List<String> cardsNumbersText = new ArrayList<>();
        for (int i = 0; i < allCardsNumbers.size(); i++) {
            WebElement card = allCardsNumbers.get(i);
            cardsNumbersText.add(card.getText().trim());
        }
        return cardsNumbersText;
    }


    public boolean cardNumberIsNumeric() {
        List<String> allNumbers = getCardNumbersText();
        for (String number : allNumbers) {
            if (StringUtils.isNumeric(number)) {
                return true;
            }
        }
        return false;
    }


    public List<String> getAllActualCardTitle() {
        List<String> cardsTitleText = new ArrayList<>();
        for (int i = 0; i < allCardTitles.size(); i++) {
            WebElement card = allCardTitles.get(i);
            cardsTitleText.add(card.getText().trim());
        }
        return cardsTitleText;
    }

    public String getActualCardTitle (int index){
        return getAllActualCardTitle().get(index);
    }




}
