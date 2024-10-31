package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonFormat

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Human {
    @JsonProperty
    String firstName;
    @JsonProperty
    String lastName;
    @JsonProperty
    String label;
    @JsonProperty
     String previousChosen;


}
