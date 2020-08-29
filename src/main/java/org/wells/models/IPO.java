package org.wells.models;
//abhishek360

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class IPO {
    @Id
    private int ipoId;
    @Column(nullable = false)
    private float pricePerShare;
    @Column(nullable = false)
    private String numOfShares;
    @Column(nullable = false)
    private java.sql.Timestamp openDate;
    private String remarks;
    @OneToOne(optional = false)
    @JoinColumn(name = "ipo_id", referencedColumnName = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public float getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(float pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public int getIpoId() {
        return ipoId;
    }

    public void setIpoId(int ipoId) {
        this.ipoId = ipoId;
    }

    public String getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(String numOfShares) {
        this.numOfShares = numOfShares;
    }

    public Timestamp getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Timestamp openDate) {
        this.openDate = openDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
