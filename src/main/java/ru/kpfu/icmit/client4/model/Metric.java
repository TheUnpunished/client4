package ru.kpfu.icmit.client4.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metricIdGenerator")
    @SequenceGenerator(name = "metricIdGenerator", sequenceName = "metric_seq", allocationSize=1)
    private Long id;
    private String code;
    private String metricName;
}
