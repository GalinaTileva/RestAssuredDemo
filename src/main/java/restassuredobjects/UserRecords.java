package restassuredobjects;
//3a ObjectMappingDemo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserRecords(
        // по подразбиране всички променливи са public
        @JsonProperty("public_repos")
                int publicRepos,
        String login,
        int id
) {

    //Record има вградени getter, setter , cons. Ползва се за прости обекти, които съдържат само пропертита..

}
