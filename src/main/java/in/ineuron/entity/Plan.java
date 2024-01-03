package in.ineuron.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN")
public class Plan {
	
	
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getActivesw() {
		return activesw;
	}

	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpadateDate() {
		return upadateDate;
	}

	public void setUpadateDate(LocalDate upadateDate) {
		this.upadateDate = upadateDate;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Id
	@Column(name="Plan_Id")
	@GeneratedValue
	private Integer planId;
	
	@Column(name = "Plan_Name")
	private String planName;
	
	@Column(name = "Plan_StartDate")
	private LocalDate planStartDate;
	
	@Column(name = "Plan_EndDate")
	private LocalDate planEndDate;
	
	@Column(name="Category_ID")
	private Integer categoryId;
	
	@Column(name="Active_SW")
	private String activesw;
	
	@Column(name="Created_By")
	private String createdBy;
	
	@Column(name="Upadated_By")
	private String updatedBy;
	
	@Column(name="Create_Date", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="Update_Date", insertable = false)
	@UpdateTimestamp
	private LocalDate upadateDate;

}
