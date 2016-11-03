package page_steps.page_model;

public class Pages {
    
    
    public static HomePage getHomePage() {
        return new HomePage();
    }
    
    public static TopMenu getTopMenu() {return new TopMenu();}
    
    public static ElectronicSearchPanel getElectronicSearchPanel() {
        return new ElectronicSearchPanel();
    }
}
