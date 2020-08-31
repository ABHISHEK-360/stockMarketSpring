/*
 * abhishek360
 */

package org.wells.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stockId;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Time time;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @JsonIgnore
    private Company company;
    @ManyToOne
    @JoinColumn(name = "exchange_id", referencedColumnName = "exchange_id")
    @JsonIgnore
    private Exchange exchange;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}
