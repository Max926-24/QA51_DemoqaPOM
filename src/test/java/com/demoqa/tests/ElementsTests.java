package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.pages.elements.TextBoxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementsTests extends TestBase {

    SidePanel sidePanel;
    ButtonsPage buttons;
    LinksPage links;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        buttons = new ButtonsPage(driver);
        links = new LinksPage(driver);
        new HomePage(driver).selectElements();

    }

    @Test
    public void doubleClickTest() {
        sidePanel.selectButtons();
        buttons.doubelClick()
                .verifyDoubleclick("double click");
    }

    @Test
    public void rightTest() {
        sidePanel.selectButtons();
        buttons.rightClick()
                .verifyRightClick("right click");
    }

    @Test
    public void jsExecutorTest() {
        sidePanel.selectTextBox();
        new TextBoxPage(driver).enterPersonalData("Jamal Musiala", "jamal@gm.com")
        .clickOnSubmitButton()
        .getInnerText()
                .verifyURL()
                .navigateToNewPage()
                .verifyNewPageTitle();

    }
    @Test
    public void getallLinksTest(){
        sidePanel.selectLinks();
        links.getAllUrl();
    }
    @Test
    public void checkBrockenLinksTest(){
        sidePanel.selectBrockenLinks();
        links.checkBrockenLinks();

    }
    @Test
    public void checkBrokenImkagesTest(){
        sidePanel.selectBrockenLinks();
        links.checkBrockenImages();
    }


    }

