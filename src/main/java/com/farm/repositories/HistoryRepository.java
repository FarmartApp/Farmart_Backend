
package com.farm.repositories;

import com.farm.entities.History;
import com.farm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

	/**
	 * @param email
	 * @return
	 */


	/**

	 * @return
	 */




	User getOneByIdAndDeletedAtNull(Integer id);

	@Query(value = "UPDATE users SET  token=null  WHERE id=:id" , nativeQuery = true)
	@Modifying
    @Transactional
	void deleteToken(Integer id);
	@Query(value = "SELECT * from  histories h where " +
			"p.deleted_at is null" +
			"and(:buyid is null or(:buyid = h.buyer_id))" +
			"and(:sellid is null or(:sellid = h.seller_id)", nativeQuery = true)
	List<History> findFilterhis(Integer buyid,Integer sellid);


	


}
