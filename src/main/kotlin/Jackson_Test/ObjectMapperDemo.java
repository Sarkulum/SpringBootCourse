package Jackson_Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Laptop {
    private String brand;
    private String model;

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

public class ObjectMapperDemo {
    public static void main(String[] args) {
        String json = "{\"brand\":\"Abc\", \"model\":\"XYZ\"}";
        ObjectMapper mapper = new ObjectMapper();
        try{
            Laptop l = mapper.readValue(json, Laptop.class);
            System.out.println(l);
        }catch(JsonMappingException e){
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
