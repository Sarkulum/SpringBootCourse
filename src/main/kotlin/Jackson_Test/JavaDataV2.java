package Jackson_Test;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class JavaDataV2 {

    public static void main(String[] args) {
        // Create an instance of JavaData
        JavaData data = new JavaData("example_elster2", "http://example.com", "http://example.com/survey");

        // Use JsonUtils to convert to ObjectNode and String
        ObjectNode jsonNode = JsonUtils.toJsonNode(data);
        String jsonString = JsonUtils.toJsonString(data);

        // Print JSON as ObjectNode (formatted)
        System.out.println(jsonNode.toPrettyString());

        // Print JSON as String
        System.out.println(jsonString);
    }
}
