package com.demoqa.tests;

import com.demoqa.core.BasePage;
import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class WidgetsTests extends TestBase {
    SidePanel sidePanel;
    SelectMenuPage selectMenu;

    @BeforeEach
    public void precondition(){
        sidePanel = new SidePanel(driver);
        selectMenu = new SelectMenuPage(driver);
        new HomePage(driver).selectWidegets();
    }
    @Test
    public void oldStyleSelectMenuTest(){
        sidePanel.getSelectMenu();
        selectMenu.oldStyleSelect("Voilet")
                .verifyColor();

    }
    @Test
    public void multiSelectText(){
        sidePanel.getSelectMenu();
        selectMenu.multiSelect(new String[]{"Green","Red"})
                .verifyMultiSelect(new String[]{"Green","Red"});

    }

    @Test
    public void standartMultiSelectTest(){
        sidePanel.getSelectMenu();
        selectMenu.verifySelectedCar("volvo","rgba(25, 103, 210, 1)");
    }
    @Test
    public void hoverMouseOnMenuTest(){
        sidePanel.getMenu();
        new MenuPage(driver).hoverMouseOnSubMenu()
                .verifySubMenu();

    }
    @Test
    public void SliderTest(){
        sidePanel.selectSlider();
        new SliderPage(driver).moveSliderHorizontalDirection()
               .verifySliderValue("100");


    }
    @Test
    public void toolTipsTest(){
        sidePanel.selectToolTips();
        new ToolTipsPage(driver).hoverOverButton()
                .verifyToolTipsValue("buttonToolTip");

        }
    }



