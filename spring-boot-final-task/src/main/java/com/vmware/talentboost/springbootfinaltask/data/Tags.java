package com.vmware.talentboost.springbootfinaltask.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "labels")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column( name = "label", nullable = false, updatable = false)
    private String label;

    @Column( name = "confidence")
    private Double confidence;

    @ManyToMany(mappedBy = "labels")
    private List<Image> images;

    public Tags() {
        this.images = new ArrayList<>();
    }

    public Tags(String label, double confidence) {
        this.label = label;
        this.confidence = confidence;
    }

    public Tags(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
