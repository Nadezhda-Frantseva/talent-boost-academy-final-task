package com.vmware.talentboost.springbootfinaltask.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "url", unique = true, nullable = false, updatable = false)
    private String url;

    @Column(name = "formattedDate")
    private String formattedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private TypeService service;

    @Column(name = "width")
    double width;

    @Column(name = "height")
    double height;

    @ManyToMany
    @JoinTable(name = "images_tags",
            joinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tags> labels;

    public Image() {
        this.labels = new ArrayList<>();
    }

    public Image(String url, TypeService service, double width,  double height, List<Tags> tags) {
        this.url = url;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.formattedDate = myDateObj.format(myFormatObj);
        this.service = service;
        this.width = width;
        this.height = height;
        this.labels = tags;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public TypeService getService() {
        return service;
    }

    public void setService(TypeService service) {
        this.service = service;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Tags> getLabels(){
        return labels;
    }

    public void setLabels(List<Tags> labels) {
        this.labels = labels;
    }


    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", formattedDate='" + formattedDate + '\'' +
                ", service=" + service +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
    public void print() {
        for (Tags tag : this.labels) {
            System.out.println(tag.getLabel());
            System.out.println(tag.getConfidence());
        }
    }
}

