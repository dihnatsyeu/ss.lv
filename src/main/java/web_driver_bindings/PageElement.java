package web_driver_bindings;

import org.openqa.selenium.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PageElement implements WebElement {
    
    private WebElement element;
    
    public PageElement(WebElement element) {
        this.element = element;
    }
    
    private String getUTF8String(String text) {
        return new String(text.getBytes(Charset.forName("utf-8")));
    }
    
    
    @Override
    public void click() {
        element.click();
    }
    
    @Override
    public void submit() {
        element.submit();
    }
    
    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }
    
    @Override
    public void clear() {
        element.clear();
    }
    
    @Override
    public String getTagName() {
        return getUTF8String(element.getTagName());
    }
    
    @Override
    public String getAttribute(String s) {
        return getUTF8String(element.getAttribute(s));
    }
    
    @Override
    public boolean isSelected() {
        return false;
    }
    
    @Override
    public boolean isEnabled() {
        return false;
    }
    
    @Override
    public String getText() {
        return getUTF8String(element.getText());
    }
    
    @Override
    public List<WebElement> findElements(By by) {
        return fromWebElementsToPageElements(element.findElements(by));
    }
    
    @Override
    public WebElement findElement(By by) {
        return new PageElement(element.findElement(by));
    }
    
    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
    
    @Override
    public Point getLocation() {
        return element.getLocation();
    }
    
    @Override
    public Dimension getSize() {
        return element.getSize();
    }
    
    @Override
    public Rectangle getRect() {
        return element.getRect();
    }
    
    @Override
    public String getCssValue(String s) {
        return getUTF8String(element.getCssValue(s));
    }
    
    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return element.getScreenshotAs(outputType);
    }
    
    
    static List<WebElement> fromWebElementsToPageElements(List<WebElement> webElements) {
        List<WebElement> pageElements = new ArrayList<>();
        webElements.forEach(webElement -> pageElements.add(new PageElement(webElement)));
        return pageElements;
    }
}
