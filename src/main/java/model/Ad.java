package model;

public class Ad {
    
    private String header;
    
    public Ad(String header) {
        this.header = header;
        
    }
    
    public String getHeader() {
        return header;
    }
    
    public boolean equals(Ad other) {
        return header.contains(other.getHeader());
    }
}
