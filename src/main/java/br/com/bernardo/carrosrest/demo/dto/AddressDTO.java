package br.com.bernardo.carrosrest.demo.dto;

public class AddressDTO {
    private Long id;
    private String street;
    private String complement;
    private String neighborhood;
    private String location;
    private String state;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getComplement() { return complement; }
    public void setComplement(String complement) { this.complement = complement; }

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
