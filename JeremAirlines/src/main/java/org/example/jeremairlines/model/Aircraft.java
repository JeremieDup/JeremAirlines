package org.example.jeremairlines.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aircrafts")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int capacity;

    @Column(name = "type_liaison", nullable = false)
    private String liaisonType;

    @Column(nullable = false)
    private String status;

    @Column(name = "last_maintenance_id")
    private Integer lastMaintenanceId;

    @Column(name = "hours_flown")
    private Double hoursFlown;

    // Constructeur par défaut requis par JPA
    public Aircraft() {
    }

    // Constructeur avec paramètres
    public Aircraft(String brand, String model, int capacity, String liaisonType, String status, int lastMaintenanceId, double hoursFlown) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.liaisonType = liaisonType;
        this.status = status;
        this.lastMaintenanceId = lastMaintenanceId;
        this.hoursFlown = hoursFlown;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLiaisonType() {
        return liaisonType;
    }

    public void setLiaisonType(String liaisonType) {
        this.liaisonType = liaisonType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLastMaintenanceId() {
        return lastMaintenanceId;
    }

    public void setLastMaintenanceId(int lastMaintenanceId) {
        this.lastMaintenanceId = lastMaintenanceId;
    }

    public Double getHoursFlown() {
        return hoursFlown;
    }

    public void setHoursFlown(double hoursFlown) {
        this.hoursFlown = hoursFlown;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", liaisonType='" + liaisonType + '\'' +
                ", status='" + status + '\'' +
                ", lastMaintenanceId=" + lastMaintenanceId +
                ", hoursFlown=" + hoursFlown +
                '}';
    }
}