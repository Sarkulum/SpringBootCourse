import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtility {
    static final ObjectMapper objectMapper = new ObjectMapper();

    //Convert object to an ObjectNode
    public static ObjectNode toJsonNode(Object object) {
        return objectMapper.convertValue(object, ObjectNode.class);
    }
}

public static String toJsonString(Object object){
    try {
        return JsonUtility.objectMapper.writeValueAsString(object);
    }catch (JsonProcessingException e) {
        throw new RuntimeException("Faild to convert object to JSON", e);
    }
}