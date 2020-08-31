package org.wells.models;
//abhishek360

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private int companyId;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String turnover;
    @Column(nullable = false)
    private String ceo;
    private String boardOfDirectors;
    @Column(nullable = false)
    private String writeUp;
    @OneToOne(mappedBy = "company")
    private IPO ipo;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", referencedColumnName = "sector_id")
    @JsonIgnore
    private Sector sector;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StockPrice> stockPrices;

    public List<StockPrice> getStockPrices() {
        return stockPrices;
    }

    public Sector getSector() {
        return sector;
    }

    public IPO getIpo() {
        return ipo;
    }

    public void setIpo(IPO ipo) {
        this.ipo = ipo;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public String getWriteUp() {
        return writeUp;
    }

    public void setWriteUp(String writeUp) {
        this.writeUp = writeUp;
    }
}
