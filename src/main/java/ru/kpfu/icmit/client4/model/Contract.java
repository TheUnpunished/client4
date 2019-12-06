package ru.kpfu.icmit.client4.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.model.soap.Content;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract extends Content {
    private Long id;
    private Demand demand;
    private Offer offer;
    private Nomenclature nomenclature;
    private Organization demandingOrg;
    private Organization offeringOrg;
    private Integer totalCount;
    private Double totalPrice;
}
