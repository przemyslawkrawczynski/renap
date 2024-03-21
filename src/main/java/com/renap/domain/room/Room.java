package com.renap.domain.room;

import com.renap.domain.offer.Offer;
import com.renap.domain.offer.ServiceOffer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;
    @ManyToOne
    private Floor floor;
    private Integer height;
    private Integer width;
    private Integer length;
    @OneToMany
    private Set<ServiceOffer> services = new HashSet<>();
    @ManyToOne
    private Offer offer;
}