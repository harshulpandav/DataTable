package fsu.cimes.contacts.jpa;

/**
 *
 * @author hpandav
 */
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fsu.cimes.contacts.model.Contacts;
import fsu.cimes.contacts.model.GetPrintLabelV;
import fsu.cimes.contacts.model.GroupSelections;
import fsu.cimes.contacts.model.MailingHistoryContacts;
import fsu.cimes.contacts.model.MailingHistoryOverall;
import fsu.cimes.contacts.model.MailingHistoryPositionCodes;
import fsu.cimes.contacts.model.MaterialSelections;
import fsu.cimes.contacts.model.MaterialsAvailable;
import fsu.cimes.contacts.model.PositionCodeCountV;
import fsu.cimes.contacts.model.PositionCodes;

@Service
public class TransactionService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<PositionCodes> findPositionCodesEntities(boolean all,
			int maxResults, int firstResult) {
		Contacts c = new Contacts();
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(PositionCodes.class));
		Query q = entityManager.createQuery(cq);
		return q.getResultList();
	}

	public List<PositionCodeCountV> findPositionCodesCountEntities(boolean all,
			int maxResults, int firstResult) {

		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(PositionCodeCountV.class));
		Query q = entityManager.createQuery(cq);
		return q.getResultList();
	}

	public PositionCodeCountV findPositionCodesCountById(int Id) {
		return entityManager.find(PositionCodeCountV.class, Id);
	}
	public List<MailingHistoryOverall> findMailingIDsCount() {

		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(MailingHistoryOverall.class));
		Query q = entityManager.createQuery(cq);
		return q.getResultList();
	}

	public List<GetPrintLabelV> getPrintingLabels(int mailingID) {
		Query query = entityManager
				.createNamedQuery("GetPrintLabelV.findByMailingID");
		query.setParameter("mailingID", mailingID);
		List<GetPrintLabelV> list = query.getResultList();
		return list;
	}

	public List<Contacts> getContacts() {
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(Contacts.class));
		Query q = entityManager.createQuery(cq);
		return q.getResultList();
	}

	public List<MaterialsAvailable> getAllMaterialsAvailable() {
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(MaterialsAvailable.class));
		Query q = entityManager.createQuery(cq);
		return q.getResultList();
	}
	
	public List<MaterialsAvailable> getMaterialsAvailable() {
		Query q = entityManager
				.createNamedQuery("MaterialsAvailable.findByActive");
		q.setParameter("active", true);
		return q.getResultList();
	}

	public List<MaterialsAvailable> getMaterialsAvailableById(int id) {
		Query q = entityManager
				.createNamedQuery("MaterialsAvailable.findById");
		q.setParameter("id", id);
		return q.getResultList();
	}
	
	public List<MailingHistoryOverall> getMaxMailingHistory() {
		Query q = entityManager.createNamedQuery(
				"MailingHistoryOverall.findMaxId").setMaxResults(1);
		return q.getResultList();
	}

	public List<Contacts> findContactsByPositionCode(String positionCode) {
		Query q = entityManager
				.createNamedQuery("Contacts.findByPositionCodeLike");
		q.setParameter("positionCode", "%" + positionCode + "%");
		return q.getResultList();
	}

	public List<MaterialsAvailable> findMaterialByName(String matName) {
		Query q = entityManager
				.createNamedQuery("MaterialsAvailable.findByMaterialName");
		q.setParameter("materialName", matName);
		return q.getResultList();
	}

	@Transactional
	public void addGroupSelections(String positionCode) {
		GroupSelections grpSel = new GroupSelections();
		grpSel.setGroupsForMailing(positionCode);
		entityManager.persist(grpSel);
		entityManager.flush();
	}

	@Transactional
	public void addMatSelections(String matSelected) {
		MaterialSelections matSel = new MaterialSelections();
		matSel.setMaterialSelection(matSelected);
		entityManager.persist(matSel);
		entityManager.flush();
	}

	@Transactional
	public void removeSelections() {
		entityManager.createQuery("DELETE FROM GroupSelections")
				.executeUpdate();
		entityManager.createQuery("DELETE FROM MaterialSelections")
				.executeUpdate();
		entityManager.flush();
	}

	@Transactional
	public void addMailingHistoryOverall(MailingHistoryOverall m) {
		m.setDateCompleted(Calendar.getInstance().getTime());
		entityManager.persist(m);
		entityManager.flush();
	}

	@Transactional
	public void addListMailingHistoryContacts(
			List<MailingHistoryContacts> listMHC) {
		for (MailingHistoryContacts mhc : listMHC) {
			entityManager.persist(mhc);
			entityManager.flush();
		}
	}

	@Transactional
	public void addListMailingHistoryPositionCodes(
			List<MailingHistoryPositionCodes> listMHPC) {
		for (MailingHistoryPositionCodes mhpc : listMHPC) {
			entityManager.persist(mhpc);
			entityManager.flush();
		}
	}

	@Transactional
	public void addMaterialsAvailable(MaterialsAvailable m) {
		entityManager.persist(m);
		entityManager.flush();
	}
	
//	public String formatJSON(String str){
//		
//		
//		return null;
//		
//	}
}
