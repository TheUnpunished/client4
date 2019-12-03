package ru.kpfu.icmit.client4.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contract{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractIdGenerator")
    @SequenceGenerator(name = "contractIdGenerator", sequenceName = "contract_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_contract_demand")
    private Demand demand;
    @ManyToOne
    @JoinColumn(name = "fk_contract_offer")
    private Offer offer;
    @ManyToOne
    @JoinColumn(name = "fk_contract_nomenclature")
    private Nomenclature nomenclature;
    @ManyToOne
    @JoinColumn(name = "fk_contract_organization_demanding")
    private Organization demandingOrg;
    @ManyToOne
    @JoinColumn(name = "fk_contract_organization_offering")
    private Organization offeringOrg;
    private Integer totalCount;
    private Double totalPrice;
}
