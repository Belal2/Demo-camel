package com.walletTest.WalletTest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTestRepo extends JpaRepository<WalletModel, Long> {

	void deleteWalletModelById(Long id);

	WalletModel findWalletModelById(Long id);

	@Query(value = "select x  from WalletModel x where x.id = ?1")
	WalletModel findUpdatedAccount(@Param("id") Long id);

}



