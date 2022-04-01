package com.address.book.addressbookapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Mobile")
public class MobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mobile_id", nullable = false)
    private Long mobileId;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "type")
    private String type;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_Date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "updated_By")
    private String updatedBy;

    @Column(name = "updated_Date")
    @UpdateTimestamp
    private Date updatedDate;



}
