package com.lms.notification.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "defaulter")
public class Defaulter {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "defaulter_id")
    private Long defaulterId;

    private String dueDate;
    private int daysOverDue;
    private double fineAmount;

    // One-to-Many relationship with Notification
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notification> notifications;

    // Getters and Setters
    public Long getDefaulterId() {
        return defaulterId;
    }

    public void setDefaulterId(Long defaulterId) {
        this.defaulterId = defaulterId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getDaysOverDue() {
        return daysOverDue;
    }

    public void setDaysOverDue(int daysOverDue) {
        this.daysOverDue = daysOverDue;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
