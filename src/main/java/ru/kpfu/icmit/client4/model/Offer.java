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
public class Offer{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offerIdGenerator")
    @SequenceGenerator(name = "offerIdGenerator", sequenceName = "offer_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_offer_nomenclature")
    private Nomenclature nomenclature;
    private Double price;
    private Integer count;
}
