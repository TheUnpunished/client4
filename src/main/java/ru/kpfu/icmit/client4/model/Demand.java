package ru.kpfu.icmit.client4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demandIdGenerator")
    @SequenceGenerator(name = "demandIdGenerator", sequenceName = "demand_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_demand_nomenclature")
    private Nomenclature nomenclature;
    private Integer count;
}
