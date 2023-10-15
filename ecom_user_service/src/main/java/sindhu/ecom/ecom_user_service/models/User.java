package sindhu.ecom.ecom_user_service.models;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity      // describing the class user will be a entity(or table) in mySQL
@Getter
@Setter
public class User {

@Id                                             // to generate Long id as primary key in mySQL table
@GeneratedValue(strategy = GenerationType.AUTO) // to generate automatic ID in mySQL
private Long id;

private String email;

private String password;

private Date createdAt;

private Date lastModifiedAt;

}
