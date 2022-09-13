package com.walletTest.WalletTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WalletServiceImp implements WalletService {
         @Autowired
	private WalletTestRepo walletTestRepo;

	@Override
	public WalletModel saveAccount(WalletModel walletModel) {
		return  walletTestRepo.save(walletModel);
	}

	@Override
	public Template TopUp(Long id, Double TopUpAmount) {

   WalletModel walletAccount = walletTestRepo.findWalletModelById(id);
   
   walletAccount.balance = walletAccount.balance + TopUpAmount;
   Date date = new Date();
   walletAccount.lastUpdate = new Timestamp(date.getTime());
   
         walletTestRepo.save(walletAccount); 
         
         walletAccount =     walletTestRepo.findUpdatedAccount(id);
       return new Template(walletAccount.id,walletAccount.name, walletAccount.balance);
        
	}

	@Override
	public Template Deduction(Long id, Double deductAmount) {
		// TODO Auto-generated method stub
		
		WalletModel walletAccount = walletTestRepo.findWalletModelById(id);
		   if(walletAccount.balance >= deductAmount ) {
		   walletAccount.balance = walletAccount.balance - deductAmount;
		   Date date = new Date();
		   walletAccount.lastUpdate = new Timestamp(date.getTime());
		        walletTestRepo.save(walletAccount); 	
		   }
		   
		   walletAccount =     walletTestRepo.findUpdatedAccount(id);
	       return new Template(walletAccount.id,walletAccount.name, walletAccount.balance);
		  // return walletTestRepo.findUpdatedAccount(id);
		
	}

	@Override
	public void deleteAccountById(Long id) {
		// TODO Auto-generated method stub
		walletTestRepo.deleteById(id);
	}

	@Override
	public List<WalletModel> getAllAccounts() {
		// TODO Auto-generated method stub
		return walletTestRepo.findAll();
	}

	@Override
	public WalletModel findById(Long Id) {
		// TODO Auto-generated method stub
		return walletTestRepo.findWalletModelById(Id);
	}

	

	
	
}
