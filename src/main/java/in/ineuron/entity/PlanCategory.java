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
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {

	@Id
	@GeneratedValue
	@Column(name="Category_ID")
	private Integer categoryId;
	
	@Column(name="Category_Name")
	private String categoryName;
	
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

	public String getCategoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCategoryId() {
		// TODO Auto-generated method stub
		return null;
	}

}
