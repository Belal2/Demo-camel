package com.walletTest.WalletTest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="account_wallet_info")
public class WalletModel {
	
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		Long id;
		String name;
		Double balance;
		
	    @Column(name="date_of_birth")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date dateOfBirth;
	    
	   
	    @Column(name="last_update")
	    @Temporal(TemporalType.TIMESTAMP)
	     Date lastUpdate;

	


}
