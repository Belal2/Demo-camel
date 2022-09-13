package com.account.account;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;




@Service
public class AccountServiceImp implements AccountService{
	 @Autowired
	 AccountRepo accountRepo;

	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		Date date = new Date();
		account.createdOn = new Timestamp(date.getTime());
		account.isDeleted = false;
		return accountRepo.save(account) ;
	}

	@Override
	public Account Update(Long id, Account account) {
		
		Account accountToUpdate = accountRepo.findAccountById(id);
		accountToUpdate.name = account.name; 
		Date date = new Date();
		accountToUpdate.updatedOn = new Timestamp(date.getTime());
    
		return accountRepo.save(accountToUpdate);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepo.findAccountById(id);
		account.isDeleted = true;
		accountRepo.save(account);	
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}

	@Override
	public Account findById(Long Id) {
		// TODO Auto-generated method stub
		return accountRepo.findAccountById(Id);
	}

	@Override
	public List<Account> addMultipleAccounts(List<Account> accounts) {
		List<Account> accountsList= new ArrayList<>();
		for(int i=0 ; i<accounts.size() ; i++) {
			Date date = new Date();
			accounts.get(i).createdOn = new Timestamp(date.getTime());
			accounts.get(i).isDeleted = false;
		   
			accountsList.add(accountRepo.save(accounts.get(i))) ;
			
		}
		return accountsList;
	}



	@Override
	public String getImageBase64(String path) throws IOException {
		String encoded = null;
		byte[] fileContent = null;
		File file = new File(path);
		try {
			

			 fileContent = Files.readAllBytes(file.toPath());
	
			 encoded = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
			
		} catch (Exception e) {
			
			throw new IOException();
		}
		
		return encoded;
	}

	@Override
	public Account UpdateName(Long id, String name) {
		Account accountToUpdate = accountRepo.findAccountById(id);
		accountToUpdate.name = name; 
		Date date = new Date();
		accountToUpdate.updatedOn = new Timestamp(date.getTime());
		
		return accountRepo.save(accountToUpdate);
		
		
	}

	

	
}
