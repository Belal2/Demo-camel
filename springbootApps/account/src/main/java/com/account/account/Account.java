package com.account.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="account")
public class Account {
         @Id @GeneratedValue(strategy = GenerationType.AUTO)
	     Long id;
   
	     String name;
	
	    @Column(name="date_of_birth")
	    @Temporal(TemporalType.TIMESTAMP)
	     Date dateOfBirth;
	    
	   
	    @Column(name="created_on")
	    @Temporal(TemporalType.TIMESTAMP)
	     Date createdOn;

	    @Column(name="updated_on")
	    @Temporal(TemporalType.TIMESTAMP)
	     Date updatedOn;

	    
         boolean isDeleted=false;	 
         
         String filePath;
         String imageBase;
        
	
}
