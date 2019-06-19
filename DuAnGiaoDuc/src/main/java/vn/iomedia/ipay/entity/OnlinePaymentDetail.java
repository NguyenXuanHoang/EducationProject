package vn.iomedia.ipay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "online_payment")
public class OnlinePaymentDetail implements Serializable{
	
    private static final long serialVersionUID = -5047485912577538734L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name = "transaction_id")
	private int transId;
	
	@Column(name = "aggregator_transaction_id")
	private int aggreTransactionId;
	
	@OneToOne(mappedBy = "onlinePaymentDetail")
	private RegistrationDetail registrationDetail;
	   
    @Column (name = "status_transation")
    private boolean statusTrans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getAggreTransactionId() {
		return aggreTransactionId;
	}

	public void setAggreTransactionId(int aggreTransactionId) {
		this.aggreTransactionId = aggreTransactionId;
	}

	public RegistrationDetail getRegistrationDetail() {
		return registrationDetail;
	}

	public void setRegistrationDetail(RegistrationDetail registrationDetail) {
		this.registrationDetail = registrationDetail;
	}

    /**
     * @return the statusTrans
     */
    public boolean isStatusTrans() {
        return statusTrans;
    }

    /**
     * @param statusTrans the statusTrans to set
     */
    public void setStatusTrans(boolean statusTrans) {
        this.statusTrans = statusTrans;
    }
	
	
}
