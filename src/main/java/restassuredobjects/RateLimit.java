package restassuredobjects;
//3a NestedObjectMapping

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {

    private int coreLimit;
    private int searchLimit;

    @JsonProperty("resources")
    /*в resources има няколко обекта - искаме core и search, а от тях искаме limit и limit,
    вместо да пишем resources.core.limit ; resources.search.limit

    метод за конвертиране
    Json format : key String = value Whatever(String, int, Object)
    Object e родителски вграден клас в Java, всички останали класове го унаследяват*/
    public void unmarshallResources(Map<String, Object> resources) {

        //преобразуване/cast : всичко в елемента/гнездото ''core'' ще се конвертира и запази в променлива core
        var core = (Map<String , Integer>) resources.get("core");
        coreLimit = core.get("limit");

        var search = (Map<String , Integer>) resources.get("search");
        searchLimit = search.get("limit");
    }

    public int getCoreLimit() {
        return coreLimit;
    }

    public int getSearchLimit() {
        return searchLimit;
    }

}
