/*
 * abhishek360
 */

package org.wells.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sector_id")
    private int sectorId;
    @Column(nullable = false)
    private String sectorName;
    private String brief;
    @OneToMany(mappedBy = "sector", fetch = FetchType.LAZY)
    private List<Company> companies;

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
