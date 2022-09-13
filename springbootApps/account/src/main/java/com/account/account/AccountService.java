package com.account.account;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface AccountService {
	
	Account saveAccount(Account account);
	Account Update(Long id, Account account);
	Account UpdateName(Long id, String name);
	void delete(Long id);
	List<Account> getAllAccounts();
	Account findById(Long Id);
	List<Account> addMultipleAccounts(List<Account> accounts);
	
	//String uploadImage(MultipartFile file);
	String getImageBase64(String path) throws IOException;
}
