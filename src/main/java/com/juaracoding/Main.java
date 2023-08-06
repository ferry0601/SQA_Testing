package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Tools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        //JavascriptExecutor jse = (JavascriptExecutor) driver;// scroll
        //jse.executeScript("window.scrollBy(0,1500","");
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Browsing It");

        //username
        WebElement alamatUser = driver.findElement(By.xpath("//div[@class='u-column1 col-1']"));
        WebElement userLog = alamatUser.findElement(By.id("username"));
        userLog.sendKeys("ferry0601");

        //password
        WebElement alamatPass = driver.findElement(By.xpath("//div[@class='u-column1 col-1']"));
        WebElement passLog = alamatPass.findElement(By.id("password"));
        passLog.sendKeys("ferryFfly0601");

        driver.findElement(By.name("login")).click();

        String userName = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]")).getText();
        System.out.println(userName);

        driver.findElement(By.xpath("//a[@href='https://shop.demoqa.com']")).click();
        System.out.println("Click Shopping");

        //choose outfit
        WebElement outfitSatu = driver.findElement(By.xpath("//div[@class='wpb_wrapper']"));
        WebElement outfitDua = outfitSatu.findElement(By.xpath("//div[@class='noo-sh-product-grid woocommerce ']"));
        WebElement outfitTiga = outfitDua.findElement(By.xpath("//div[@class='noo-sh-product-html columns_3 no_masonry three row is-flex']"));
        WebElement outfitTerpilih = outfitTiga.findElement(By.xpath(".//div[@class='noo-product-item noo-product-sm-4 not_featured post-1485 product type-product status-publish has-post-thumbnail product_cat-t-shirt product_tag-t-shirt product_tag-women has-featured last instock shipping-taxable purchasable product-type-variable']"));
        outfitTerpilih.click();
        System.out.println("Choosing Outfit");

        //Choose Color
        WebElement colorPath = driver.findElement(By.xpath("//select[@id='pa_color']"));
        WebElement colorChoose = colorPath.findElement(By.xpath(".//option[@value='black']"));
        colorChoose.click();
        System.out.println("Choosing color outift");

        //Choose size
        WebElement sizeSatu = driver.findElement(By.xpath("//select[@id='pa_size']"));
        WebElement sizeOutfit = sizeSatu.findElement(By.xpath(".//option[@value='34']"));
        sizeOutfit.click();
        System.out.println("Choosing size...");

        //Add Chart
        WebElement chartClass = driver.findElement(By.xpath("//div[@class='quantity']"));
        WebElement buttonChart = chartClass.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt wp-element-button']"));
        buttonChart.click();
        System.out.println("Button Add Chart Sukses");

        //Scraping
        String scraping = driver.findElement(By.cssSelector("div[role='alert']")).getText();
        System.out.println(scraping);

        //View
        driver.findElement(By.xpath("//a[@class='button wc-forward wp-element-button']")).click();
        System.out.println("Successfully View");

        //assert
        if(userName.equals("ferry0601")){
            System.out.println("Login Successfully");
        }else {
            System.out.println("Login Invalid");
        }

        if(scraping.contains("black lux graphic t-shirt” has been added to your cart.")){
            System.out.println("Product Added");
        }else {
            System.out.println("Product Invalid Added");
        }

        //Back Shopping
        //WebElement backPath = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart']"));
        //WebElement backShop = backPath.findElement(By.xpath("//a[@href='https://shop.demoqa.com/shop/']"));
        //backShop.click();
        //System.out.println("Shopping Again");

        timeDelay();
        driver.quit();
        System.out.println("Quit Shopping");
    }
    public static void timeDelay() {
        try {
            Thread.sleep(80000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}