package uy.com.bbva.services.template.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",

})
public class Training {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("program")
    private String program;
    @JsonProperty("points")
    private Integer points;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(final String name) {
        this.name = name;
    }
    @JsonProperty("program")
    public String getProgram() {
        return program;
    }

    @JsonProperty("program")
    public void setProgram(final String program) {
        this.program = program;
    }
    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }
    @JsonProperty("points")
    public void setPoints(final Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
