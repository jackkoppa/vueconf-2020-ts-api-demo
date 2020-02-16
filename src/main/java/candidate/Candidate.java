package candidate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class Candidate {

    public Candidate(String firstName, String lastName, Party party, String cycle, Double nationalPollingAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.cycle = cycle;
        this.nationalPollingAverage = nationalPollingAverage;
    }

    public Candidate() { 
        this.firstName = "";
        this.lastName = "";
        this.party = Party.INDEPENDENT;
        this.cycle = "";
        this.nationalPollingAverage = 0.0;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private final String firstName;

    private final String lastName;

    private Party party;

    private String cycle;

    private Double nationalPollingAverage;
}