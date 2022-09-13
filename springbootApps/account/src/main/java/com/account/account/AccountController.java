package com.account.account;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/all")
	public ResponseEntity<List<Account>> getAll() throws IOException {
		List<Account> allaccounts = accountService.getAllAccounts();

		return new ResponseEntity<>(allaccounts, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")

	public ResponseEntity<Account> findAccount(@PathVariable("id") Long id) {

		Account account = accountService.findById(id);
		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}

	@PostMapping("/add")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) throws IOException {
		Account newAccount = accountService.saveAccount(account);
		// newAccount.setImageBase(accountService.getImageBase64(account.filePath));

		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}

	@PostMapping("/addaccounts")
	public ResponseEntity<List<Account>> addAccounts(@RequestBody List<Account> accounts) {

		List<Account> newAccounts = accountService.addMultipleAccounts(accounts);
		return new ResponseEntity<>(newAccounts, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Account account) {

		Account updateAccount = accountService.Update(account.getId(), account);

		return new ResponseEntity<>(updateAccount, HttpStatus.OK);

	}

	@PostMapping("/update/{id}/{name}")
	public ResponseEntity<?> updateName(@PathVariable("id") Long id, @PathVariable("name") String name) {

		Account updateAccount = accountService.UpdateName(id, name);

		return new ResponseEntity<>(updateAccount, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {

		accountService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete2")
	public ResponseEntity<?> deleteAccountById(@RequestBody DeleteDto  deleteDto) {

		accountService.delete(deleteDto.getAccountId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/uploadfile/{id}")
	public Account uploadfile(@PathVariable("id") Long id, @RequestParam("imageFile") MultipartFile file)
			throws IOException {
		String imageAsString = "";
		byte[] imageArr = file.getBytes();
		if (file.getContentType().contains("pdf")) {
			imageAsString = "data:application/pdf;base64," + Base64.encodeBase64String(imageArr);
		} else if (file.getContentType().contains("png")) {
			imageAsString = "data:image/png;base64," + Base64.encodeBase64String(imageArr);
		}

		else if (file.getContentType().contains("jpg")) {
			imageAsString = "data:image/jpg;base64," + Base64.encodeBase64String(imageArr);
		}
		Account account = accountService.findById(id);
		account.imageBase = imageAsString;
		accountService.saveAccount(account);
		// Path root = Paths.get("C:\\Users\\ZeinabAhmed\\Desktop\\testl");
		// Files.createDirectory(root);
		// Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
		// System.err.println(file.getContentType().contains("pdf"));
		// byte[] data = Base64.decodeBase64(imageAsString);
		// try (OutputStream stream = new
		// FileOutputStream("C:\\Users\\ZeinabAhmed\\Desktop\\test2.")) {
		// stream.write(data);
		// }
		return account;
	}

}
