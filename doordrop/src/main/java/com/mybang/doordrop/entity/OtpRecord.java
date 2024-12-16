package com.mybang.doordrop.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "otp")
public class OtpRecord {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		
		@Column(name = "mobile")
		private String mobile;
		
		@Column(name = "otp")
		private String otp;
		
		@Column(name = "message")
		private String message;
		
		@Column(name = "action")
		private String action;
		
		@Column(name = "status")
		private String status;
		
		@CreationTimestamp
	    private LocalDateTime  created_date;
		
	    @UpdateTimestamp
	    private LocalDateTime  updated_date;
	
}
