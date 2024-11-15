package Jackson_Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//JAVA to JSon

public class App {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        FootballPlayer footballPlayer = new FootballPlayer("Joe", 10);
        String jsonString = mapper.writeValueAsString(footballPlayer);

                //File names of the object (name, number) become the Json keys
        System.out.println(jsonString); //Out should be {"name":"Joe", "number":10}
    }
}

class FootballPlayer{
    //Jackson rule: field needs to be public
    //or they need public getter/setter
    public String name;
    public int nummber;

    public FootballPlayer(String name, int nummber) {
        this.name = name;
        this.nummber = nummber;
    }
}
