/*
 * Copyright 2018 rolhai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.racemanager.api.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drivers")
@NamedQueries({
    @NamedQuery(name = Driver.FIND_ALL, query = "SELECT d FROM Driver d LEFT JOIN FETCH d.country")
    ,
    @NamedQuery(name = Driver.COUNT_RESULTS, query = "SELECT COUNT(d) FROM Driver d")
    ,
    @NamedQuery(name = Driver.FIND_BY_LASTNAME, query = "SELECT d FROM Driver d LEFT JOIN FETCH d.country WHERE d.lastname = :lastname")
})
public class Driver extends ApiEntity {

    public static final String FIND_ALL = "Driver.findAll";

    public static final String COUNT_RESULTS = "Driver.countResults";

    public static final String FIND_BY_LASTNAME = "Driver.findByLastname";

    /**
     * unique
     */
    @NotNull
    @Size(min = 2, max = 100)
    private String firstname;

    /**
     * unique
     */
    @NotNull
    @Size(min = 2, max = 100)
    private String lastname;

    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "countryId")
    @NotNull
    private Country country;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.firstname);
        hash = 13 * hash + Objects.hashCode(this.lastname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Driver other = (Driver) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Driver{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", country=" + country + '}';
    }
}
