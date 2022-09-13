package com.walletTest.WalletTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController

@RequestMapping("/wallet")
public class WalletTestController {

	
	@Autowired
	private WalletService walletService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<WalletModel>> getAll() {
	   List<WalletModel> allaccounts = walletService.getAllAccounts();
	   return new ResponseEntity<>(allaccounts,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	
       public ResponseEntity<WalletModel> findAccount(@PathVariable("id") Long id) {
		
		WalletModel WalletAccount = walletService.findById(id);
		return new ResponseEntity<>(WalletAccount, HttpStatus.CREATED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<WalletModel> addWalletAccount(@RequestBody WalletModel walletModel) {
		
		WalletModel newWalletModel = walletService.saveAccount(walletModel);
		return new ResponseEntity<>(newWalletModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/topup/{id}/{amount}")
	public ResponseEntity<?> TopUp(@PathVariable("id") Long id, @PathVariable ("amount") Double amount) {
		
		Template walletModel=	walletService.TopUp(id, amount);
		
		return new ResponseEntity<>( walletModel,HttpStatus.OK);
	}
	
	
	@PostMapping("/topup2/{id}/{amount}")
	public ResponseEntity<?> Update(@PathVariable("id") Long id, @PathVariable ("amount") Double amount) {
		
		Template walletModel=	walletService.TopUp(id, amount);
		
		return new ResponseEntity<>( walletModel,HttpStatus.OK);
	}
	
	@PutMapping("/deduct/{id}/{amount}")
	public ResponseEntity<?> deduction(@PathVariable("id") Long id, @PathVariable ("amount") Double amount) {
		
		Template walletModel=  walletService.Deduction(id, amount);
		return new ResponseEntity<>(walletModel, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteWalletAccount(@PathVariable("id") Long id) {
		
		walletService.deleteAccountById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}

	
	@DeleteMapping("/delete2")
	public ResponseEntity<?> deleteWalletById(@RequestBody  DeleteWalletDto deleteWalletDto) {
		
		walletService.deleteAccountById(deleteWalletDto.getWalletId());
		return new ResponseEntity<>( HttpStatus.OK);
	}

	
	
}
