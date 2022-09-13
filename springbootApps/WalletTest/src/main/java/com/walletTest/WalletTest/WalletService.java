package com.walletTest.WalletTest;

import java.util.List;

public interface WalletService {
     
	WalletModel saveAccount(WalletModel walletModel);
	Template TopUp(Long id,Double TopUpAmount);
	Template Deduction(Long id, Double deductAmount);
	void deleteAccountById(Long id);
	List<WalletModel> getAllAccounts();
	
	WalletModel findById(Long Id);
	
	
}
