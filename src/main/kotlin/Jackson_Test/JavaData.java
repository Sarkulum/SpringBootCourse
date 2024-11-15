package Jackson_Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JavaData {
    private String elster2;
    private String url;
    private String surveyLink;

    // Constructor for easy initialization
    public JavaData(String elster2, String url, String surveyLink) {
        this.elster2 = elster2;
        this.url = url;
        this.surveyLink = surveyLink;
    }

    // Optional: Add getters if needed
    public String getElster2() {
        return elster2;
    }

    public String getUrl() {
        return url;
    }

    public String getSurveyLink() {
        return surveyLink;
    }
}
