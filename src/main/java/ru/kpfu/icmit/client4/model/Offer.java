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
@Entity
public class Offer extends Content {
    private Long id;
    private Nomenclature nomenclature;
    private Double price;
    private Integer count;
}
