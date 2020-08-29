/*
 * abhishek360
 */

package org.wells.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exchange_id")
    private int exchangeId;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String brief;
    private String remarks;
    @OneToMany(mappedBy = "exchange", fetch = FetchType.EAGER)
    private List<StockPrice> stockPrices;

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
