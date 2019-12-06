package ru.kpfu.icmit.client4.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.model.soap.Content;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Metric extends Content {
    private Long id;
    private String code;
    private String metricName;
}
