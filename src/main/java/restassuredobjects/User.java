package restassuredobjects;
//3a ObjectMappingDemo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public String login;
    public int id;
    public int publicRepos;


    @JsonProperty("public_repos")
    public int getPublicRepos() {
        return publicRepos;
    }

    public String getLogin() {
        return login;
    }


    public int getId() {
        return id;
    }
}
