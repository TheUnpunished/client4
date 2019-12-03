package ru.kpfu.icmit.client4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.model.soap.Content;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationIdGenerator")
    @SequenceGenerator(name = "organizationIdGenerator", sequenceName = "organization_seq", allocationSize=1)
    private Long id;
    private String name;
}
