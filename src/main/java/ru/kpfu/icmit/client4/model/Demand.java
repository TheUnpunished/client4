package ru.kpfu.icmit.client4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.model.soap.Content;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Demand extends Content {
    private Long id;
    private Nomenclature nomenclature;
    private Integer count;
}
